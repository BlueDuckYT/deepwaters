package bernie.software.client.renderer.model;
import bernie.software.entity.MuckGulper;
import bernie.software.entity.SkullFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class SkullFishModel extends EntityModel<SkullFish> {
    private final RendererModel Body;
    private final RendererModel Tail;
    private final RendererModel Head;
    private final RendererModel LeftFin;
    private final RendererModel RightFin;

    public SkullFishModel() {
        textureWidth = 16;
        textureHeight = 16;

        Body = new RendererModel(this);
        Body.setRotationPoint(0.0F, 23.0F, -1.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 1, -1.0F, -1.0F, -1.0F, 2, 2, 3, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 10, 4, 0.0F, -2.0F, -1.0F, 0, 1, 3, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 8, 4, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        Tail = new RendererModel(this);
        Tail.setRotationPoint(0.0F, 23.0F, 1.0F);
        Tail.cubeList.add(new ModelBox(Tail, 10, 5, 0.0F, -1.0F, 0.0F, 0, 2, 3, 0.0F, false));

        Head = new RendererModel(this);
        Head.setRotationPoint(0.0F, 23.0F, -2.05F);
        Head.cubeList.add(new ModelBox(Head, 8, 0, -1.0F, -1.0F, -2.05F, 2, 2, 2, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 8, 4, -0.5F, -0.5F, -1.95F, 1, 1, 2, 0.0F, false));

        LeftFin = new RendererModel(this);
        LeftFin.setRotationPoint(1.0F, 23.0F, -1.5F);
        LeftFin.cubeList.add(new ModelBox(LeftFin, 0, 9, 0.0F, 0.0F, -0.5F, 2, 0, 3, 0.0F, false));

        RightFin = new RendererModel(this);
        RightFin.setRotationPoint(-1.0F, 23.0F, -1.5F);
        RightFin.cubeList.add(new ModelBox(RightFin, 0, 6, -2.0F, 0.0F, -0.5F, 2, 0, 3, 0.0F, false));
    }

    @Override
    public void render(SkullFish entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Body.render(f5);
        Tail.render(f5);
        Head.render(f5);
        LeftFin.render(f5);
        RightFin.render(f5);
    }
    public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(SkullFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
    {
        this.LeftFin.rotateAngleZ = MathHelper.sin(limbSwing);
        this.RightFin.rotateAngleZ = MathHelper.sin(limbSwing) * -1;
        this.Tail.rotateAngleY = (float) (MathHelper.sin(limbSwing) * 0.75);
        this.Head.rotateAngleX = (float) (Math.abs(MathHelper.sin(limbSwing)) * -.05);

    }


}