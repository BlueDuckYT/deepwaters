package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import bernie.software.registry.DeepWatersShieldProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeepWatersShieldItem extends ShieldItem {
    public DeepWatersShieldItem(DeepWatersShieldProperties prop) {
        super(prop.toProperty().group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
        thisProperties=prop;
    }
    public DeepWatersShieldItem(DeepWatersShieldProperties prop,Class<? extends ShieldEvent> event) {
        super(prop.toProperty().group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
        thisProperties=prop;
        DeepWatersShieldItem.registerEvent(prop,event);
    }
    private List<StringTextComponent> tooltips = new ArrayList<>();
    public DeepWatersShieldProperties thisProperties;
    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        for (ITextComponent component : tooltips) {
            tooltip.add(component);
        }
    }
    public Item addToolTip(String tooltip) {
        this.tooltips.add(new StringTextComponent(tooltip));
        return this;
    }

    public static ShieldEvent getEvent(DeepWatersShieldItem item) {
        try {
            return events.get(item.thisProperties).newInstance();
        } catch (Exception err) {
            return null;
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        try {
            events.get(thisProperties).newInstance().onUse(worldIn,playerIn,handIn);
        } catch (Exception err) {}
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        try {
            events.get(thisProperties).newInstance().inInv(stack,worldIn,entityIn,itemSlot,isSelected);
        } catch (Exception err) {}
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public static void registerEvent(DeepWatersShieldProperties prop, Class<? extends ShieldEvent> event) {
        events.put(prop,event);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }

    private static HashMap<DeepWatersShieldProperties,Class<? extends ShieldEvent>> events = new HashMap<>();

    public static abstract class ShieldEvent
    {
        public abstract int cooldown();
        public abstract void onUse(World world, PlayerEntity playerEntity, Hand hand);
        public abstract void inInv(ItemStack stack, World world, Entity entityIn, int itemSlot, boolean isSelected);
    }
}
