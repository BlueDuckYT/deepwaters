package bernie.software.item.tool;

import bernie.software.item.events.shield;
import bernie.software.registry.DeepWatersItemGroups;
import bernie.software.registry.DeepWatersShieldProperties;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.UseAction;
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
    public DeepWatersShieldItem(DeepWatersShieldProperties prop,Class<? extends useEvent> event) {
        super(prop.toProperty().group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
        thisProperties=prop;
        DeepWatersShieldItem.registerUseEvent(prop,event);
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

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        try {
            events.get(thisProperties).newInstance().onUse(worldIn,playerIn,handIn);
        } catch (Exception err) {}
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public static void registerUseEvent(DeepWatersShieldProperties prop, Class<? extends useEvent> event) {
        events.put(prop,event);
    }

    private static HashMap<DeepWatersShieldProperties,Class<? extends useEvent>> events = new HashMap<>();

    public static abstract class useEvent {
        public abstract void onUse(World world, PlayerEntity playerEntity, Hand hand);
    }
}
