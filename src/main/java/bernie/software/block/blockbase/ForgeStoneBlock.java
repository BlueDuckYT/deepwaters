package bernie.software.block.blockbase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

public class ForgeStoneBlock extends Block {

    public ForgeStoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double posX = (double)pos.getX() + rand.nextDouble();
        double posY = (double)pos.getY() + (rand.nextDouble() / 2.0D);
        double posZ = (double)pos.getZ() + rand.nextDouble();

        worldIn.addParticle(ParticleTypes.ENCHANT, posX, posY, posZ, rand.nextDouble() / 2.0D, 2.0D, rand.nextDouble() / 2.0D);
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return Block.makeCuboidShape(0,0,0,0,0,0);
    }
}
