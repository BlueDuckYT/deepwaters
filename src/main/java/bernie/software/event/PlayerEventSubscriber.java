package bernie.software.event;

import bernie.software.entity.SurgeVehicle;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

public class PlayerEventSubscriber {

    @SubscribeEvent
    public void PlayerTickEvent(TickEvent.PlayerTickEvent event){
        if(event.player.lastTickPosY < 100){
            if(event.player.isPotionActive(Effects.WATER_BREATHING)){
                event.player.removePotionEffect(Effects.WATER_BREATHING);
                event.player.playSound(SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE, 0.5F, (float) (0.4 + (Math.random() * (0.8 - 0.4))));
            }
        }

    }

    @SubscribeEvent
    public void PlayerInteractEvent(PlayerInteractEvent event){
        if(event.getPlayer().getDisplayName().toString().equals("Dev")){
            List<SurgeVehicle> surroundingSurges = event.getPlayer().world.getEntitiesWithinAABB(SurgeVehicle.class, event.getPlayer().getBoundingBox().grow(2.0D, 2.0D, 2.0D));
            for (SurgeVehicle surge : surroundingSurges) {
                System.out.println(Arrays.toString(surge.getActivePotionEffects().toArray()));
            }

        }
    }
}
