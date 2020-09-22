package blueduck.deepwaters.client.renderer.entity;


import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.ColorfulFishModel;
import blueduck.deepwaters.entity.ColorfulFish;
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
public class ColorfulFishRenderer extends MobRenderer<ColorfulFish, ColorfulFishModel>
{
	public ColorfulFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new ColorfulFishModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(ColorfulFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/colorfulfish" + entity.getColor() + ".png");
	}

	@Override
	protected void applyRotations(ColorfulFish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}

	@Override
	public void render(ColorfulFish entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}
}