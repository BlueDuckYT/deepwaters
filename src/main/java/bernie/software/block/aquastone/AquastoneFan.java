package bernie.software.block.aquastone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DropperBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntityType;

public class AquastoneFan extends Block {
    public AquastoneFan(Properties properties) {
        super(properties);
    }

    public static BooleanProperty ACTIVE=BooleanProperty.create("active");

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(ACTIVE,DropperBlock.FACING);
    }

    public static class TileEntity extends net.minecraft.tileentity.TileEntity {
        public TileEntity(TileEntityType<?> tileEntityTypeIn) {
            super(tileEntityTypeIn);
        }

        public int rotation=0;
    }
}
