package bernie.software.client.renderer.tileentity.renderer;

import bernie.software.block.aquastone.AquastoneFan;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;

public class aquafan extends TileEntityRenderer<AquastoneFan.TileEntity> {
    public aquafan(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(AquastoneFan.TileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if (tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos()).get(AquastoneFan.ACTIVE)) {
            tileEntityIn.rotation+=1;
            if (tileEntityIn.rotation>=90) {
                tileEntityIn.rotation=0;
            }
        } else {
            if (tileEntityIn.rotation!=0) {
                tileEntityIn.rotation=(int)MathHelper.lerp(1-(1f/tileEntityIn.rotation),0,90);
            }
        }
        matrixStackIn.rotate(new Quaternion(tileEntityIn.rotation,0,0,true));
    }
}
