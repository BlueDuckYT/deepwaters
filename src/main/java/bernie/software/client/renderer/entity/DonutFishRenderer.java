package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.DonutFishModel;
import bernie.software.entity.DonutFish;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class DonutFishRenderer extends MobRenderer<DonutFish, DonutFishModel>
{
	public DonutFishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new DonutFishModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(DonutFish entity)
	{
		if (entity.ResourceLocation == null) {
			Random random = new Random();
			int textureNumber = random.nextInt(2 + 1);
			switch (textureNumber) {
				case 0:
					entity.ResourceLocation = new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_red.png");
					return new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_red.png");
				case 1:
					entity.ResourceLocation = new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_yellow.png");
					return new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_yellow.png");
				case 2:
					entity.ResourceLocation = new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_blue.png");
					return new ResourceLocation("deepwaters" + ":textures/model/entity/donut_fish_blue.png");
			}
		}
		return entity.ResourceLocation;
	}

	@Override
	protected void applyRotations(DonutFish entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}

	@Override
	public float prepareScale(DonutFish entitylivingbaseIn, float partialTicks)
	{
		GlStateManager.scalef(2F, 2F, 2F);
		return super.prepareScale(entitylivingbaseIn, partialTicks);
	}
}