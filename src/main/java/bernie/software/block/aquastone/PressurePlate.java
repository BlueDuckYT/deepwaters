package bernie.software.block.aquastone;

import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Iterator;
import java.util.Random;

import static bernie.software.block.aquastone.AquastoneRepeater.WATERLOGGED;

public class PressurePlate {
    public static PressurePlateBlock makeWaterloggable(PressurePlateBlock source) {
        return waterlogged.makeWaterlogged(PressurePlateBlock.Sensitivity.EVERYTHING,source).setSourceButton(source);
    }
    public static WeightedPressurePlateBlock makeWaterloggable(WeightedPressurePlateBlock source) {
        return waterloggedweighted.makeWaterlogged(source).setSourceButton(source);
    }
    public static class waterlogged extends PressurePlateBlock {
        public AbstractPressurePlateBlock button;
        public waterlogged(Sensitivity sensitivityIn, Properties propertiesIn) {
            super(sensitivityIn, propertiesIn);
        }

        public static waterlogged makeWaterlogged(Sensitivity sensitivity,PressurePlateBlock source) {
            try {
                return new waterlogged(sensitivity,(Properties.from(source)));
            } catch (Exception err) {
            }
            return new waterlogged(sensitivity,(Properties.from(Blocks.DIRT)));
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            super.fillStateContainer(builder);
            try {
                Iterator<IProperty<?>> propertyIterator=button.getDefaultState().getProperties().iterator();
                while (propertyIterator.hasNext()) {
                    try {
                        builder.add(propertyIterator.next());
                    } catch (Exception err) {}
                }
            } catch (Exception err) {}
            builder.add(WATERLOGGED);
        }

        @Override
        public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
            button.onEntityCollision(state, worldIn, pos, entityIn);
        }

        @Override
        public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
            button.tick(state, worldIn, pos, random);
        }

        @Override
        protected int computeRedstoneStrength(World worldIn, BlockPos pos) {
            return 0;
        }

        @Override
        public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            return button.getWeakPower(blockState, blockAccess, pos, side);
        }

        @Override
        public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            return button.getStrongPower(blockState, blockAccess, pos, side);
        }

        public PushReaction getPushReaction(BlockState state) {
            return PushReaction.DESTROY;
        }

        public PressurePlate.waterlogged setSourceButton(AbstractPressurePlateBlock sourceButton) {
            this.button=sourceButton;
            return this;
        }

        @Override
        public int tickRate(IWorldReader worldIn) {
            return button.tickRate(worldIn);
        }
    }
    public static class waterloggedweighted extends WeightedPressurePlateBlock {
        public AbstractPressurePlateBlock button;

        protected waterloggedweighted(int p_i48295_1_, Properties p_i48295_2_) {
            super(p_i48295_1_, p_i48295_2_);
        }

        public static waterloggedweighted makeWaterlogged(WeightedPressurePlateBlock source) {
            try {
                return new waterloggedweighted(15,(Properties.from(source)));
            } catch (Exception err) {
            }
            return new waterloggedweighted(15,(Properties.from(Blocks.DIRT)));
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
            super.fillStateContainer(builder);
            try {
                Iterator<IProperty<?>> propertyIterator=button.getDefaultState().getProperties().iterator();
                while (propertyIterator.hasNext()) {
                    try {
                        builder.add(propertyIterator.next());
                    } catch (Exception err) {}
                }
            } catch (Exception err) {}
            builder.add(WATERLOGGED);
        }

        @Override
        public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
            button.onEntityCollision(state, worldIn, pos, entityIn);
        }

        @Override
        public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
            button.tick(state, worldIn, pos, random);
        }

        @Override
        public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            return button.getWeakPower(blockState, blockAccess, pos, side);
        }

        @Override
        public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
            return button.getStrongPower(blockState, blockAccess, pos, side);
        }

        @Override
        public int tickRate(IWorldReader worldIn) {
            return button.tickRate(worldIn);
        }

        public PushReaction getPushReaction(BlockState state) {
            return PushReaction.DESTROY;
        }

        public PressurePlate.waterloggedweighted setSourceButton(AbstractPressurePlateBlock sourceButton) {
            this.button=sourceButton;
            return this;
        }
    }
}
