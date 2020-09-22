package blueduck.deepwaters.client.renderer.entity;

import blueduck.deepwaters.client.renderer.model.SeaUrchinModel;
import blueduck.deepwaters.entity.SeaUrchin;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class SeaUrchinRenderer extends MobRenderer<SeaUrchin, SeaUrchinModel>
{
	public SeaUrchinRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new SeaUrchinModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(SeaUrchin entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/seaurchin.png");
	}

	@Override
	protected void applyRotations(SeaUrchin entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}