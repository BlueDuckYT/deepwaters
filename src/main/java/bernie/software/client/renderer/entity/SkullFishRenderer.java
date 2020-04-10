package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.SkullFishModel;
import bernie.software.entity.SkullFish;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SkullFishRenderer extends MobRenderer<SkullFish, SkullFishModel>
{
	public SkullFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SkullFishModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(SkullFish entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/skullfish.png");
	}

	@Override
	protected void applyRotations(SkullFish entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}