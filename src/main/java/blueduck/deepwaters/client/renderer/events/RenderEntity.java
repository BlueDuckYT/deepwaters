package blueduck.deepwaters.client.renderer.events;

import blueduck.deepwaters.entity.SurgeVehicle;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderEntity {
	@SubscribeEvent
	public void renderEntityEvent(RenderLivingEvent event) {
//		System.out.println("h");
		if (event.getEntity() instanceof PlayerEntity) {
			if (!event.getEntity().getEntityWorld().isRemote)
			{
				return;
			}
			Entity ridingEntity = event.getEntity().getRidingEntity();
			if (ridingEntity != null && ridingEntity instanceof SurgeVehicle)
			{
				PlayerModel modelPlayer = (PlayerModel) event.getRenderer().getEntityModel();
				modelPlayer.bipedLeftArm.rotateAngleX = -2.0F;
				modelPlayer.bipedRightArm.rotateAngleX = -2.0F;
				modelPlayer.bipedLeftLeg.rotateAngleX = MathHelper.sin(ridingEntity.ticksExisted * 0.3F) * 0.3F;
				modelPlayer.bipedLeftLeg.rotateAngleY = 0;
				modelPlayer.bipedRightLeg.rotateAngleX = MathHelper.cos(ridingEntity.ticksExisted * 0.3F) * 0.3F;
				modelPlayer.bipedRightLeg.rotateAngleY = 0;
				modelPlayer.bipedHead.rotateAngleX = -.5F;
			}
			if (event instanceof RenderLivingEvent.Pre) {
				if (ridingEntity != null && ridingEntity instanceof SurgeVehicle)
				{
					event.getMatrixStack().rotate(new Quaternion(75, 0, 0, true));
					event.getMatrixStack().rotate(new Quaternion(event.getEntity().rotationPitch/2f, 0, 0, true));
					float headPitch=MathHelper.lerp(event.getPartialRenderTick(),event.getEntity().prevRotationPitch,event.getEntity().rotationPitch);
					event.getMatrixStack().translate(0, -headPitch/500, -headPitch/1200);
				}
			}
		}
	}
}
