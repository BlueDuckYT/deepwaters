package blueduck.deepwaters.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class ForgeStoneBlock extends Block implements IWaterLoggable {

    public ForgeStoneBlock(Properties properties) {
        super(properties);
    }
    
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(StairsBlock.WATERLOGGED);
    }
    
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double posX = (double)pos.getX() + rand.nextDouble();
        double posY = (double)pos.getY() + (rand.nextDouble() / 2.0D);
        double posZ = (double)pos.getZ() + rand.nextDouble();

        worldIn.addParticle(ParticleTypes.ENCHANT, posX, posY, posZ, rand.nextDouble() / 2.0D, 2.0D, rand.nextDouble() / 2.0D);
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
