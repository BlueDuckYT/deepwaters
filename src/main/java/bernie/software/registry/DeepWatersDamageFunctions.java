package bernie.software.registry;

import bernie.software.DeepWatersMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.util.TriConsumer;

import java.util.function.Function;

public class DeepWatersDamageFunctions {
	public static Function<ItemStack,Float> PRISMARINE_DAMGE = stack ->
	{
		
		int percent=0;
		if (stack.getOrCreateTag().contains("waterPercent")) {
			percent=stack.getOrCreateTag().getInt("waterPercent");
		}
		double damage=(((((double)percent)/10)*1.5f)+1)*7;
		try {
			damage=(((((double)percent)/10)*1.5f)+1)*(stack.getItem().getAttributeModifiers(EquipmentSlotType.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).iterator().next().getAmount());
		} catch (Exception err) {}
		return (float)damage;
	};
	public static Function<ItemStack,Float> AQUALITE_DAMGE = stack ->
	{
		
		int percent=0;
		if (stack.getOrCreateTag().contains("waterPercent")) {
			percent=stack.getOrCreateTag().getInt("waterPercent");
		}
		double damage=(((((double)percent)/10)*1.75f)+1)*7;
		try {
			damage=(((((double)percent)/10)*1.75f)+1)*(stack.getItem().getAttributeModifiers(EquipmentSlotType.MAINHAND).get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).iterator().next().getAmount());
		} catch (Exception err) {}
		return (float)damage;
	};
	public static TriConsumer<ItemStack,LivingEntity,Float> PRISMARINE_INVENTORY = (stack,entityIn,aFloat) ->
	{
		
		World worldIn=entityIn.getEntityWorld();
		int percent=0;
		if (entityIn.isInWater()) {
			double y1=entityIn.getPosY();
			double y2=entityIn.getPosY()+entityIn.getHeight();
			for (float f=0;f<1;f+=0.1f) {
				double y= MathHelper.lerp(f,y1,y2);
				BlockPos pos=new BlockPos((int)entityIn.getPosX()-1,(int)y,(int)entityIn.getPosZ()-1);
				if (pos.getY()<=worldIn.getMaxHeight()) {
					if (worldIn.getFluidState(pos).getFluid().equals(Fluids.WATER)) {
						percent+=1;
					}
				}
			}
		}
		percent=(int)Math.ceil(aFloat*percent);
		stack.getOrCreateTag().putInt("waterPercent",percent);
	};
}
