
package bernie.software.client.renderer.model;
import bernie.software.entity.ColorfulFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

public class ColorfulFishModel extends EntityModel<ColorfulFish> {
    private final RendererModel bb_main;
    private final RendererModel LFin;
    private final RendererModel RFin;
    private final RendererModel Topfin;
    private final RendererModel Backfin;

    public ColorfulFishModel() {
        textureWidth = 32;
        textureHeight = 32;

        bb_main = new RendererModel(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(bb_main, 0.0F, -1.5708F, 0.0F);
        bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -2.0F, -1.0F, 7, 2, 2, 0.0F, false));

        LFin = new RendererModel(this);
        LFin.setRotationPoint(-0.5F, -1.0F, -1.0F);
        bb_main.addChild(LFin);
        LFin.cubeList.add(new ModelBox(LFin, 0, 4, -1.5F, 0.0F, -2.0F, 3, 0, 2, 0.0F, false));

        RFin = new RendererModel(this);
        RFin.setRotationPoint(-0.5F, -1.0F, 1.0F);
        bb_main.addChild(RFin);
        RFin.cubeList.add(new ModelBox(RFin, 0, 6, -1.5F, 0.0F, 0.0F, 3, 0, 2, 0.0F, false));

        Topfin = new RendererModel(this);
        Topfin.setRotationPoint(-0.5F, -2.0F, 0.0F);
        bb_main.addChild(Topfin);
        Topfin.cubeList.add(new ModelBox(Topfin, 0, 8, -1.5F, -1.0F, 0.0F, 3, 1, 0, 0.0F, false));

        Backfin = new RendererModel(this);
        Backfin.setRotationPoint(3.0F, -1.0F, 0.0F);
        bb_main.addChild(Backfin);
        Backfin.cubeList.add(new ModelBox(Backfin, 0, 0, 0.0F, -1.0F, 0.0F, 2, 2, 0, 0.0F, false));
    }

    @Override
    public void render(ColorfulFish entity, float f, float f1, float f2, float f3, float f4, float f5) {
        bb_main.render(f5);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(ColorfulFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {

        this.LFin.rotateAngleX = MathHelper.sin(limbSwing);
        this.RFin.rotateAngleX = MathHelper.sin(limbSwing) * -1;

        this.Backfin.rotateAngleY = MathHelper.sin(ageInTicks)/2;

    }
}