package bernie.software.gui.surge;

import bernie.software.registry.DeepWatersItems;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPower extends SlotItemHandler {

    public SlotPower(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return super.isItemValid(stack) && (stack.getItem() instanceof ChorusFruitItem);
    }

}
