package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.Utils;
import bernie.software.client.renderer.model.MuckGulperModel;
import bernie.software.entity.MuckGulper;
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
public class MuckGulperRenderer extends MobRenderer<MuckGulper, MuckGulperModel>
{
	public MuckGulperRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new MuckGulperModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(MuckGulper entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/muckgulper.png");
	}

	@Override
	public void render(MuckGulper entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		GlStateManager.pushMatrix();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		GlStateManager.popMatrix();
	}

	@Override
	protected void applyRotations(MuckGulper entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}
}