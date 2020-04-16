package bernie.software.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DeepWatersAbstractRuneItem extends Item {
    public DeepWatersAbstractRuneItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        try {
            if (!stack.getTag().contains("topbottom")) {
                stack.getTag().putString("topbottom","rune/life");
            }
            if (!stack.getTag().contains("north")) {
                stack.getTag().putString("north","rune/circle");
            }

            if (!stack.getTag().contains("east")) {
                stack.getTag().putString("east","rune/triangle");
            }
        } catch (Exception err) {
            stack.getOrCreateTag();
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }
}
