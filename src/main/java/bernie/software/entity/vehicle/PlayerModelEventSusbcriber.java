package bernie.software.entity.vehicle;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mrcrayfish.obfuscate.client.event.PlayerModelEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.core.Filter;

@Mod.EventBusSubscriber
public class PlayerModelEventSusbcriber
{
	@SubscribeEvent
	public static void onRenderEvent(RenderPlayerEvent.Pre event)
	{
		Entity ridingEntity = event.getPlayer().getRidingEntity();
		if (ridingEntity != null && ridingEntity instanceof SurgeVehicle)
		{
			PlayerModel<AbstractClientPlayerEntity> entityModel = event.getRenderer().getEntityModel();
			entityModel.bipedRightArm.rotateAngleX = MathHelper.sin(event.getPlayer().ticksExisted);
			entityModel.bipedLeftArm.rotateAngleX = 10F;
		}
	}

	@SubscribeEvent
	public static void onPlayerModelEvent(PlayerModelEvent.SetupAngles event)
	{
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

			GlStateManager.rotatef(20, 1, 0, 0);
		}
	}


}
