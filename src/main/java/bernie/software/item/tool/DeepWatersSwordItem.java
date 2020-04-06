package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.tags.BlockTags;

public class DeepWatersSwordItem extends SwordItem {

    public DeepWatersSwordItem(IItemTier tier) {
        super(tier, 3, -2.4F, new Properties()
                .maxStackSize(1)
                .defaultMaxDamage(tier.getMaxUses())
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
        );
    }


}
