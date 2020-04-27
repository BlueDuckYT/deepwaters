package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.SurgeModel;
import bernie.software.entity.SurgeVehicle;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
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
	public ResourceLocation getEntityTexture(SurgeVehicle entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/surge_default.png");
	}

	@Override
	protected void applyRotations(SurgeVehicle entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	@Override
	public void render(SurgeVehicle entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}
}