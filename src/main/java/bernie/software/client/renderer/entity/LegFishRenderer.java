package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.LegFishModel;
import bernie.software.entity.LegFish;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
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
	protected ResourceLocation getEntityTexture(LegFish entity)
	{
		if (!entity.getsocks())
			return new ResourceLocation("deepwaters" +  ":textures/model/entity/legfish.png");
		else
			return new ResourceLocation("deepwaters" +  ":textures/model/entity/legfishsocks.png");
	}

	@Override
	protected void applyRotations(LegFish entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}