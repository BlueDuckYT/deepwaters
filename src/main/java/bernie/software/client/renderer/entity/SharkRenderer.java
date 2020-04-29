package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.SharkModel;
import bernie.software.entity.Shark;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SharkRenderer extends MobRenderer<Shark, SharkModel>
{
	public SharkRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SharkModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(Shark entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/shark.png");
	}

	@Override
	protected void applyRotations(Shark entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}