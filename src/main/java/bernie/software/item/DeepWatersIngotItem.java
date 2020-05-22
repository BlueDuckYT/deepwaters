package bernie.software.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.Consumer;
import java.util.function.Function;

public class DeepWatersIngotItem extends DeepWatersItem {
	public int MatDurability;
	public float MatStrength;
	public float MatWeight;
	public int MatColor;
	public Function<ItemStack,Float> AttackBoost=stack -> 1f;
	public TriConsumer<ItemStack,LivingEntity,Float> InvTick=(stack, entityIn, aFloat) -> {};
	
	public DeepWatersIngotItem(int matDurability, float matStrength, float matWeight, int matColor)
	{
		MatDurability = matDurability;
		MatStrength = matStrength;
		MatWeight = 5-matWeight;
		MatColor = matColor;
	}
	
	public DeepWatersIngotItem(int matDurability, float matStrength, float matWeight, int matColor, Function<ItemStack, Float> attackBoost, TriConsumer<ItemStack, LivingEntity, Float> invTick) {
		MatDurability = matDurability;
		MatStrength = matStrength;
		MatWeight = matWeight;
		MatColor = matColor;
		AttackBoost = attackBoost;
		InvTick = invTick;
	}
	
	public DeepWatersIngotItem(int matDurability, int matStrength, float matWeight, int matColor, Function<ItemStack,Float> DamageBoost) {
		MatDurability = matDurability;
		MatStrength = matStrength;
		MatWeight = 5-matWeight;
		MatColor = matColor;
		this.AttackBoost=DamageBoost;
	}
}