package bernie.software.block.aquastone;

import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class AquastoneRepeater extends RepeaterBlock implements IWaterLoggable
{
	public AquastoneRepeater(Properties properties)
	{
		super(properties);
	}

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(HORIZONTAL_FACING, DELAY, LOCKED, POWERED, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
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
		return sources>=2 ? super.getStateForPlacement(context).with(WATERLOGGED, true) : super.getStateForPlacement(context).with(WATERLOGGED, false);
	}

	public IFluidState getFluidState(BlockState state)
	{
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	protected int getDelay(BlockState p_196346_1_) {
		if (p_196346_1_.get(WATERLOGGED)) {
			return super.getDelay(p_196346_1_);
		} else {
			return super.getDelay(p_196346_1_)*4;
		}
	}

	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	protected int getActiveSignal(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (state.get(WATERLOGGED)) {
			return super.getActiveSignal(worldIn, pos, state);
		} else {
			return (int)(super.getActiveSignal(worldIn, pos, state)/1.25f);
		}
	}
}
