package bernie.software.entity.vehicle;

import bernie.software.DeepWatersMod;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mrcrayfish.obfuscate.client.event.PlayerModelEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class VehicleEventSubscriber
{


    @SubscribeEvent
    public static void onPlayerModelEvent(PlayerModelEvent.SetupAngles event)
    {

        if (!event.getPlayer().getEntityWorld().isRemote)
        {
            return;
        }
        Entity ridingEntity = event.getPlayer().getRidingEntity();
        if (ridingEntity != null && ridingEntity instanceof SurgeVehicle)
        {
            PlayerModel modelPlayer = event.getModelPlayer();
            modelPlayer.bipedLeftArm.rotateAngleX = -2.0F;
            modelPlayer.bipedRightArm.rotateAngleX = -2.0F;
            modelPlayer.bipedLeftLeg.rotateAngleX = MathHelper.sin(ridingEntity.ticksExisted * 0.3F) * 0.3F;
            modelPlayer.bipedLeftLeg.rotateAngleY = 0;
            modelPlayer.bipedRightLeg.rotateAngleX = MathHelper.cos(ridingEntity.ticksExisted * 0.3F) * 0.3F;
            modelPlayer.bipedRightLeg.rotateAngleY = 0;
            modelPlayer.bipedHead.rotateAngleX = -.5F;
        }
    }
    @SubscribeEvent
    public static void onPlayerModelEvent(PlayerModelEvent.Render event)
    {
        if (!event.getPlayer().getEntityWorld().isRemote)
        {
            return;
        }
        if (event instanceof PlayerModelEvent.Render.Pre) {
            Entity ridingEntity = event.getPlayer().getRidingEntity();
            if (ridingEntity != null && ridingEntity instanceof SurgeVehicle)
            {
                event.getMatrixStack().rotate(new Quaternion(75, 0, 0, true));
                event.getMatrixStack().rotate(new Quaternion(event.getPlayer().rotationPitch/2f, 0, 0, true));
                event.getMatrixStack().translate(0, -event.getHeadPitch()/500, -event.getHeadPitch()/1200);
            }
        }
    }

    @SubscribeEvent
    public static void onRenderText(RenderGameOverlayEvent event)
    {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET)
        {
            Entity ridingEntity = Minecraft.getInstance().player.getRidingEntity();
            if (ridingEntity instanceof SurgeVehicle)
            {
                StringBuilder batteryFilled = new StringBuilder();
                for(int i = 0;i <= ((SurgeVehicle) ridingEntity).battery;i += 10){
                    batteryFilled.append("█");
                }
                Minecraft.getInstance().fontRenderer.drawString("Battery: " + batteryFilled.toString(), event.getWindow().getScaledWidth() / 2 - 60, event.getWindow().getScaledHeight() - 50, 14103062);
                //GlStateManager.disableTexture2D();
                //Minecraft.getInstance().draw(0, 0, 0, 0, 10, 10, 255, 255, 255);
                //GlStateManager.te();
            }
        }
    }

}
