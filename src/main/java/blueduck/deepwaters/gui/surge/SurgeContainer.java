package blueduck.deepwaters.gui.surge;

import blueduck.deepwaters.entity.SurgeVehicle;
import blueduck.deepwaters.gui.VehicleContainer;
import blueduck.deepwaters.registry.DeepWatersBlocks;
import blueduck.deepwaters.registry.DeepWatersContainerTypes;
import blueduck.deepwaters.registry.DeepWatersItems;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SurgeContainer extends VehicleContainer {

    public SurgeContainer(final int id, final PlayerInventory playerInv, final SurgeVehicle entity) {
        super(DeepWatersContainerTypes.SURGE.get(), id, entity);

        //Surge Inventory
        for(int r = 0;r < 3; r++){
            for(int c = 0;c < 9;c++){
                if(c < 4) {
                    this.addSlot(new SlotItemHandler(this.inventory, r * 9 + c, 8 + c * 18, 18 + r * 18));
                }
                else if(c > 4 && r == 0){
                    this.addSlot(new SlotUpgrade(this.inventory, r * 9 + c, 8 + c * 18, 18 + r * 18));
                }
                else if(c == 8 && r == 2){
                    this.addSlot(new SlotPower(this.inventory, r * 9 + c, 8 + c * 18, 18 + r * 18));
                }
            }
        }
        System.out.println("Inventory Size: " + this.inventorySlots.size());
        //Player Inventory
        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInv, l + k * 9 + 9, 8 + l * 18, 84 + k * 18));
            }
        }

        for (int x = 0; x < 9; ++x) {
            this.addSlot(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    public SurgeContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, playerInventory.player.world.getEntitiesWithinAABB(SurgeVehicle.class, playerInventory.player.getBoundingBox().grow(2.0D, 2.0D, 2.0D)).get(0));

    }
}

class SlotUpgrade extends SlotItemHandler {

    public SlotUpgrade(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return super.isItemValid(stack)
                && ((stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.RED_FORGE_STONE.get()))
                || (stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.BLUE_FORGE_STONE.get()))
                || (stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.GREEN_FORGE_STONE.get()))
                || (stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.ORANGE_FORGE_STONE.get()))
                || (stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.PURPLE_FORGE_STONE.get()))
                || (stack.getItem() == BlockItem.BLOCK_TO_ITEM.get(DeepWatersBlocks.YELLOW_FORGE_STONE.get())));
    }

}

class SlotPower extends SlotItemHandler {

    public SlotPower(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return super.isItemValid(stack) && (stack.getItem() == DeepWatersItems.POWER_STONE.get());
    }

}
