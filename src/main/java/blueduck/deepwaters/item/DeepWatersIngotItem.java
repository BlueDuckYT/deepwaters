package blueduck.deepwaters.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.Function;

public class DeepWatersIngotItem extends DeepWatersItem {
	public int Durability;
	public float Strength;
	public float Weight;
	public int Color;
	public Function<ItemStack,Float> AttackBoostFunction = stack -> 1f;
	public TriConsumer<ItemStack,LivingEntity,Float> InvTickMethod = (stack, entityIn, aFloat) -> {};
	
	public DeepWatersIngotItem(int matDurability, float matStrength, float matWeight, int matColor)
	{
		Durability = matDurability;
		Strength = matStrength;
		Weight = 5-matWeight;
		Color = matColor;
	}
	
	public DeepWatersIngotItem(int matDurability, float matStrength, float matWeight, int matColor, Function<ItemStack, Float> attackBoost, TriConsumer<ItemStack, LivingEntity, Float> invTick) {
		Durability = matDurability;
		Strength = matStrength;
		Weight = 5-matWeight;
		Color = matColor;
		AttackBoostFunction = attackBoost;
		InvTickMethod = invTick;
	}
	
	public DeepWatersIngotItem(int matDurability, int matStrength, float matWeight, int matColor, Function<ItemStack,Float> DamageBoost) {
		Durability = matDurability;
		Strength = matStrength;
		Weight = 5-matWeight;
		Color = matColor;
		this.AttackBoostFunction =DamageBoost;
	}
}