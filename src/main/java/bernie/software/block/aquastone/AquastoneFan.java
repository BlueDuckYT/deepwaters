package bernie.software.block.aquastone;

import bernie.software.block.BubbleSource;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.registry.DeepWatersTileEntities;
import bernie.software.utils.CollisionUtils;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.ILightReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AquastoneFan extends BubbleSource implements ITileEntityProvider {
    public AquastoneFan(Properties properties) {
        super(properties);
    }

    public static BooleanProperty ACTIVE=BooleanProperty.create("active");
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ACTIVE,DropperBlock.FACING,StairsBlock.WATERLOGGED);
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
        BlockState newState=this.getDefaultState().with(DropperBlock.FACING,placementDir.getOpposite()).with(ACTIVE,context.getWorld().isBlockPowered(context.getPos()));
        context.getWorld().notifyBlockUpdate(context.getPos(),context.getWorld().getBlockState(context.getPos()),newState,0);
        return newState;
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
        return DeepWatersBlocks.ENTITYPUSHER.get().getDefaultState().with(DropperBlock.FACING,state.get(DropperBlock.FACING));
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
        return new TileEntity();
    }
    
    public static class TileEntity extends net.minecraft.tileentity.TileEntity {
        public TileEntity() {
            super(DeepWatersTileEntities.AQUASTONE_FAN.get());
        }

        public float rotation=0;
    }
}
