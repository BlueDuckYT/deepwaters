package bernie.software.block.aquastone;

import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class AquastoneButton
{
	public static Block constructBlock(AbstractButtonBlock button)
	{
		return WaterloggedButton.toWaterlogged(button);
	}

	public static class WaterloggedButton extends AbstractButtonBlock implements IWaterLoggable
	{
		public AbstractButtonBlock button;

		public WaterloggedButton(boolean isWooden, Properties properties)
		{
			super(isWooden, properties);
		}

		public static WaterloggedButton toWaterlogged(AbstractButtonBlock source)
		{
			Properties prop = Properties.from(source);
			return new WaterloggedButton(source instanceof WoodButtonBlock, prop).setSourceButton(source);
		}

		public WaterloggedButton setSourceButton(AbstractButtonBlock sourceButton)
		{
			this.button = sourceButton;
			return this;
		}

		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
		{
			builder.add(HORIZONTAL_FACING, POWERED, FACE, WATERLOGGED);
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context)
		{
			try
			{
				return super.getStateForPlacement(context).with(WATERLOGGED, false);
			}
			catch (Exception err)
			{
				return super.getStateForPlacement(context);
			}
		}

		public IFluidState getFluidState(BlockState state)
		{
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		protected SoundEvent getSoundEvent(boolean p_196369_1_)
		{
			try
			{
				if (button instanceof StoneButtonBlock)
				{
					return p_196369_1_ ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
				}
				else if (button instanceof StoneButtonBlock)
				{
					return p_196369_1_ ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
				}
			}
			catch (Exception err)
			{
			}
			return null;
		}

		public PushReaction getPushReaction(BlockState state)
		{
			return PushReaction.DESTROY;
		}

		@Override
		public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
			return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
		}

		@Override
		public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
			return true;//state.get(TYPE) != SlabType.DOUBLE ? IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn) : false;
		}

		@Deprecated
		public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
			if (!stateIn.get(BlockStateProperties.WATERLOGGED)) {
				this.receiveFluid(worldIn, currentPos, stateIn, Fluids.WATER.getStillFluidState(false));
			}
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}

		public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
			return Fluids.EMPTY;
		}
	}
}
