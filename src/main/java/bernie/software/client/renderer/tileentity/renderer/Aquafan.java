package bernie.software.client.renderer.tileentity.renderer;

import bernie.software.block.aquastone.AquastoneFan;
import bernie.software.client.renderer.model.SharkModel;
import bernie.software.client.renderer.tileentity.model.AquafanModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Quaternion;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class Aquafan extends TileEntityRenderer<TileEntity> {

    public Aquafan(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(TileEntity TileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        AquastoneFan.TileEntity tileEntityIn=(AquastoneFan.TileEntity)TileEntityIn;
        if (tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos()).get(AquastoneFan.ACTIVE)) {
            tileEntityIn.rotation+=3;
            if (tileEntityIn.rotation>=90) {
                tileEntityIn.rotation-=90;
            }
        } else {
            if (tileEntityIn.rotation!=0) {
                tileEntityIn.rotation=(int)MathHelper.lerp(0.1f,tileEntityIn.rotation,90);
            }
        }
        matrixStackIn.translate(0.5f,0.5f,0.5f);
        matrixStackIn.rotate(new Quaternion(0,0,tileEntityIn.rotation+9f,true));
        new AquafanModel().render(matrixStackIn,bufferIn.getBuffer(RenderType.getCutout()),combinedLightIn,combinedOverlayIn,1,1,1,1);
        matrixStackIn.pop();
    }
}
