package bernie.software.client.renderer.model;

import bernie.software.entity.MuckGulper;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class MuckGulperModel extends EntityModel<MuckGulper> {
	private final RendererModel Body;
	private final RendererModel Tail;
	private final RendererModel Head;
	private final RendererModel FinLeft;
	private final RendererModel FinRight;
	private final RendererModel Tooth1;
	private final RendererModel Tooth2;
	private final RendererModel Tooth3;
	private final RendererModel Tooth4;

	public MuckGulperModel() {
		textureWidth = 25;
		textureHeight = 25;

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 19.0F, -5.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 11, -1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 16, 12, 0.0F, -2.0F, 1.0F, 0, 1, 2, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 16, 12, 0.0F, -2.0F, 4.0F, 0, 1, 2, 0.0F, false));

		Tail = new RendererModel(this);
		Tail.setRotationPoint(0.0F, 19.0F, 1.0F);
		Tail.cubeList.add(new ModelBox(Tail, 16, 12, 0.0F, -2.0F, 1.0F, 0, 1, 2, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 14, 8, 0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F, true));
		Tail.cubeList.add(new ModelBox(Tail, 12, 14, -1.0F, 0.0F, 0.0F, 2, 0, 4, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 16, 13, 0.0F, -0.5F, 4.0F, 0, 1, 2, 0.0F, true));

		Head = new RendererModel(this);
		Head.setRotationPoint(0.0F, 19.0F, -5.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 19, -2.0F, -2.0F, -2.0F, 4, 4, 2, 0.0F, false));

		FinLeft = new RendererModel(this);
		FinLeft.setRotationPoint(1.0F, 19.0F, -3.0F);
		FinLeft.cubeList.add(new ModelBox(FinLeft, 13, 21, 0.0F, 0.0F, -1.0F, 2, 0, 3, 0.0F, false));
		FinLeft.cubeList.add(new ModelBox(FinLeft, 15, 10, 1.0F, 0.0F, 2.0F, 1, 0, 2, 0.0F, false));

		FinRight = new RendererModel(this);
		FinRight.setRotationPoint(-1.0F, 19.0F, -3.0F);
		FinRight.cubeList.add(new ModelBox(FinRight, 13, 18, -2.0F, 0.0F, -1.0F, 2, 0, 3, 0.0F, false));
		FinRight.cubeList.add(new ModelBox(FinRight, 15, 10, -2.0F, 0.0F, 2.0F, 1, 0, 2, 0.0F, false));

		Tooth1 = new RendererModel(this);
		Tooth1.setRotationPoint(0.0F, 20.0F, -7.0F);
		Tooth1.cubeList.add(new ModelBox(Tooth1, 12, 24, -1.0F, 0.0F, -1.0F, 2, 0, 1, 0.0F, false));

		Tooth2 = new RendererModel(this);
		Tooth2.setRotationPoint(0.0F, 18.0F, -7.0F);
		Tooth2.cubeList.add(new ModelBox(Tooth2, 12, 24, -1.0F, 0.0F, -1.0F, 2, 0, 1, 0.0F, false));

		Tooth3 = new RendererModel(this);
		Tooth3.setRotationPoint(-1.0F, 19.0F, -7.0F);
		Tooth3.cubeList.add(new ModelBox(Tooth3, 14, 21, 0.0F, -1.0F, -1.0F, 0, 2, 1, 0.0F, false));

		Tooth4 = new RendererModel(this);
		Tooth4.setRotationPoint(1.0F, 19.0F, -7.0F);
		Tooth4.cubeList.add(new ModelBox(Tooth4, 14, 21, 0.0F, -1.0F, -1.0F, 0, 2, 1, 0.0F, false));
	}

	@Override
	public void render(MuckGulper entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Tail.render(f5);
		Head.render(f5);
		FinLeft.render(f5);
		FinRight.render(f5);
		Tooth1.render(f5);
		Tooth2.render(f5);
		Tooth3.render(f5);
		Tooth4.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(MuckGulper entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.Tooth4.rotateAngleY = (float) (MathHelper.sin((float) (limbSwing * 1.5)) * 0.5);
		this.Tooth3.rotateAngleY = (float) (-1 * MathHelper.sin((float) (limbSwing * 1.5)) * 0.5);

		this.Tooth1.rotateAngleX = (float) (MathHelper.cos((float) (limbSwing * 1.5)) * 0.5);
		this.Tooth2.rotateAngleX = (float) (-1 * MathHelper.cos((float) (limbSwing * 1.5)) * 0.5);
		this.FinLeft.rotateAngleZ = (float) (MathHelper.cos((float) (limbSwing * 1.5)) * 0.5);
		this.FinRight.rotateAngleZ = (float) (-1 * MathHelper.cos((float) (limbSwing * 1.5)) * 0.5);

	}

	@Override
	public void setLivingAnimations(MuckGulper entityIn, float limbSwing, float limbSwingAmount, float partialTick)
	{
		this.Head.rotateAngleZ = (float) (MathHelper.sin(limbSwing) * 5);
	}
}