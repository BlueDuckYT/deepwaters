package blueduck.deepwaters.item.tool;

import blueduck.deepwaters.item.DeepWatersIngotItem;
import blueduck.deepwaters.registry.DeepWatersItemGroups;
import blueduck.deepwaters.registry.DeepWatersItemTiers;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
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

public class DeepWatersHoeItem extends HoeItem
{
	Item material;

	public DeepWatersHoeItem(DeepWatersItemTiers tier)
	{
		super(tier, 1.5f, new Properties()
				.maxStackSize(1)
				.defaultMaxDamage(tier.getMaxUses())
				.group(DeepWatersItemGroups.DEEPWATERS_ITEMS)
		);
		this.material=tier.getBaseMaterial();
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		
		if (material instanceof DeepWatersIngotItem)
		{
			
			((DeepWatersIngotItem)material).InvTickMethod.accept(stack,(LivingEntity)entityIn,entityIn.canSwim()?1:0.5f);
		}
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack)
	{
		
		if (slot == EquipmentSlotType.MAINHAND)
		{
			
			float amt=1;
			Multimap<String,AttributeModifier> modifiers = this.getAttributeModifiers(EquipmentSlotType.MAINHAND);
			if (material instanceof DeepWatersIngotItem)
			{
				
				amt=((DeepWatersIngotItem)material).AttackBoostFunction.apply(stack);
				AttributeModifier modifierAttack = new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", amt, AttributeModifier.Operation.ADDITION);
				modifiers.clear();
				modifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), modifierAttack);
			}
			return modifiers;
		}
		return super.getAttributeModifiers(slot,stack);
	}
	

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

	public Item addToolTip(String tooltip)
	{

		this.tooltips.add(new StringTextComponent(tooltip));
		return this;
	}
}
