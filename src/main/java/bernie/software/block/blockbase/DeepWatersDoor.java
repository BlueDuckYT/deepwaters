package bernie.software.block.blockbase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import static net.minecraft.block.TrapDoorBlock.WATERLOGGED;

public class DeepWatersDoor extends DoorBlock {

    public DeepWatersDoor(Properties builder) {
        super(builder.notSolid());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public StateContainer<Block, BlockState> getStateContainer() {
        return super.getStateContainer();
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
        Direction[] dirs=new Direction[]{
                Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        };
        int sidesWithWater=0;
        for (Direction direction:dirs) {
            if (worldIn.getBlockState(pos.offset(direction)).getFluidState().getFluid() instanceof WaterFluid) {
                sidesWithWater+=1;
            }
        }
        if (!(oldState.getBlock() instanceof DeepWatersDoor)) {
            if (sidesWithWater<=2) {
                worldIn.setBlockState(pos,state.with(WATERLOGGED,false));
            }
        }
    }


    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
        if (!worldIn.isRemote) {
            if (state.get(WATERLOGGED)) {
                worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
            }
        }
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
