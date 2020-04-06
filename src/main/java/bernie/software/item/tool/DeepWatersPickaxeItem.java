package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class DeepWatersPickaxeItem extends PickaxeItem {

    public DeepWatersPickaxeItem(IItemTier tier) {
        super(tier, 1, -2.8f, new Properties()
                .maxStackSize(1)
                .defaultMaxDamage(tier.getMaxUses())
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
        );
    }

}
