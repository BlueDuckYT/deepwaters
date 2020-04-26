package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.DeepGliderModel;
import bernie.software.entity.DeepGlider;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DeepGliderRenderer extends MobRenderer<DeepGlider, DeepGliderModel>
{
	public DeepGliderRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new DeepGliderModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(DeepGlider entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/deepglider.png");
	}

	@Override
	protected void applyRotations(DeepGlider entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
		GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
		if (!entityLiving.isInWater()) {
			GlStateManager.translatef(0.1F, 0.1F, -0.1F);
			GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
	}
}