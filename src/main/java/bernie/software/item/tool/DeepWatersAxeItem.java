package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class DeepWatersAxeItem extends AxeItem {

    public DeepWatersAxeItem(IItemTier tier) {
        super(tier, 6, -3.2f, new Properties()
                .maxStackSize(1)
                .defaultMaxDamage(tier.getMaxUses())
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
        );
    }

}
