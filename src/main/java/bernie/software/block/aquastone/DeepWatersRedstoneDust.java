package bernie.software.block.aquastone;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.Set;

public class DeepWatersRedstoneDust extends RedstoneWireBlock implements IWaterLoggable {
    public DeepWatersRedstoneDust(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return canProvidePower;
    }
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, POWER, WATERLOGGED);
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        Block block = blockState.getBlock();
        if (block == Blocks.REDSTONE_WIRE) {
            return false;
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

    boolean canProvidePower=true;
    private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            if (state.isValidPosition(worldIn, pos)) {
                BlockPos[] poses=new BlockPos[]{
                        new BlockPos(1,0,0),
                        new BlockPos(0,0,1),
                        new BlockPos(0,0,-1),
                        new BlockPos(-1,0,0)
                };
                BlockState newState=state;
                for (BlockPos pos1:poses) {
                    newState = forcePower(pos,pos1,worldIn);
                }
                try {
                    updateSurroundingRedstone(worldIn,pos,newState);
                } catch (Exception err) {}
            } else {
                spawnDrops(state, worldIn, pos);
                worldIn.removeBlock(pos, false);
            }
        }
    }
    public int getAqualitePower(BlockPos pos,World world) {
        int power=world.getRedstonePowerFromNeighbors(pos);
        if (power<world.getStrongPower(pos)) {
            power=world.getStrongPower(pos)+1;
        }
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
    public BlockState forcePower(BlockPos source,BlockPos offset,World world) {
        if (world.getBlockState(source.add(offset)).getBlock() instanceof RedstoneWireBlock) {
            if (world.getBlockState(source.add(offset)).get(POWER)<world.getRedstonePowerFromNeighbors(source)) {
                if (world.getRedstonePowerFromNeighbors(source)>0) {
                    if (world.getRedstonePowerFromNeighbors(source)>world.getBlockState(source).get(POWER)) {
                        try {
                            world.setBlockState(source.add(offset),world.getBlockState(source.add(offset)).with(POWER,world.getRedstonePowerFromNeighbors(source)-2));
                        } catch (Exception err) {}
                    }
                }
            }
        }
        try {
            int newPower=getAqualitePower(source,world)-1;
            if (world.getBlockState(source).get(POWER)!=newPower) {
                world.setBlockState(source,world.getBlockState(source).with(POWER,newPower));
                world.notifyNeighborsOfStateChange(source.add(offset),world.getBlockState(source.add(offset)).getBlock());
            }
        } catch (Exception err) {}
        return world.getBlockState(source);
    }
    private BlockState updateSurroundingRedstone(World worldIn, BlockPos pos, BlockState state) {
        state = this.getState(worldIn, pos, state);
        List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();

        for(BlockPos blockpos : list) {
            worldIn.notifyNeighborsOfStateChange(blockpos, this);
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
        this.canProvidePower = false;
        int highestNeighborPower = world.getRedstonePowerFromNeighbors(pos);
        this.canProvidePower = true;
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
                world.setBlockState(pos, state, 2);
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
                float power=(2f/(p_getColor_1_.get(POWER)));
                int color1R=2;
                int color1G=188;
                int color1B=255;
                int color2R=0;
                int color2G=24;
                int color2B=33;
                float fade=((power)/2);
                int red=(int)(((fade*color1R)+((1-fade)*color2R))*1.5f);
                int gre=(int)(((fade*color1G)+((1-fade)*color2G))*1.5f);
                int blu=(int)(((fade*color1B)+((1-fade)*color2B))*1.5f);
                Color color=new Color(red,gre,blu);
                return color.getRGB();
            } catch (Exception err) {
                return 0;
            }
        }
    }
}
