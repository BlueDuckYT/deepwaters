package bernie.software.item.armor;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class DeepWatersArmorItem extends ArmorItem {

    public DeepWatersArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Properties()
                .group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
        );
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer) {
        if (slot == EquipmentSlotType.LEGS) {
            return "deepwaters:textures/armor/" + material.getName() + "_layer_2.png";
        } else {
            return "deepwaters:textures/armor/" + material.getName() + "_layer_1.png";
        }
    }
}
