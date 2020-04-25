package bernie.software.client.renderer.entity;


import bernie.software.client.renderer.model.KillerWigglerModel;
import bernie.software.entity.KillerWiggler;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class KillerWigglerRenderer extends MobRenderer<KillerWiggler, KillerWigglerModel>
{
	public KillerWigglerRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new KillerWigglerModel(), 0.5F);
	}

	@Override
	protected void applyRotations(KillerWiggler entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(KillerWiggler entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/killerwiggler.png");
	}

}
