package bernie.software.client.renderer.model;;
import bernie.software.entity.LegFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class LegFishModel extends EntityModel<LegFish> {
    private final RendererModel Body;
    private final RendererModel LLeg;
    private final RendererModel RLeg;
    private final RendererModel Eyes;
    private final RendererModel Mouth;
    private final RendererModel TopMouth;
    private final RendererModel BottomMouth;

    public LegFishModel() {
        textureWidth = 64;
        textureHeight = 64;

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 0, -4.0F, -9.0F, -11.0F, 8, 5, 14, 0.0F, false));

        LLeg = new RendererModel(this);
        LLeg.setRotationPoint(2.0F, -6.5F, 3.0F);
        Body.addChild(LLeg);
        LLeg.cubeList.add(new ModelBox(LLeg, 0, 19, -1.5F, -1.5F, 0.0F, 3, 3, 8, 0.0F, false));

        RLeg = new RendererModel(this);
        RLeg.setRotationPoint(-2.0F, -6.5F, 3.0F);
        Body.addChild(RLeg);
        RLeg.cubeList.add(new ModelBox(RLeg, 14, 22, -1.5F, -1.5F, 0.0F, 3, 3, 8, 0.0F, false));

        Eyes = new RendererModel(this);
        Eyes.setRotationPoint(0.0F, -9.0F, -8.5F);
        Body.addChild(Eyes);
        Eyes.cubeList.add(new ModelBox(Eyes, 0, 9, -3.5F, -2.0F, -0.5F, 3, 2, 1, 0.0F, false));
        Eyes.cubeList.add(new ModelBox(Eyes, 0, 6, 0.5F, -2.0F, -0.5F, 3, 2, 1, 0.0F, false));

        Mouth = new RendererModel(this);
        Mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        Body.addChild(Mouth);

        TopMouth = new RendererModel(this);
        TopMouth.setRotationPoint(0.0F, -7.0F, -11.0F);
        Mouth.addChild(TopMouth);
        TopMouth.cubeList.add(new ModelBox(TopMouth, 0, 0, -2.0F, -0.5F, -2.0F, 4, 1, 2, 0.0F, false));

        BottomMouth = new RendererModel(this);
        BottomMouth.setRotationPoint(0.0F, -5.5F, -11.0F);
        Mouth.addChild(BottomMouth);
        BottomMouth.cubeList.add(new ModelBox(BottomMouth, 0, 3, -2.0F, -0.5F, -2.0F, 4, 1, 2, 0.0F, false));
    }

    @Override
    public void render(LegFish entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Body.render(f5);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    public void setRotationAngles(LegFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {

        this.LLeg.rotateAngleX = MathHelper.sin(limbSwing) * (float) .5;
        this.RLeg.rotateAngleX = MathHelper.sin(limbSwing) * (float) -.5;

    }
}