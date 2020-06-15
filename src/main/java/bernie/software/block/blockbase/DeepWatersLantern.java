package bernie.software.block.blockbase;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class DeepWatersLantern extends LanternBlock implements IWaterLoggable {
    public DeepWatersLantern(Properties p_i49980_1_) {
        super(p_i49980_1_);
    }

    public DeepWatersLantern(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool)
        );
    }
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(LadderBlock.WATERLOGGED);
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        return this.getDefaultState().with(LadderBlock.WATERLOGGED,ifluidstate.getFluid() == Fluids.WATER);
    }
    
    public IFluidState getFluidState(BlockState state)
    {
        return state.get(StairsBlock.WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
    
    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return Block.makeCuboidShape(0,0,0,0,0,0);
    }
}
