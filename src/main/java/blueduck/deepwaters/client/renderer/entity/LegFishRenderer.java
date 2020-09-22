package blueduck.deepwaters.client.renderer.entity;



import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.LegFishModel;
import blueduck.deepwaters.entity.LegFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}

	@Override
	public void render(LegFish entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}
}