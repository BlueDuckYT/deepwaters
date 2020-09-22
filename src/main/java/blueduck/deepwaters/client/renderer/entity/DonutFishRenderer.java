package blueduck.deepwaters.client.renderer.entity;

import blueduck.deepwaters.client.renderer.Utils;
import blueduck.deepwaters.client.renderer.model.DonutFishModel;
import blueduck.deepwaters.entity.DonutFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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
	public ResourceLocation getEntityTexture(DonutFish entity)
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
	protected void applyRotations(DonutFish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
		Utils.applyFlop(entityLiving,matrixStackIn,ageInTicks,rotationYaw,partialTicks);
	}

	@Override
	public void render(DonutFish entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.scale(2f,2f,2f);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}