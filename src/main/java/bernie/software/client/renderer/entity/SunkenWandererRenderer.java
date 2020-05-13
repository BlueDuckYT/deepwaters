package bernie.software.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import bernie.software.client.renderer.model.SunkenWandererModel;
import bernie.software.entity.SunkenWanderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SunkenWandererRenderer extends MobRenderer<SunkenWanderer, SunkenWandererModel>
{
	public SunkenWandererRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SunkenWandererModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(SunkenWanderer entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/sunkenwanderer.png");
	}

	@Override
	protected void applyRotations(SunkenWanderer entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}