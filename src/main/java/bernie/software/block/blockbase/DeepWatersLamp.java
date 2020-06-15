package bernie.software.block.blockbase;

import bernie.software.utils.CollisionUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class DeepWatersLamp extends Block {
    public DeepWatersLamp(Properties properties) {
        super(properties);
    }

    public DeepWatersLamp() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(1.8F, 1.6F)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .lightValue(9)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        CollisionUtils.RotateableShape shape=new CollisionUtils.RotateableShape(7.5,0,0,1,7.9,1);
        shape.addBox(6,0,0,4,1.5,1);
        shape.addBox(7.5,7.7,1,1,1.7,1);
        shape.addBox(7.5,9.1,2,1,1.7,1);
        shape.addBox(7.5,10.7,3,1,1,1);
        shape.addBox(8,8,4.25,0.25,3,0.25);
        shape.addBox(8,8,4.25,0.25,3,0.25);
        shape.addBox(7.25,5.25,3.5,0.5,2,1.75);
        shape.addBox(7.25,5.25,3.5,1.75,0.5,1.75);
        shape.addBox(7.25,5.25,3.5,1.75,2,0.5);
        shape.addBox(8.5,5.25,3.5,0.5,1.5,1.75);
        shape.addBox(8.5,5.25,3.5,0.5,2,1.25);
        shape.addBox(7.25,5.25,4.75,0.75,2,0.5);
        shape.addBox(7.25,5.25,4.75,1.75,1.5,0.5);
        shape.addBox(7.75,7.25,4,0.75,0.75,0.75);
        shape.addBox(7.75,6,4.1,0.5,0.5,0.5);
        try {
            return shape.rotate((Direction)state.get(ROTATION)).toVoxel();
        } catch (Exception err) {
            return Block.makeCuboidShape(0,0,0,0,0,0);
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getShape(state,worldIn,pos,context);
    }

    public static final EnumProperty ROTATION = BlockStateProperties.HORIZONTAL_FACING;

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, LadderBlock.WATERLOGGED);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        
        return this.getDefaultState().with(ROTATION, context.getPlacementHorizontalFacing().getOpposite()).with(LadderBlock.WATERLOGGED, ifluidstate.getFluid() == Fluids.WATER);
    }
}
