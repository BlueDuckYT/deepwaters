package bernie.software.client.renderer.model;
import bernie.software.entity.DeepGlider;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class DeepGliderModel extends EntityModel<DeepGlider> {
    private final RendererModel Angler;
    private final RendererModel fronthead;
    private final RendererModel tail;
    private final RendererModel propeller;
    private final RendererModel rotator;
    private final RendererModel rotator2;
    private final RendererModel rotator3;
    private final RendererModel thinny;
    private final RendererModel thinny2;
    private final RendererModel sidefin;
    private final RendererModel lowerjaw;
    private final RendererModel teeth2;
    private final RendererModel teeth4;
    private final RendererModel sidefin2;

    public DeepGliderModel() {
        textureWidth = 32;
        textureHeight = 32;

        Angler = new RendererModel(this);
        Angler.setRotationPoint(0.0F, 22.0F, -4.0F);
        Angler.cubeList.add(new ModelBox(Angler, 12, 5, -1.0F, -1.0F, 6.0F, 2, 2, 2, 0.0F, false));
        Angler.cubeList.add(new ModelBox(Angler, 0, 7, -2.0F, -2.0F, 3.0F, 4, 4, 3, 0.0F, false));
        Angler.cubeList.add(new ModelBox(Angler, 0, 0, -2.0F, -3.0F, 0.0F, 4, 4, 3, 0.0F, false));

        fronthead = new RendererModel(this);
        fronthead.setRotationPoint(-2.0F, 4.0F, -1.0F);
        Angler.addChild(fronthead);

        tail = new RendererModel(this);
        tail.setRotationPoint(-0.5F, 0.5F, 8.0F);
        Angler.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 11, 0, 0.0F, -1.0F, 0.0F, 1, 1, 2, 0.0F, false));

        propeller = new RendererModel(this);
        propeller.setRotationPoint(0.5F, -0.5F, 2.0F);
        tail.addChild(propeller);

        rotator = new RendererModel(this);
        rotator.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(rotator, 0.0F, 0.0F, 2.3562F);
        propeller.addChild(rotator);
        rotator.cubeList.add(new ModelBox(rotator, 11, 8, 0.0F, -1.0F, 0.0F, 0, 1, 1, 0.0F, false));

        rotator2 = new RendererModel(this);
        rotator2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(rotator2, 0.0F, 0.0F, -2.3562F);
        propeller.addChild(rotator2);
        rotator2.cubeList.add(new ModelBox(rotator2, 0, 8, 0.0F, -1.0F, 0.0F, 0, 1, 1, 0.0F, false));

        rotator3 = new RendererModel(this);
        rotator3.setRotationPoint(0.0F, 0.0F, 0.0F);
        propeller.addChild(rotator3);
        rotator3.cubeList.add(new ModelBox(rotator3, 11, 0, 0.0F, -1.0F, 0.0F, 0, 1, 1, 0.0F, false));

        thinny = new RendererModel(this);
        thinny.setRotationPoint(0.0F, -2.0F, 5.0F);
        setRotationAngle(thinny, -0.3491F, 0.0F, 0.0F);
        Angler.addChild(thinny);
        thinny.cubeList.add(new ModelBox(thinny, 6, 12, 0.0F, -1.0603F, -0.658F, 0, 2, 3, 0.0F, false));

        thinny2 = new RendererModel(this);
        thinny2.setRotationPoint(0.0F, -3.0F, 5.0F);
        setRotationAngle(thinny2, 0.2618F, 0.0F, 0.0F);
        Angler.addChild(thinny2);
        thinny2.cubeList.add(new ModelBox(thinny2, 0, 11, 0.0F, -0.9739F, -3.8191F, 0, 2, 3, 0.0F, false));

        sidefin = new RendererModel(this);
        sidefin.setRotationPoint(-2.0F, 0.0F, 3.0F);
        setRotationAngle(sidefin, 0.0F, -0.6109F, 0.0F);
        Angler.addChild(sidefin);
        sidefin.cubeList.add(new ModelBox(sidefin, 0, 14, 0.0F, -2.0F, 0.0F, 0, 4, 2, 0.0F, false));

        lowerjaw = new RendererModel(this);
        lowerjaw.setRotationPoint(0.0F, 1.0F, 3.0F);
        Angler.addChild(lowerjaw);
        lowerjaw.cubeList.add(new ModelBox(lowerjaw, 11, 11, -2.0F, 0.0F, -3.0F, 4, 1, 3, 0.0F, false));

        teeth2 = new RendererModel(this);
        teeth2.setRotationPoint(-2.0F, 0.0F, -2.0F);
        setRotationAngle(teeth2, 0.0F, 0.0F, -0.0873F);
        lowerjaw.addChild(teeth2);
        teeth2.cubeList.add(new ModelBox(teeth2, 0, 6, 0.0F, -2.0F, -1.0F, 0, 2, 1, 0.0F, false));

        teeth4 = new RendererModel(this);
        teeth4.setRotationPoint(2.0F, 0.0F, -2.0F);
        setRotationAngle(teeth4, 0.0F, 0.0F, 0.0873F);
        lowerjaw.addChild(teeth4);
        teeth4.cubeList.add(new ModelBox(teeth4, 0, 0, -0.3F, -2.0F, -1.0F, 0, 2, 1, 0.0F, false));

        sidefin2 = new RendererModel(this);
        sidefin2.setRotationPoint(2.0F, 0.0F, 3.0F);
        setRotationAngle(sidefin2, 0.0F, 0.6109F, 0.0F);
        Angler.addChild(sidefin2);
        sidefin2.cubeList.add(new ModelBox(sidefin2, 12, 13, 0.0F, -2.0F, 0.0F, 0, 4, 2, 0.0F, false));
    }

    @Override
    public void render(DeepGlider entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Angler.render(f5);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(DeepGlider entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
        this.propeller.rotateAngleZ += 0.5;
        this.lowerjaw.rotateAngleX = (float) Math.abs(MathHelper.sin(limbSwing) * .5);
        this.sidefin.rotateAngleY = (float) Math.abs(MathHelper.sin(limbSwing) * .25) * -1;
        this.sidefin2.rotateAngleY = (float) Math.abs(MathHelper.sin(limbSwing) * .25);
    }

}