package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.BlufferFishModel;
import bernie.software.client.renderer.model.StingrayModel;
import bernie.software.entity.BlufferFish;
import bernie.software.entity.Stingray;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class StingrayRenderer extends MobRenderer<Stingray, StingrayModel>
{
	public StingrayRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new StingrayModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(Stingray entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/stingray.png");
	}

	@Override
	protected void applyRotations(Stingray entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}