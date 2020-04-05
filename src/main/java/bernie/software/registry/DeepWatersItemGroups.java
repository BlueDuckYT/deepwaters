package bernie.software.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class DeepWatersItemGroups {

    public static final ItemGroup DEEPWATERS_BLOCKS = new ItemGroup("deepwaters_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DeepWatersBlocks.MOSSY_OCEAN_FLOOR.get());
        }
    };

    public static final ItemGroup DEEPWATERS_ITEMS = new ItemGroup("deepwaters_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(DeepWatersItems.PEARL.get());
        }
    };
}
