package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.LegFishModel;
import bernie.software.entity.LegFish;
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
public class LegFishRenderer extends MobRenderer<LegFish, LegFishModel>
{
	public LegFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new LegFishModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(LegFish entity)
	{
		if (!entity.getsocks())
			return new ResourceLocation("deepwaters" +  ":textures/model/entity/legfish.png");
		else
			return new ResourceLocation("deepwaters" +  ":textures/model/entity/legfishsocks.png");
	}

	@Override
	protected void applyRotations(LegFish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);float f = 4.3F * MathHelper.sin(0.6F * ageInTicks);
		GlStateManager.rotatef(f, 0.0F, 1.0F, 0.0F);
		if (!entityLiving.isInWater()) {
			GlStateManager.translatef(0.1F, 0.1F, -0.1F);
			GlStateManager.rotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
	}
}