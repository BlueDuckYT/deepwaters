package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.SurgeModel;
import bernie.software.entity.vehicle.SurgeVehicle;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SurgeRenderer extends MobRenderer<SurgeVehicle, SurgeModel>
{
	public SurgeRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SurgeModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(SurgeVehicle entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/surge_default.png");
	}

	@Override
	protected void applyRotations(SurgeVehicle entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}

	@Override
	public void doRender(SurgeVehicle entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		super.doRender(entity, x, y, z, entityYaw, partialTicks);


	}
}