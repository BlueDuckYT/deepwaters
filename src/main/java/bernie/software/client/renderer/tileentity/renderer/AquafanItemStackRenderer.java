package bernie.software.client.renderer.tileentity.renderer;

import bernie.software.block.aquastone.AquastoneFan;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

public class AquafanItemStackRenderer extends ItemStackTileEntityRenderer {
	public AquafanItemStackRenderer() {
	}
	
	@Override
	public void render(ItemStack itemStackIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
//		super.render(itemStackIn, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
		AquafanRenderer.INSTANCE.render(new AquastoneFan.TileEntity(),0,matrixStackIn,bufferIn,combinedLightIn,combinedOverlayIn);
	}
}
