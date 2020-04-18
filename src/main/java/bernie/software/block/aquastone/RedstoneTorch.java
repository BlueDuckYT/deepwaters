package bernie.software.block.aquastone;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.block.RedstoneWallTorchBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.WallOrFloorItem;

public class RedstoneTorch {
    public static class Item extends WallOrFloorItem {
        public Item(Block floorBlock, Block wallBlockIn, Properties propertiesIn) {
            super(floorBlock, wallBlockIn, propertiesIn);
        }
        public Item(net.minecraft.item.Item.Properties propertiesIn) {
            super(DeepWatersBlocks.AQUA_TORCH.get(),DeepWatersBlocks.AQUA_TORCH_WALL.get(),propertiesIn);
        }
    }
    public static class AquastoneTorch extends RedstoneTorchBlock {
        public AquastoneTorch() {
            super(Block.Properties.create(Material.ROCK));
        }
    }
    public static class AquastoneTorchWall extends RedstoneWallTorchBlock {
        public AquastoneTorchWall() {
            super(Block.Properties.create(Material.ROCK));
        }
    }
}
