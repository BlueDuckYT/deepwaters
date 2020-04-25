package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.BabyKrackenModel;
import bernie.software.client.renderer.model.BlufferFishModel;
import bernie.software.entity.BabyKracken;
import bernie.software.entity.BlufferFish;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class BabyKrackenRenderer extends MobRenderer<BabyKracken, BabyKrackenModel>
{
	public BabyKrackenRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new BabyKrackenModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(BabyKracken entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/babykracken.png");
	}

	@Override
	protected void applyRotations(BabyKracken entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}