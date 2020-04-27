package bernie.software.gui;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public abstract class AbstractInventoryEntity extends WaterMobEntity {
    public ItemStackHandler inventory = this.initInventory();
    private LazyOptional<ItemStackHandler> itemHandler = LazyOptional.of(() -> this.inventory);

    public AbstractInventoryEntity(final EntityType<? extends WaterMobEntity> entityTypeIn, final World worldIn) {
        super(entityTypeIn, worldIn);
    }

    protected abstract ItemStackHandler initInventory();

    @Override
    public boolean replaceItemInInventory(final int inventorySlot, final ItemStack itemStackIn) {
        if (inventorySlot >= 0 && inventorySlot < this.inventory.getSlots()) {
            this.inventory.setStackInSlot(inventorySlot, itemStackIn);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void readAdditional(final CompoundNBT compound) {
        super.readAdditional(compound);
        this.inventory.deserializeNBT(compound.getCompound("Items"));
    }

    @Override
    public void writeAdditional(final CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.put("Items", this.inventory.serializeNBT());
    }

    @Override
    public void remove(final boolean keepData) {
        super.remove(keepData);
        if (!keepData && this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(final Capability<T> capability, @Nullable final Direction facing) {
        if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.itemHandler != null)
            return this.itemHandler.cast();
        return super.getCapability(capability, facing);
    }
}
