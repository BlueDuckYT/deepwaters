package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.BlufferFishModel;
import bernie.software.client.renderer.model.KillerWigglerModel;
import bernie.software.entity.BlufferFish;
import bernie.software.entity.KillerWiggler;
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
	protected ResourceLocation getEntityTexture(BlufferFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/blufferfish.png");
	}

	@Override
	protected void applyRotations(BlufferFish entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}


}