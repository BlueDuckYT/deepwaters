package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.JungleFishModel;
import bernie.software.client.renderer.model.SkullFishModel;
import bernie.software.entity.JungleFish;
import bernie.software.entity.SkullFish;
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
public class JungleFishRenderer extends MobRenderer<JungleFish, JungleFishModel>
{
	public JungleFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new JungleFishModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(JungleFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/junglefish.png");
	}

	@Override
	protected void applyRotations(JungleFish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
		GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
		if (!entityLiving.isInWater()) {
			GlStateManager.translatef(0.1F, 0.1F, -0.1F);
			GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
	}
}