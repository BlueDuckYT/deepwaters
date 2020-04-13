package bernie.software.client.renderer.model;
import bernie.software.entity.DonutFish;
import bernie.software.entity.JungleFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class JungleFishModel extends EntityModel<JungleFish> {
    private final RendererModel Fish;
    private final RendererModel fintop1;
    private final RendererModel fintop2;
    private final RendererModel finbottom1;
    private final RendererModel finbottom2;
    private final RendererModel mainfin;

    public JungleFishModel() {
        textureWidth = 16;
        textureHeight = 16;

        Fish = new RendererModel(this);
        Fish.setRotationPoint(0.0F, 21.0F, -2.0F);
        Fish.cubeList.add(new ModelBox(Fish, 0, 0, -1.0F, -1.0F, -3.0F, 2, 2, 6, 0.0F, false));

        fintop1 = new RendererModel(this);
        fintop1.setRotationPoint(0.0F, -1.0F, 0.0F);
        Fish.addChild(fintop1);
        fintop1.cubeList.add(new ModelBox(fintop1, 4, 0, 0.0F, -2.0F, -1.0F, 0, 2, 1, 0.0F, false));

        fintop2 = new RendererModel(this);
        fintop2.setRotationPoint(0.0F, -1.0F, 2.0F);
        Fish.addChild(fintop2);
        fintop2.cubeList.add(new ModelBox(fintop2, 0, 7, 0.0F, -2.0F, -1.0F, 0, 2, 1, 0.0F, false));

        finbottom1 = new RendererModel(this);
        finbottom1.setRotationPoint(0.0F, 1.0F, 0.0F);
        Fish.addChild(finbottom1);
        finbottom1.cubeList.add(new ModelBox(finbottom1, 0, 0, 0.0F, 0.0F, -1.0F, 0, 2, 1, 0.0F, false));

        finbottom2 = new RendererModel(this);
        finbottom2.setRotationPoint(0.0F, 1.0F, 2.0F);
        Fish.addChild(finbottom2);
        finbottom2.cubeList.add(new ModelBox(finbottom2, 2, 0, 0.0F, 0.0F, -1.0F, 0, 2, 1, 0.0F, false));

        mainfin = new RendererModel(this);
        mainfin.setRotationPoint(0.0F, 0.0F, 3.0F);
        Fish.addChild(mainfin);
        mainfin.cubeList.add(new ModelBox(mainfin, 0, 0, 0.0F, -1.0F, 0.0F, 0, 2, 3, 0.0F, false));
        mainfin.cubeList.add(new ModelBox(mainfin, 2, 4, 0.0F, -2.0F, 2.0F, 0, 1, 1, 0.0F, false));
        mainfin.cubeList.add(new ModelBox(mainfin, 0, 4, 0.0F, 1.0F, 2.0F, 0, 1, 1, 0.0F, false));
    }

    @Override
    public void render(JungleFish entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Fish.render(f5);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    public void setRotationAngles(JungleFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
        this.mainfin.rotateAngleY = MathHelper.sin(ageInTicks);
    }
}