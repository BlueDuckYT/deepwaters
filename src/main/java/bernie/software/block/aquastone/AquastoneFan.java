package bernie.software.block.aquastone;

import bernie.software.block.BubbleSource;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersTileEntities;
import bernie.software.tileentity.TileEntityAquaFan;
import bernie.software.utils.CollisionUtils;
import net.minecraft.block.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.*;

import javax.annotation.Nullable;

public class AquastoneFan extends BubbleSource implements ITileEntityProvider {
    public AquastoneFan(Properties properties) {
        super(properties);
    }

    public static BooleanProperty ACTIVE=BooleanProperty.create("active");
    public static BooleanProperty HAS_SOUL_SAND=BooleanProperty.create("has_soul_sand");
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ACTIVE,DropperBlock.FACING,StairsBlock.WATERLOGGED,HAS_SOUL_SAND);
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction placementDir=context.getPlacementHorizontalFacing();
        double maxOffHorizontal=Math.max(
                Math.abs(Math.abs(context.getPlayer().getPosX())-Math.abs(context.getHitVec().getX())),
                Math.abs(Math.abs(context.getPlayer().getPosZ())-Math.abs(context.getHitVec().getZ()))
            );
        int divisor=2;
        if (maxOffHorizontal<=(context.getPlayer().getPosY()-context.getHitVec().getY())/divisor) {
            placementDir=Direction.DOWN;
        } else if (maxOffHorizontal<=Math.abs(context.getPlayer().getPosY()-context.getHitVec().getY())/divisor) {
            placementDir=Direction.UP;
        }
        int sources=0;
        if (context.getWorld().getBlockState(context.getPos().offset(Direction.EAST)).getBlockState().getFluidState().equals(Blocks.WATER.getDefaultState().getFluidState())) {
            sources++;
        }
        if (context.getWorld().getBlockState(context.getPos().offset(Direction.WEST)).getBlockState().getFluidState().equals(Blocks.WATER.getDefaultState().getFluidState())) {
            sources++;
        }
        if (context.getWorld().getBlockState(context.getPos().offset(Direction.SOUTH)).getBlockState().getFluidState().equals(Blocks.WATER.getDefaultState().getFluidState())) {
            sources++;
        }
        if (context.getWorld().getBlockState(context.getPos().offset(Direction.NORTH)).getBlockState().getFluidState().equals(Blocks.WATER.getDefaultState().getFluidState())) {
            sources++;
        }
        System.out.println(sources);
        BlockState newState=this.getDefaultState().with(DropperBlock.FACING,placementDir.getOpposite()).with(ACTIVE,context.getWorld().isBlockPowered(context.getPos()));
        context.getWorld().notifyBlockUpdate(context.getPos(),context.getWorld().getBlockState(context.getPos()),newState,0);
        return newState.with(StairsBlock.WATERLOGGED,sources>=2).with(HAS_SOUL_SAND,false);
    }
    
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            if (!state.get(HAS_SOUL_SAND)) {
                if (player.getHeldItem(handIn).getItem().equals(Items.SOUL_SAND)) {
                    return ActionResultType.SUCCESS;
                }
            } else if (player.getHeldItem(handIn).getItem().equals(Items.AIR)) {
                return ActionResultType.SUCCESS;
            }
            return ActionResultType.PASS;
        }
        if (!state.get(HAS_SOUL_SAND)) {
            if (player.getHeldItem(handIn).getItem().equals(Items.SOUL_SAND)) {
                worldIn.setBlockState(pos,state.with(HAS_SOUL_SAND,true));
//                player.setHeldItem(handIn,);
                if (!player.isCreative())
                player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount()-1);
                return ActionResultType.SUCCESS;
            }
        } else if (player.getHeldItem(handIn).getItem().equals(Items.AIR)) {
            worldIn.setBlockState(pos,state.with(HAS_SOUL_SAND,false));
            if (!player.isCreative())
            player.setHeldItem(handIn,new ItemStack(Items.SOUL_SAND));
            return ActionResultType.SUCCESS;
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    
    @Override
    public boolean canConnectRedstone(BlockState state, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        return false;
    }
    
    @Override
    public boolean isSource(Direction side, IWorldReader world, BlockPos pos, BlockState state) {
        return state.get(DropperBlock.FACING).equals(side)&&state.get(ACTIVE);
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        CollisionUtils.RotateableShape shape=new CollisionUtils.RotateableShape(0,0,4,16,16,8);
        shape=shape.rotate(state.get(DropperBlock.FACING));
        return shape.toVoxel();
    }
    
    @Override
    public BlockState getBubbleState(BlockState state) {
        return DeepWatersBlocks.ENTITYPUSHER.get().getDefaultState().with(DropperBlock.FACING,state.get(DropperBlock.FACING)).with(HAS_SOUL_SAND,state.get(HAS_SOUL_SAND));
    }
    
    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        super.onPlayerDestroy(worldIn, pos, state);
    }
    
    @Override
    public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity player, boolean willHarvest, IFluidState fluid) {
        if (state.get(HAS_SOUL_SAND)) {
            if (!player.isCreative()) {
                world.addEntity(new ItemEntity(world,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(Items.SOUL_SAND)));
            }
        }
        return super.removedByPlayer(state,world,pos,player,willHarvest,fluid);
    }
    
    @Override
    public boolean shouldDisplayFluidOverlay(BlockState state, ILightReader world, BlockPos pos, IFluidState fluidState) {
        return state.get(StairsBlock.WATERLOGGED);
    }
    
    @Override
    public IFluidState getFluidState(BlockState state) {
        return state.get(StairsBlock.WATERLOGGED)?Fluids.WATER.getStillFluidState(false):Blocks.AIR.getDefaultState().getFluidState();
    }
    
    @Override
    public boolean shouldGetDeleted() {
        return false;
    }
    
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        BlockState newState=state.with(ACTIVE,worldIn.isBlockPowered(pos));
        if (!newState.equals(state)) {
            worldIn.setBlockState(pos,newState);
        }
        super.neighborChanged(newState, worldIn, pos, blockIn, fromPos, isMoving);
    }
    
    @Nullable
    @Override
    public net.minecraft.tileentity.TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityAquaFan();
    }
}
