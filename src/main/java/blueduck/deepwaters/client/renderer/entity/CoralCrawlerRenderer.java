package blueduck.deepwaters.client.renderer.entity;

import blueduck.deepwaters.client.renderer.model.CoralCrawlerModel;
import blueduck.deepwaters.entity.CoralCrawler;
import com.mojang.blaze3d.matrix.MatrixStack;
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
	public ResourceLocation getEntityTexture(CoralCrawler entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/coral_crawler.png");
	}

	@Override
	protected void applyRotations(CoralCrawler entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}