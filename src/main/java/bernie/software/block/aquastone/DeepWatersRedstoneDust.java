package bernie.software.block.aquastone;

import bernie.software.DeepWatersMod;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.block.*;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DeepWatersRedstoneDust extends RedstoneWireBlock implements IWaterLoggable {
    public DeepWatersRedstoneDust(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, POWER, WATERLOGGED);
    }

    @Override
    public BlockState getExtendedState(BlockState state, IBlockReader worldIn, BlockPos pos) {
        BlockState state1=worldIn.getBlockState(pos);
        state1=state1.with(NORTH,getSide(worldIn,pos,Direction.NORTH));
        state1=state1.with(SOUTH,getSide(worldIn,pos,Direction.SOUTH));
        state1=state1.with(EAST,getSide(worldIn,pos,Direction.EAST));
        state1=state1.with(WEST,getSide(worldIn,pos,Direction.WEST));
        return state1;
    }

//    @Override
//    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return new VoxelShapeArray(new BitSetVoxelShapePart(0, 0, 0), (DoubleList)(new DoubleArrayList(new double[]{0.0D})), (DoubleList)(new DoubleArrayList(new double[]{0.0D})), (DoubleList)(new DoubleArrayList(new double[]{0.0D})));
//    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        Block block = blockState.getBlock();
        if (block instanceof RedstoneWireBlock) {
            return true;
        } else if (blockState.getBlock() == Blocks.REPEATER) {
            Direction direction = blockState.get(RepeaterBlock.HORIZONTAL_FACING);
            return direction == side || direction.getOpposite() == side;
        } else if (Blocks.OBSERVER == blockState.getBlock()) {
            return side == blockState.get(ObserverBlock.FACING);
        } else {
            return blockState.canConnectRedstone(world, pos, side) && side != null;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(WATERLOGGED,false);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    private RedstoneSide getSide(IBlockReader worldIn, BlockPos pos, Direction face) {
        BlockPos blockpos = pos.offset(face);
        BlockState blockstate = worldIn.getBlockState(blockpos);
        BlockPos blockpos1 = blockpos.offset(Direction.UP);
        BlockState blockstate1 = worldIn.getBlockState(blockpos1);
        if (canConnectTo(blockstate,worldIn,blockpos,face)||
            canConnectTo(worldIn.getBlockState(blockpos.offset(Direction.DOWN)),worldIn,blockpos.offset(Direction.DOWN),null)||
            blockstate.getBlock() instanceof RedstoneWireBlock||
            worldIn.getBlockState(blockpos.offset(Direction.DOWN)).getBlock() instanceof DeepWatersRedstoneDust||
            worldIn.getBlockState(blockpos.offset(Direction.DOWN)).getBlock() instanceof RedstoneWireBlock) {
            return RedstoneSide.SIDE;
        }
        if ((blockstate1.getBlock() instanceof RedstoneWireBlock)) {
            return RedstoneSide.UP;
        }
        return RedstoneSide.NONE;
    }

    boolean canProvidePower=true;
    private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        BlockState state1=worldIn.getBlockState(pos);
        state1=state1.with(NORTH,getSide(worldIn,pos,Direction.NORTH));
        state1=state1.with(SOUTH,getSide(worldIn,pos,Direction.SOUTH));
        state1=state1.with(EAST,getSide(worldIn,pos,Direction.EAST));
        state1=state1.with(WEST,getSide(worldIn,pos,Direction.WEST));
        worldIn.setBlockState(pos,state1);
        if (!worldIn.isRemote) {
            if (state.isValidPosition(worldIn, pos)) {
                BlockPos[] poses=new BlockPos[]{
                        new BlockPos(1,0,0),
                        new BlockPos(0,0,1),
                        new BlockPos(0,0,-1),
                        new BlockPos(-1,0,0)
                };
                BlockState newState=state;
                int oldPower=state.get(POWER);
                for (BlockPos pos1:poses) {
                    newState = forcePower(pos,pos1,worldIn,oldPower);
                }
                try {
                    boolean shouldUpdateDown=true;
                    for (Direction dir:Direction.values()) {
                        if (worldIn.getBlockState(pos.offset(Direction.DOWN).offset(dir)).getBlock() instanceof RedstoneWireBlock) {
                            shouldUpdateDown=false;
                        }
                    }
                    if (shouldUpdateDown) {
                    }
//                    worldIn.notifyNeighborsOfStateExcept(pos.offset(Direction.UP),this,Direction.DOWN);
                    worldIn.notifyNeighborsOfStateExcept(pos.offset(Direction.DOWN),this,Direction.UP);
                } catch (Exception err) {}
            } else {
                spawnDrops(state, worldIn, pos);
                worldIn.removeBlock(pos, false);
            }
        }
    }

    @Override
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return getAqualitePower(pos,blockAccess)-2;
    }

    public int getAqualitePower(BlockPos pos,World world) {
        int power=world.getRedstonePowerFromNeighbors(pos);
        if (power<world.getStrongPower(pos)) {
            power=world.getStrongPower(pos)+1;
        }
        int aquaPower=getAqualitePower(pos,(IBlockReader)world);
        if (power<aquaPower) {
            power=aquaPower;
        }
        return power;
    }

    @Override
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return getWeakPower(blockState,blockAccess,pos,side);
    }

    @Override
    public void updateDiagonalNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags) {
//        super.updateDiagonalNeighbors(state, worldIn, pos, flags);
    }

    @Override
    public boolean shouldCheckWeakPower(BlockState state, IWorldReader world, BlockPos pos, Direction side) {
        return false;
    }

    public int getAqualitePower(BlockPos pos, IBlockReader world) {
        int power=0;
        BlockPos[] direct=new BlockPos[]{
                new BlockPos(1,0,0),
                new BlockPos(0,0,1),
                new BlockPos(0,0,-1),
                new BlockPos(-1,0,0)
        };
        if (world.getBlockState(pos.offset(Direction.DOWN)).isOpaqueCube(world,pos.offset(Direction.DOWN))) {
            BlockPos[] indirect=new BlockPos[] {
                    new BlockPos(1,-1,0),
                    new BlockPos(0,-1,1),
                    new BlockPos(0,-1,-1),
                    new BlockPos(-1,-1,0)
            };
            for (BlockPos pos1:indirect) {
                if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock) {
                    if (world.getBlockState(pos.add(pos1)).get(POWER)>power) {
                        if (!world.getBlockState(pos.add(pos1.offset(Direction.UP))).isOpaqueCube(world,pos.add(pos1.offset(Direction.UP)))) {
                            if (world.getBlockState(pos.add(pos1)).get(POWER)!=power) {
                                power=world.getBlockState(pos.add(pos1)).get(POWER);
                            }
                        }
                    }
                }
            }
        }
        for (BlockPos pos1:direct) {
            if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock) {
                if (world.getBlockState(pos.add(pos1)).get(POWER)>power) {
                    if (world.getBlockState(pos.add(pos1)).get(POWER)!=power) {
                        power=world.getBlockState(pos.add(pos1)).get(POWER);
                    }
                }
            }
        }
        BlockPos[] indirect=new BlockPos[]{
                new BlockPos(1,1,0),
                new BlockPos(0,1,1),
                new BlockPos(0,1,-1),
                new BlockPos(-1,1,0)
        };
        for (BlockPos pos1:indirect) {
            if (world.getBlockState(pos.add(pos1.offset(Direction.DOWN))).isOpaqueCube(world,pos.add(pos1.offset(Direction.DOWN)))) {
                if (world.getBlockState(pos.add(pos1)).getBlock() instanceof RedstoneWireBlock) {
                    if (world.getBlockState(pos.add(pos1)).get(POWER)>power) {
                        if (world.getBlockState(pos.add(pos1)).get(POWER)!=power) {
                            if (world.getBlockState(pos.add(pos1.offset(Direction.DOWN))).isSolid()) {
                                power=world.getBlockState(pos.add(pos1)).get(POWER);
                            }
                        }
                    }
                }
            }
        }
        return power;
    }
    public void tryChangeBlock(BlockPos source,BlockPos offset,World world,int sourcePower) {
        if (world.getBlockState(source.add(offset)).getBlock() instanceof RedstoneWireBlock) {
            if (world.getBlockState(source.add(offset)).get(POWER)<world.getRedstonePowerFromNeighbors(source)) {
                try {
                    if (sourcePower>world.getBlockState(source.add(offset)).get(POWER)) {
                        world.setBlockState(source.add(offset),world.getBlockState(source.add(offset)).with(POWER,sourcePower-2),4);
                    } else {
                        world.setBlockState(source.add(offset),world.getBlockState(source.add(offset)).with(POWER,0),4);
                    }
                } catch (Exception err) {}
            }
        }
    }
    public BlockState forcePower(BlockPos source,BlockPos offset,World world,int oldPower) {
        int subtractAmount=1;
        if (!world.getBlockState(source).get(WATERLOGGED)) {
            subtractAmount=2;
        }
        int power=getAqualitePower(source,world)-subtractAmount;
//        DeepWatersMod.logger.log(Level.INFO,power+subtractAmount);
        if (power<=0) {
            power=0;
        }
        if (power>oldPower) {
            try {
                tryChangeBlock(source,offset,world,power);
                if (!world.getBlockState(source.offset(Direction.UP)).isOpaqueCube(world,source.offset(Direction.UP))) {
                    try {
                        tryChangeBlock(source,offset.offset(Direction.UP),world,power);
                    } catch (Exception err) {}
                }
                if (world.getBlockState(source.offset(Direction.DOWN)).isOpaqueCube(world,source.offset(Direction.DOWN))) {
                    try {
                        tryChangeBlock(source,offset.offset(Direction.DOWN),world,power);
                    } catch (Exception err) {}
                }
                try {
                    world.setBlockState(source,world.getBlockState(source).with(POWER,power));
                } catch (Exception err) {}
            } catch (Exception err) {}
        } else {
            if (power!=oldPower) {
                try {
                    try {
                        world.setBlockState(source,world.getBlockState(source).with(POWER,0));
                    } catch (Exception err) {}
                    try {
                        world.setBlockState(source.add(offset),world.getBlockState(source.add(offset)).with(POWER,0));
                    } catch (Exception err) {}
                    try {
                        world.setBlockState(source.add(offset.offset(Direction.UP)),world.getBlockState(source.add(offset.offset(Direction.UP))).with(POWER,0));
                    } catch (Exception err) {}
                    try {
                        world.setBlockState(source.add(offset.offset(Direction.DOWN)),world.getBlockState(source.add(offset.offset(Direction.DOWN))).with(POWER,0));
                    } catch (Exception err) {}
                } catch (Exception err) {
                }
            }
        }
        return world.getBlockState(source);
    }
    private BlockState updateSurroundingRedstone(World worldIn, BlockPos pos, BlockState state) {
        state = this.getState(worldIn, pos, state);
        List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();

        for(BlockPos blockpos : list) {
//            worldIn.notifyNeighborsOfStateChange(blockpos, this);
        }

        return state;
    }
    private int maxSignal(int existingSignal, BlockState neighbor) {
        if (neighbor.getBlock() != this) {
            return existingSignal;
        } else {
            int i = neighbor.get(POWER);
            return i > existingSignal ? i : existingSignal;
        }
    }
    private BlockState getState(World world, BlockPos pos, BlockState state) {
        BlockState blockstate = state;
        int i = state.get(POWER);
//        this.canProvidePower = false;
        int highestNeighborPower = world.getRedstonePowerFromNeighbors(pos);
//        this.canProvidePower = true;
        int thisPower = 0;
        if (highestNeighborPower < 15) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                BlockPos blockpos = pos.offset(direction);
                BlockState blockstate1 = world.getBlockState(blockpos);
                thisPower = this.maxSignal(thisPower, blockstate1);
                BlockPos blockpos1 = pos.up();
                if (blockstate1.isNormalCube(world, blockpos) && !world.getBlockState(blockpos1).isNormalCube(world, blockpos1)) {
                    thisPower = this.maxSignal(thisPower, world.getBlockState(blockpos.up()));
                } else if (!blockstate1.isNormalCube(world, blockpos)) {
                    thisPower = this.maxSignal(thisPower, world.getBlockState(blockpos.down()));
                }
            }
        }

        int setPower = thisPower - 1;
        if (highestNeighborPower > setPower) {
            setPower = highestNeighborPower-1;
        }

        if (i != setPower) {
            state = state.with(POWER, Integer.valueOf(setPower));
            if (world.getBlockState(pos) == blockstate) {
                world.setBlockState(pos, state, 16);
            }

            this.blocksNeedingUpdate.add(pos);

            for(Direction direction1 : Direction.values()) {
                this.blocksNeedingUpdate.add(pos.offset(direction1));
            }
        }

        return state;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return true;
    }

    public static class colors implements IBlockColor {
        @Override
        public int getColor(BlockState p_getColor_1_, @Nullable IEnviromentBlockReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
            try {
                float power=(p_getColor_1_.get(POWER)-0)/15f;
                int color1R=2;
                int color1G=188;
                int color1B=255;
                int color2R=0;
                int color2G=24;
                int color2B=33;
                float fade=((power)*1);
                int red=(int)(((fade*color1R)+((1-fade)*color2R))*1);
                int gre=(int)(((fade*color1G)+((1-fade)*color2G))*1);
                int blu=(int)(((fade*color1B)+((1-fade)*color2B))*1);
                Color color=new Color(red,gre,blu);
                return color.getRGB();
            } catch (Exception err) {
                return 0;
            }
        }
    }
}
