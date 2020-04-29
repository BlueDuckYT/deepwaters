package bernie.software.gui;

import bernie.software.entity.SurgeVehicle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public abstract class VehicleContainer extends Container {
    protected final ItemStackHandler inventory;

    protected final AbstractInventoryEntity vehicle;

    public VehicleContainer(final ContainerType<?> type, final int id, final AbstractInventoryEntity vehicle) {
        super(type, id);
        this.vehicle = vehicle;
        this.inventory = vehicle.inventory;
    }

    @Override
    public boolean canInteractWith(final PlayerEntity playerIn) {
        return this.vehicle.isAlive() && this.vehicle.getDistance(playerIn) < 8.0F;
    }

    @Override
    public ItemStack transferStackInSlot(final PlayerEntity playerIn, final int index) {
        final ItemStack itemstack = ItemStack.EMPTY;
        final Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            final ItemStack itemstack1 = slot.getStack();
            if (index < this.inventory.getSlots()) {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSlots(), this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSlots(), false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    @Override
    public void onContainerClosed(final PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
    }
}