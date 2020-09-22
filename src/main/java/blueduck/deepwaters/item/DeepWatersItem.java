package blueduck.deepwaters.item;

import blueduck.deepwaters.registry.DeepWatersItemGroups;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DeepWatersItem extends Item
{


	public DeepWatersItem()
	{
		super(new Properties()
				.group(DeepWatersItemGroups.DEEPWATERS_ITEMS));
	}

	public DeepWatersItem(Food food)
	{
		super(new Properties()
				.group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
				.food(food));
	}

	/**
	 * allows items to add custom lines of information to the mouseover description
	 *
	 * @param stack
	 * @param worldIn
	 * @param tooltip
	 * @param flagIn
	 */
	private List<StringTextComponent> tooltips = new ArrayList<>();

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{

		super.addInformation(stack, worldIn, tooltip, flagIn);
		for (ITextComponent component : tooltips) {
			tooltip.add(component);
		}
	}

	public DeepWatersItem addToolTip(String tooltip)
	{

		this.tooltips.add(new StringTextComponent(tooltip));
		return this;
	}
}
