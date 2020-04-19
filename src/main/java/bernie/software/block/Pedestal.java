package bernie.software.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Pedestal extends Block implements IWaterLoggable {
    public Pedestal(Properties properties) {
        super(properties);
    }

    public Pedestal() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(-1f, -1f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape shape=VoxelShapes.or(Block.makeCuboidShape(5.0D, 3.0D, 5.0D, 11.0D, 7.0D, 11.0D),Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 3.0D, 10.0D));
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }

    public static final EnumProperty ROTATION = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HASHEART = BooleanProperty.create("hasheart");

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, WATERLOGGED, HASHEART);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context).with(ROTATION,context.getPlacementHorizontalFacing()).with(WATERLOGGED,false).with(HASHEART,false);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getHeldItem(handIn).getItem().equals(Items.HEART_OF_THE_SEA)) {
            if (!worldIn.getBlockState(pos).get(HASHEART)) {
                worldIn.setBlockState(pos,state.with(HASHEART,true));
                if (!player.isCreative()) {
                    player.getHeldItem(handIn).shrink(1);
                }
            }
            return true;
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    public BlockState getStateForPlacement(BlockItemUseContext context,boolean identifier) {
        return this.getDefaultState().with(ROTATION, context.getPlacementHorizontalFacing().getOpposite());
    }
}
