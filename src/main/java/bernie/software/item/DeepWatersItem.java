package bernie.software.item;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class DeepWatersItem extends Item {

    public DeepWatersItem() {
        super(new Properties()
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
    }

    public DeepWatersItem(Food food) {
        super(new Properties()
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
                .food(food));
    }
}
