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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DeepWatersSwordItem extends SwordItem
{
	Item material;
	
	public DeepWatersSwordItem(DeepWatersItemTiers tier)
	{
		
		super(tier, 3, -2.4F, new Properties()
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
				modifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double) 5-((DeepWatersIngotItem) material).Weight, AttributeModifier.Operation.ADDITION));
			}
			return modifiers;
		}
		return super.getAttributeModifiers(slot,stack);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot)
	{
		
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EquipmentSlotType.MAINHAND)
		{
			
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double) 5-((DeepWatersIngotItem) material).Strength, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double) 5-((DeepWatersIngotItem) material).Weight, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}
	
	private List<StringTextComponent> tooltips = new ArrayList<>();

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{

		super.addInformation(stack, worldIn, tooltip, flagIn);
		for (ITextComponent component : tooltips)
		{
			
			tooltip.add(component);
		}
	}

	public Item addToolTip(String tooltip)
	{

		this.tooltips.add(new StringTextComponent(tooltip));
		return this;
	}
}
