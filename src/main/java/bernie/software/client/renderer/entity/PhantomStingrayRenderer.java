package bernie.software.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import bernie.software.client.renderer.model.PhantomStingrayModel;
import bernie.software.entity.PhantomStingray;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class PhantomStingrayRenderer extends MobRenderer<PhantomStingray, PhantomStingrayModel>
{
	public PhantomStingrayRenderer(EntityRendererManager rendererManager)
	{
		super(rendererManager, new PhantomStingrayModel(), 0.5F);
	}

	@Nullable
	@Override
	public ResourceLocation getEntityTexture(PhantomStingray entity)
	{
		return new ResourceLocation("deepwaters" + ":textures/model/entity/phantom_stingray.png");
	}

	@Override
	protected void applyRotations(PhantomStingray entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
	}
}