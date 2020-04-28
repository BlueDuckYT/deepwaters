package bernie.software.block;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class ThickKelpTopBlock extends ThickKelpBlock {
    @Override
    public boolean hasTileEntity(BlockState state) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return null;
    }

    public static BooleanProperty NEW = BooleanProperty.create("new");

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state,worldIn,pos,random);
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
    }

    @Override
    public BlockState getBlockState(BlockState currentState, IWorldReader worldReader, BlockPos pos) {
        BlockState reference=worldReader.getBlockState(pos.down());
        BlockState newState=currentState
                .with(BOTTOM,true)
                .with(COLOR,reference.get(COLOR))
                .with(GROWAQUASTONE,reference.get(GROWAQUASTONE))
                .with(NEW,false);
        if (worldReader.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock&&
            (worldReader.getBlockState(pos.up().up()).getBlock() instanceof ThickKelpTopBlock)&&
            !(worldReader.getBlockState(pos.down()).getBlock() instanceof ThickKelpTopBlock)) {
            newState=DeepWatersBlocks.THICK_KELP.get().getDefaultState()
                    .with(BOTTOM,false)
                    .with(COLOR,reference.get(COLOR))
                    .with(GROWAQUASTONE,reference.get(GROWAQUASTONE));
        }
        if (!(worldReader.getBlockState(pos.up()).getBlock() instanceof ThickKelpTopBlock)) {
            newState=newState.with(BOTTOM,false).with(NEW,false);
            if (!(worldReader.getBlockState(pos.down()).getBlock() instanceof ThickKelpTopBlock)) {
                newState=newState.with(BOTTOM,false).with(NEW,true);
            }
            if (worldReader.getBlockState(pos.up()).getBlock() instanceof ThickKelpBlock) {
                newState=DeepWatersBlocks.THICK_KELP.get().getDefaultState()
                        .with(BOTTOM,false)
                        .with(COLOR,reference.get(COLOR))
                        .with(GROWAQUASTONE,reference.get(GROWAQUASTONE));
            }
        }
        if (!(worldReader.getBlockState(pos.down()).getBlock() instanceof ThickKelpBlock)) {
            if (worldReader.getBlockState(pos.up()).getBlock() instanceof ThickKelpTopBlock) {
                newState=Blocks.AIR.getDefaultState();
            }
        }
        return newState;
    }
}
