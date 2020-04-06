package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class DeepWatersShovelItem extends ShovelItem {

    public DeepWatersShovelItem(IItemTier tier) {
        super(tier, 1.5f, -3, new Properties()
                .maxStackSize(1)
                .defaultMaxDamage(tier.getMaxUses())
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
        );
    }
}
