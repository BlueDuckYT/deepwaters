package blueduck.deepwaters.event;

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
