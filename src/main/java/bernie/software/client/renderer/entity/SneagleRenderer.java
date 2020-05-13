package bernie.software.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import bernie.software.client.renderer.model.SneagleModel;
import bernie.software.entity.Sneagle;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SneagleRenderer extends MobRenderer<Sneagle, SneagleModel>
{
	public SneagleRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SneagleModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(Sneagle entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/sneagle.png");
	}

	@Override
	protected void applyRotations(Sneagle entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}