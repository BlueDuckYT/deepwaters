package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.BlufferFishModel;
import bernie.software.client.renderer.model.ClamModel;
import bernie.software.entity.BlufferFish;
import bernie.software.entity.Clam;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class ClamRenderer extends MobRenderer<Clam, ClamModel>
{
	public ClamRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new ClamModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(Clam entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/clam.png");
	}

	@Override
	protected void applyRotations(Clam entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}

