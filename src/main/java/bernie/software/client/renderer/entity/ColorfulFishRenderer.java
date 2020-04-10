package bernie.software.client.renderer.entity;


import bernie.software.client.renderer.model.ColorfulFishModel;
import bernie.software.entity.ColorfulFish;
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
	protected ResourceLocation getEntityTexture(ColorfulFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/colorfulfish" + entity.getColor() + ".png");
	}

	@Override
	protected void applyRotations(ColorfulFish entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}