package bernie.software.item;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;

public class DeepWatersSpawnEggItem extends SpawnEggItem {
    public DeepWatersSpawnEggItem(EntityType<?> entity, int egg, int spots) {
        super(entity, egg, spots, new Properties()
                .group(ItemGroup.MISC)
        );
    }
}
