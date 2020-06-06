package bernie.software.tileentity;

import bernie.software.DeepWatersMod;
import bernie.software.registry.DeepWatersTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IClearable;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class BubbleMachineTileEntity extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick;
    boolean initialized = false;


    public BubbleMachineTileEntity() {
        super(DeepWatersTileEntities.BUBBLE_MACHINE.get());
    }

    @Override
    public void tick() {
        if(!initialized){
            initialize();
        }
        tick++;
        if(tick == 1){
            tick = 0;
            execute();
        }
    }

    private void initialize() {
        initialized = true;
        x = this.pos.getX()-7;
        y = this.pos.getY()-7;
        z = this.pos.getZ()-7;
        tick = 0;
    }

    private void execute() {
        DeepWatersMod.logger.info("Executed");
        for (int x = 0; x < 15; x++){
            for(int y = 0; y < 15; y++){
                for (int z = 0; z < 15; z++) {
                    BlockPos posToBreak = new BlockPos(this.x+x, this.y+y, this.z+z);
                    destroyBlock(posToBreak, null);
                }
            }
        }
        world.playSound(this.x, this.y, this.z, SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundCategory.BLOCKS, 0.5F, (float) (0.4 + (Math.random() * (0.8 - 0.4))), true);
    }

    private boolean destroyBlock(BlockPos pos, @Nullable Entity entity) {
        BlockState state = world.getBlockState(pos);
        BlockState newState  = world.getBlockState(new BlockPos(pos.getX(), pos.getY()+255, pos.getZ()));
        IFluidState fluidState = world.getFluidState(pos);
        if(state.getBlock() instanceof IWaterLoggable){
            world.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, Boolean.FALSE), 3);
        }
        else if((fluidState.getFluid().equals(Fluids.WATER) || fluidState.getFluid().equals(Fluids.FLOWING_WATER))){
            world.setBlockState(pos, newState, 3);
            return true;
        }
        return false;
    }

}
