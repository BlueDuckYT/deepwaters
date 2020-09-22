package blueduck.deepwaters.client.renderer.entity;



import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.DeepGliderModel;
import blueduck.deepwaters.entity.DeepGlider;
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
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}

	@Override
	public void render(DeepGlider entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}
}