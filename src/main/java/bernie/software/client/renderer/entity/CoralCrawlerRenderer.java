package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.CoralCrawlerModel;
import bernie.software.entity.CoralCrawler;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class CoralCrawlerRenderer extends MobRenderer<CoralCrawler, CoralCrawlerModel>
{
	public CoralCrawlerRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new CoralCrawlerModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(CoralCrawler entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/coral_crawler.png");
	}

	@Override
	protected void applyRotations(CoralCrawler entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}