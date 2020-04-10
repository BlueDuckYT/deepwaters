package bernie.software.client.renderer.entity;



import bernie.software.client.renderer.model.DeepGliderModel;
import bernie.software.entity.DeepGlider;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class DeepGliderRenderer extends MobRenderer<DeepGlider, DeepGliderModel>
{
	public DeepGliderRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new DeepGliderModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(DeepGlider entity)
	{
		return new ResourceLocation("deepwaters" +  ":textures/model/entity/deepglider.png");
	}

	@Override
	protected void applyRotations(DeepGlider entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}