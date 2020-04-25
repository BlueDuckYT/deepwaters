package bernie.software.client.renderer.entity;

import bernie.software.client.renderer.model.AbstractWormPart;
import bernie.software.client.renderer.model.wormModel;
import bernie.software.entity.AbstractWormEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class WormRenderer extends MobRenderer<AbstractWormEntity, EntityModel<AbstractWormEntity>> {
    public ResourceLocation location;
    public WormRenderer(EntityRendererManager p_i50961_1_, EntityModel<AbstractWormEntity> p_i50961_2_, float p_i50961_3_) {
        super(p_i50961_1_, p_i50961_2_, p_i50961_3_);
    }

    public WormRenderer(EntityRendererManager rendererManager, EntityModel head, EntityModel segment, EntityModel tail,ResourceLocation texture,boolean correctForWiggler) {
        super(rendererManager, new wormModel((AbstractWormPart) head,(AbstractWormPart)segment,(AbstractWormPart)tail,correctForWiggler), 0.5F);
        location=texture;
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(AbstractWormEntity livingEntity) {
        return location;
    }
}
