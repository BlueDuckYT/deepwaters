package bernie.software.block.aquastone;

import bernie.software.registry.DeepWatersTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DropperBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class AquastoneFan extends Block implements ITileEntityProvider {
    public AquastoneFan(Properties properties) {
        super(properties);
    }

    public static BooleanProperty ACTIVE=BooleanProperty.create("active");

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ACTIVE,DropperBlock.FACING);
    }
    
    @Nullable
    @Override
    public net.minecraft.tileentity.TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntity();
    }
    
    public static class TileEntity extends net.minecraft.tileentity.TileEntity {
        public TileEntity() {
            super(DeepWatersTileEntities.AQUASTONE_FAN.get());
        }

        public int rotation=0;
    }
}
