package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.MuckGulperModel;
import bernie.software.entity.MuckGulper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class MuckGulperRenderer extends MobRenderer<MuckGulper, MuckGulperModel>
{
	public MuckGulperRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new MuckGulperModel(), 0.5F);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(MuckGulper entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/muckgulper.png");
	}

	@Override
	protected void applyRotations(MuckGulper entityLiving, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
	}
}