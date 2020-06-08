package bernie.software.client.renderer.tileentity.renderer;

import bernie.software.block.aquastone.AquastoneFan;
import bernie.software.client.renderer.tileentity.model.AquafanModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.DropperBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class AquafanRenderer extends TileEntityRenderer<TileEntity>
{

	protected static AquafanRenderer INSTANCE;

	public AquafanRenderer(TileEntityRendererDispatcher rendererDispatcherIn)
	{
		super(rendererDispatcherIn);
		INSTANCE = this;
	}

	@Override
	public void render(TileEntity TileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn)
	{
		matrixStackIn.push();
		AquastoneFan.TileEntity tileEntityIn = (AquastoneFan.TileEntity) TileEntityIn;
		matrixStackIn.translate(0.5f, 0.5f, 0.5f);
		if (tileEntityIn.hasWorld())
		{
			if (tileEntityIn.getBlockState().get(AquastoneFan.ACTIVE))
			{
				tileEntityIn.rotation += 6;
				if (tileEntityIn.rotation >= 360)
				{
					tileEntityIn.rotation -= 360;
				}
			}
			else
			{
				if (tileEntityIn.rotation != 0)
				{
					float f = tileEntityIn.rotation;
					tileEntityIn.rotation = MathHelper.lerp(0.1f, tileEntityIn.rotation,
							(((int) (tileEntityIn.rotation / 90)) * 90) + 90);
				}
			}
			matrixStackIn.rotate(tileEntityIn.getBlockState().get(DropperBlock.FACING).getOpposite().getRotation());
			matrixStackIn.rotate(new Quaternion(90, 0, 0, true));
		}
		float correction = 0;
		matrixStackIn.rotate(new Quaternion(0, 0, tileEntityIn.rotation + correction, true));
		try
		{
			AquafanModel mdl = new AquafanModel();
			mdl.setRotationAngles(null, 0, 0, ((float) Math.toRadians(-(tileEntityIn.rotation + correction)) * 2), 0,
					0);
			mdl.render(matrixStackIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(
					new ResourceLocation("deepwaters:textures/model/tileentity/aquastone_fan.png"))), combinedLightIn,
					combinedOverlayIn, 1, 1, 1, 1);
			if (tileEntityIn.hasWorld())
			{
				if (tileEntityIn.getBlockState().get(AquastoneFan.HAS_SOUL_SAND))
				{
					matrixStackIn.rotate(new Quaternion(0, 0, (tileEntityIn.rotation + correction) * -2, true));
					float scale = 0.24f;
					matrixStackIn.scale(scale, scale, scale);
					Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(Items.SOUL_SAND),
							ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn,
							bufferIn);
				}
			}
		}
		catch (Exception err)
		{
		}
		matrixStackIn.pop();
	}

//    public Material getMaterial() {
//        return new Material(new ResourceLocation("textures/atlas/chest.png"), new ResourceLocation("model/tileentity/aquastone_fan.png"));
//    }
}
