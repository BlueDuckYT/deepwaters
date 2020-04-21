package bernie.software.block.aquastone;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class RedstoneTorch {
    public static class Item extends WallOrFloorItem {
        public Item(Block floorBlock, Block wallBlockIn, Properties propertiesIn) {
            super(floorBlock, wallBlockIn, propertiesIn);
        }
        public Item(net.minecraft.item.Item.Properties propertiesIn) {
            super(DeepWatersBlocks.AQUA_TORCH.get(),DeepWatersBlocks.AQUA_TORCH_WALL.get(),propertiesIn);
        }
    }
    public static class AquastoneTorch extends RedstoneTorchBlock implements IWaterLoggable {
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
        {
            builder.add(LIT, WATERLOGGED);
        }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context)
        {
            try {
                return super.getStateForPlacement(context).with(WATERLOGGED,false);
            } catch (Exception err) {
                return super.getStateForPlacement(context);
            }
        }

        public IFluidState getFluidState(BlockState state)
        {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
        }

        public AquastoneTorch() {
            super(Block.Properties.create(Material.ROCK).doesNotBlockMovement());
        }

        @Override
        public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            if (blockState.get(WATERLOGGED)) {
                return super.getWeakPower(blockState,blockAccess,pos,side);
            } else {
                return super.getWeakPower(blockState,blockAccess,pos,side)/2;
            }
        }
    }
    public static class AquastoneTorchWall extends RedstoneWallTorchBlock implements IWaterLoggable {
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
        {
            builder.add(FACING, REDSTONE_TORCH_LIT, WATERLOGGED);
        }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext context)
        {
            try {
                return super.getStateForPlacement(context).with(WATERLOGGED,false);
            } catch (Exception err) {
                return super.getStateForPlacement(context);
            }
        }

        public IFluidState getFluidState(BlockState state)
        {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
        }

        public AquastoneTorchWall() {
            super(Block.Properties.create(Material.ROCK).doesNotBlockMovement());
        }

        @Override
        public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            if (blockState.get(WATERLOGGED)) {
                return super.getWeakPower(blockState,blockAccess,pos,side);
            } else {
                return super.getWeakPower(blockState,blockAccess,pos,side)/2;
            }
        }
    }
}
