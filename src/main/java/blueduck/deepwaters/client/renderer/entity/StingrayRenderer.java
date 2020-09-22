package blueduck.deepwaters.client.renderer.entity;

import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.StingrayModel;
import blueduck.deepwaters.entity.Stingray;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class StingrayRenderer extends MobRenderer<Stingray, StingrayModel>
{
	public StingrayRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new StingrayModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(Stingray entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/stingray.png");
	}

	@Override
	protected void applyRotations(Stingray entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);

	}

	@Override
	public void render(Stingray entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		RenderSystem.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		RenderSystem.popMatrix();
	}
}