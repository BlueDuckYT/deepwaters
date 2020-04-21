package bernie.software.block.aquastone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AquastoneComparator extends ComparatorBlock implements IWaterLoggable
{
	public AquastoneComparator(Properties properties)
	{
		super(properties);
	}

	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(HORIZONTAL_FACING, MODE, POWERED, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		return super.getStateForPlacement(context).with(WATERLOGGED, false);
	}

	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
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
			return super.getDelay(p_196346_1_)*2;
		}
	}

	@Override
	protected int getActiveSignal(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (state.get(WATERLOGGED)) {
			return super.getActiveSignal(worldIn, pos, state);
		} else {
			return (int)(super.getActiveSignal(worldIn, pos, state)/1.5f);
		}
	}
}
