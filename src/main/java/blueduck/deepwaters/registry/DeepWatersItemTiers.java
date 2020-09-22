package blueduck.deepwaters.registry;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum DeepWatersItemTiers implements IItemTier
{
	PRISMARINE(779, 7, 1.5F, 2, 12, DeepWatersItems.PRISMARINE_INGOT.get()),
	AQUALITE(1150, 7, 3F, 3, 12, DeepWatersItems.PRISMARINE_INGOT.get());


	int maxUses;
	float toolEfficiency;
	float attackDamage;
	int harvestLvl;
	int enchantability;
	Ingredient repairMaterial;
	Item baseMaterial;

	DeepWatersItemTiers(int uses, float efficiency, float damage, int harvest, int enchant, Item material) {
		maxUses = uses;
		toolEfficiency = efficiency;
		attackDamage = damage;
		harvestLvl = harvest;
		enchantability = enchant;
		repairMaterial = Ingredient.fromItems(material);
		baseMaterial = material;
	}

	@Override
	public int getMaxUses()
	{
		return maxUses;
	}

	@Override
	public float getEfficiency()
	{
		return toolEfficiency;
	}

	@Override
	public float getAttackDamage()
	{
		return attackDamage;
	}

	@Override
	public int getHarvestLevel()
	{
		return harvestLvl;
	}

	@Override
	public int getEnchantability()
	{
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		return repairMaterial;
	}
	
	public Item getBaseMaterial() {
		return baseMaterial;
	}
}
