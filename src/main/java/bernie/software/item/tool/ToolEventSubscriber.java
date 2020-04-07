package bernie.software.item.tool;

import bernie.software.registry.DeepWatersItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ToolEventSubscriber
{
	@SubscribeEvent
	public static void onBreakSpeedEvent(final PlayerEvent.BreakSpeed event)
	{

		PlayerEntity player = event.getPlayer();
		if(!player.isInWater())
		{
			return;
		}
		float originalSpeed = event.getOriginalSpeed();
		Item item = player.getHeldItemMainhand().getItem();
		if(item == DeepWatersItems.PRISMARINE_AXE.get() || item == DeepWatersItems.PRISMARINE_PICKAXE.get() || item == DeepWatersItems.PRISMARINE_SHOVEL.get())
		{
			event.setNewSpeed(10);
		}
	}
}
