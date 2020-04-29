package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.SeaAngelModel;
import bernie.software.entity.SeaAngel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SeaAngelRenderer extends MobRenderer<SeaAngel, SeaAngelModel>
{
	public SeaAngelRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SeaAngelModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(SeaAngel entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/sea_angel.png");
	}

	@Override
	protected void applyRotations(SeaAngel entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}