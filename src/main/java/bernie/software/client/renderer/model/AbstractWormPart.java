package bernie.software.client.renderer.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import java.util.ArrayList;

public abstract class AbstractWormPart extends EntityModel {
    ModelRenderer mdl;
    public void setModel(ModelRenderer mdl) {
        this.mdl=mdl;
    }
    public ModelRenderer getModel() {
        return mdl;
    };
    public AbstractWormPart toModel() {
        return this;
    }
    abstract ArrayList<ModelRenderer.ModelBox> bodyBoxes();

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        mdl.render(matrixStackIn,bufferIn,packedLightIn,packedOverlayIn,red,green,blue,alpha);
    }
}
