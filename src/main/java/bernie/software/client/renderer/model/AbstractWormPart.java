package bernie.software.client.renderer.model;

import bernie.software.utils.renderutils.RenderHelper;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public abstract class AbstractWormPart extends EntityModel {
    RendererModel mdl;
    public void setModel(RendererModel mdl) {
        this.mdl=mdl;
    }
    public RendererModel getModel() {
        return new renderer(mdl);
    };
    public AbstractWormPart toModel() {
        return this;
    }
    abstract ArrayList<ModelBox> bodyBoxes();
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }
    public static class renderer extends RendererModel {
        public renderer(Model model, String boxNameIn) {
            super(model, boxNameIn);
        }
        public renderer(Model model) {
            super(model);
        }
        public renderer(Model model, int texOffX, int texOffY) {
            super(model, texOffX, texOffY);
        }
        public renderer(RendererModel mdl) {
            super(new Model(),mdl.boxName);
        }
        @Override
        public void render(float scale) {
//            super.render(scale);
        }
    }
}
