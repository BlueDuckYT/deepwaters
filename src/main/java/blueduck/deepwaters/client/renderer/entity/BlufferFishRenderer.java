package blueduck.deepwaters.client.renderer.entity;

import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.BlufferFishModel;
import blueduck.deepwaters.entity.BlufferFish;
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
public class BlufferFishRenderer extends MobRenderer<BlufferFish, BlufferFishModel>
{
	public BlufferFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new BlufferFishModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(BlufferFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/blufferfish.png");
	}

	@Override
	public void render(BlufferFish entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}

	@Override
	protected void applyRotations(BlufferFish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}
}