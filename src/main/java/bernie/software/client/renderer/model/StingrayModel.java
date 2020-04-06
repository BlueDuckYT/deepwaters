package bernie.software.client.renderer.model;
import bernie.software.entity.Stingray;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

import static java.lang.Math.abs;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class StingrayModel extends EntityModel<Stingray> {
	private final RendererModel Stingray;
	private final RendererModel Body;
	private final RendererModel mouth;
	private final RendererModel Lefthand;
	private final RendererModel smallfinleft;
	private final RendererModel Righthand;
	private final RendererModel smallfinright;
	private final RendererModel Tail;
	private final RendererModel tail1;
	private final RendererModel tail2;
	private final RendererModel tail3;
	private final RendererModel tail4;
	private final RendererModel stinger;
	private final RendererModel bone;
	private final RendererModel AllExcept12;
	private final RendererModel AllExcept123;

	public StingrayModel() {
		textureWidth = 128;
		textureHeight = 128;

		Stingray = new RendererModel(this);
		Stingray.setRotationPoint(2.0F, 24.0F, 12.0F);
		Stingray.cubeList.add(new ModelBox(Stingray, 6, 6, 1.0F, -5.0F, -19.0F, 2, 1, 2, 0.0F, false));
		Stingray.cubeList.add(new ModelBox(Stingray, 0, 4, -7.0F, -5.0F, -19.0F, 2, 1, 2, 0.0F, false));

		Body = new RendererModel(this);
		Body.setRotationPoint(-2.0F, 0.0F, -12.0F);
		Stingray.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 70, 41, -4.0F, -2.0F, -8.0F, 8, 2, 16, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 36, -5.0F, -4.0F, -8.0F, 10, 2, 16, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 50, 18, -7.0F, -3.0F, -10.0F, 14, 2, 2, 0.0F, false));

		mouth = new RendererModel(this);
		mouth.setRotationPoint(0.0F, -2.0F, -2.0F);
		setRotationAngle(mouth, 1.8326F, 0.0F, 0.0F);
		Body.addChild(mouth);
		mouth.cubeList.add(new ModelBox(mouth, 50, 22, -2.0F, -2.2251F, -2.6648F, 4, 1, 1, 0.0F, false));

		Lefthand = new RendererModel(this);
		Lefthand.setRotationPoint(-4.0F, -0.75F, 0.0F);
		Body.addChild(Lefthand);
		Lefthand.cubeList.add(new ModelBox(Lefthand, 4, 18, -13.0F, -1.25F, -8.0F, 13, 2, 16, 0.0F, false));

		smallfinleft = new RendererModel(this);
		smallfinleft.setRotationPoint(-12.0F, 0.75F, 0.0F);
		Lefthand.addChild(smallfinleft);
		smallfinleft.cubeList.add(new ModelBox(smallfinleft, 50, 0, -5.0F, -2.0F, -6.0F, 4, 2, 12, 0.0F, false));

		Righthand = new RendererModel(this);
		Righthand.setRotationPoint(4.0F, -0.75F, 0.0F);
		Body.addChild(Righthand);
		Righthand.cubeList.add(new ModelBox(Righthand, 4, 0, 0.0F, -1.25F, -8.0F, 13, 2, 16, 0.0F, false));

		smallfinright = new RendererModel(this);
		smallfinright.setRotationPoint(13.0F, 0.75F, 0.0F);
		Righthand.addChild(smallfinright);
		smallfinright.cubeList.add(new ModelBox(smallfinright, 38, 38, 0.0F, -2.0F, -6.0F, 4, 2, 12, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(-2.0F, -2.0F, -4.0F);
		Stingray.addChild(Tail);

		tail1 = new RendererModel(this);
		tail1.setRotationPoint(1.0F, 2.0F, -1.0F);
		Tail.addChild(tail1);
		tail1.cubeList.add(new ModelBox(tail1, 20, 54, -3.0F, -4.0F, 1.0F, 4, 4, 6, 0.0F, false));

		tail2 = new RendererModel(this);
		tail2.setRotationPoint(0.0F, 1.0F, 6.0F);
		Tail.addChild(tail2);

		tail3 = new RendererModel(this);
		tail3.setRotationPoint(0.0F, 0.0F, 12.0F);
		Tail.addChild(tail3);

		tail4 = new RendererModel(this);
		tail4.setRotationPoint(0.0F, 0.0F, 18.0F);
		Tail.addChild(tail4);

		stinger = new RendererModel(this);
		stinger.setRotationPoint(0.0F, 0.5F, 5.5F);
		tail4.addChild(stinger);

		bone = new RendererModel(this);
		bone.setRotationPoint(0.1057F, -0.4766F, -17.75F);
		stinger.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 34, 58, -2.1057F, -2.0234F, 0.25F, 4, 4, 6, 0.0F, false));

		AllExcept12 = new RendererModel(this);
		AllExcept12.setRotationPoint(0.067F, 0.0703F, 6.0F);
		bone.addChild(AllExcept12);
		AllExcept12.cubeList.add(new ModelBox(AllExcept12, 0, 54, -2.1726F, -2.0937F, 0.25F, 4, 4, 6, 0.0F, false));

		AllExcept123 = new RendererModel(this);
		AllExcept123.setRotationPoint(0.0F, 0.25F, 6.25F);
		AllExcept12.addChild(AllExcept123);
		AllExcept123.cubeList.add(new ModelBox(AllExcept123, 48, 52, -2.1726F, -2.3437F, 0.0F, 4, 4, 6, 0.0F, false));
		AllExcept123.cubeList.add(new ModelBox(AllExcept123, 11, 80, -0.75F, -1.25F, 6.0F, 2, 2, 6, 0.0F, false));
	}

	@Override
	public void render(bernie.software.entity.Stingray entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Stingray.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(bernie.software.entity.Stingray entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{

		this.bone.rotateAngleY = (float) (MathHelper.sin((float) limbSwing) * 0.2);
		this.AllExcept12.rotateAngleY = (float) (MathHelper.sin((float) limbSwing) * 0.3);
		this.AllExcept123.rotateAngleY = (float) (MathHelper.sin((float) limbSwing) * 0.4);
		this.stinger.rotateAngleY = 0;

		//this.Lefthand.rotateAngleZ = (float) (abs(MathHelper.sin((float) limbSwing) * 0.2));
		//this.smallfinleft.rotateAngleZ = (float) (abs(MathHelper.sin((float) limbSwing) * 0.3));
		this.Lefthand.rotateAngleZ = (float) (MathHelper.sin((float) limbSwing) * 0.3);
		this.smallfinleft.rotateAngleZ = (float) (MathHelper.sin((float) limbSwing) * 0.4);
		this.Righthand.rotateAngleZ = (float) (-1 * MathHelper.sin((float) limbSwing) * 0.3);
		this.smallfinright.rotateAngleZ = (float) (-1 * MathHelper.sin((float) limbSwing) * 0.4);



	}
}