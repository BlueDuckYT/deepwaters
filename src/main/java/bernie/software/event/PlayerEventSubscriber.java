package bernie.software.event;

import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEventSubscriber {

    @SubscribeEvent
    public void PlayerTickEvent(TickEvent.PlayerTickEvent event){

        if(event.player.lastTickPosY < 100){
            if(event.player.isPotionActive(Effects.WATER_BREATHING)){
                event.player.removePotionEffect(Effects.WATER_BREATHING);
                event.player.playSound(SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE, 0.5F, (float) (Math.random() * 0.4F + 0.8F));
            }
        }

    }



}
