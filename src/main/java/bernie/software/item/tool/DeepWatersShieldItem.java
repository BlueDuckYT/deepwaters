package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItemGroups;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DeepWatersShieldItem extends ShieldItem {
    public DeepWatersShieldItem(Properties builder) {
        super(builder.group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
    }
    private List<StringTextComponent> tooltips = new ArrayList<>();
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
}
