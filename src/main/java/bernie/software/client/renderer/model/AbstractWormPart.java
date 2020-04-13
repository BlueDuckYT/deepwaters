package bernie.software.client.renderer.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public abstract class AbstractWormPart extends EntityModel {
    RendererModel mdl;
    public void setModel(RendererModel mdl) {
        this.mdl=mdl;
    }
    public RendererModel getModel() {
        return mdl;
    };
    public AbstractWormPart toModel() {
        return this;
    }
}
