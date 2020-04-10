package bernie.software.client.renderer.model;
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
    private final RendererModel Fins;
    private final RendererModel Top;
    private final RendererModel Left;
    private final RendererModel Right;

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

        Fins = new RendererModel(this);
        Fins.setRotationPoint(0.0F, 24.0F, 0.0F);

        Top = new RendererModel(this);
        Top.setRotationPoint(0.0F, 0.0F, 0.0F);
        Fins.addChild(Top);
        Top.cubeList.add(new ModelBox(Top, 34, 42, 0.0F, -13.0F, -9.0F, 0, 7, 15, 0.0F, false));

        Left = new RendererModel(this);
        Left.setRotationPoint(4.3F, 19.0F, -6.5F);
        setRotationAngle(Left, 0.0F, 0.0F, -0.3491F);
        Left.cubeList.add(new ModelBox(Left, 0, 22, 0.0F, -1.0F, 0.5F, 0, 2, 3, 0.0F, false));

        Right = new RendererModel(this);
        Right.setRotationPoint(-4.3F, 19.0F, -6.5F);
        setRotationAngle(Right, 0.0F, 0.0F, 0.3491F);
        Right.cubeList.add(new ModelBox(Right, 0, 22, 0.0F, -1.0F, 0.5F, 0, 2, 3, 0.0F, false));
    }

    @Override
    public void render(LegFish entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Body.render(f5);
        Fins.render(f5);
        Left.render(f5);
        Right.render(f5);
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