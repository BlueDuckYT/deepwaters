package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.JellyfishModel;
import bernie.software.entity.Jellyfish;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class JellyfishRenderer extends MobRenderer<Jellyfish, JellyfishModel>
{
	public JellyfishRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new JellyfishModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(Jellyfish entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/jellyfish.png");
	}

	@Override
	protected void applyRotations(Jellyfish entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}