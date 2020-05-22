package bernie.software.event;

import bernie.software.registry.DeepWatersItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SwordEventSubscriber
{
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event)
	{
//		Entity source = event.getSource().getTrueSource();
//		if (source instanceof PlayerEntity)
//		{
//			PlayerEntity playerSource = (PlayerEntity) source;
//			if (playerSource.isInWater() && playerSource.getHeldItemMainhand().getItem() == DeepWatersItems.PRISMARINE_SWORD.get())
//			{
//				float originalAmount = event.getAmount();
//				event.setAmount((float) (originalAmount * 1.5));
//			}
//		}
	}
}
