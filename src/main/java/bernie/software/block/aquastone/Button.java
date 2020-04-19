package bernie.software.block.aquastone;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class Button {
    public static Block constructBlock(AbstractButtonBlock button) {
        return WaterloggedButton.toWaterlogged(button);
    }
    public static class WaterloggedButton extends AbstractButtonBlock implements IWaterLoggable {
        public AbstractButtonBlock button;
        public WaterloggedButton(boolean isWooden, Properties properties) {
            super(isWooden, properties);
        }
        public static WaterloggedButton toWaterlogged(AbstractButtonBlock source) {
            Properties prop=Properties.from(source);
            return new WaterloggedButton(source instanceof WoodButtonBlock,prop).setSourceButton(source);
        }

        public WaterloggedButton setSourceButton(AbstractButtonBlock sourceButton) {
            this.button=sourceButton;
            return this;
        }

        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(HORIZONTAL_FACING, POWERED, FACE, WATERLOGGED);
        }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context)
        {
            return super.getStateForPlacement(context).with(WATERLOGGED, false);
        }

        public IFluidState getFluidState(BlockState state)
        {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
        }

        @Override
        protected SoundEvent getSoundEvent(boolean p_196369_1_) {
            try {
                if (button instanceof StoneButtonBlock) {
                    return p_196369_1_ ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
                } else if (button instanceof StoneButtonBlock) {
                    return p_196369_1_ ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
                }
            } catch (Exception err) {}
            return null;
        }
    }
}
