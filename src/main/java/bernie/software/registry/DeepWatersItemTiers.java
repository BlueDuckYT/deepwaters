package bernie.software.registry;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum DeepWatersItemTiers implements IItemTier
{
	PRISMARINE(779, 7, 2.5F, 2, 12, Ingredient.fromItems(DeepWatersItems.PRISMARINE_INGOT.get()));


	int maxUses;
	float toolEfficiency;
	float attackDamage;
	int harvestLvl;
	int enchantability;
	Ingredient repairMaterial;

	DeepWatersItemTiers(int uses, float efficiency, float damage, int harvest, int enchant, Ingredient material)
	{
		maxUses = uses;
		toolEfficiency = efficiency;
		attackDamage = damage;
		harvestLvl = harvest;
		enchantability = enchant;
		repairMaterial = material;
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

}
