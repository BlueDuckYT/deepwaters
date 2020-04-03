package bernie.software.client.renderer.model;// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

import bernie.software.entity.BlufferFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;

import static java.lang.Math.abs;

public class BlufferFishModel extends EntityModel<BlufferFish>
{
	private final RendererModel body;
	private final RendererModel jaw;
	private final RendererModel leftfin;
	private final RendererModel rightfin;
	private final RendererModel tail;

	public BlufferFishModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new RendererModel(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -7.0F, -4.0F, 8, 7, 8, 0.0F, false));

		jaw = new RendererModel(this);
		jaw.setRotationPoint(0.0F, 0.0F, -4.5F);
		setRotationAngle(jaw, 0.1745F, 0.0F, 0.0F);
		body.addChild(jaw);
		jaw.cubeList.add(new ModelBox(jaw, 0, 15, -4.0F, -4.0F, -0.5F, 8, 4, 1, 0.0F, false));

		leftfin = new RendererModel(this);
		leftfin.setRotationPoint(4.0603F, 18.0F, -1.342F);
		setRotationAngle(leftfin, -0.1745F, 0.6981F, 0.0F);
		leftfin.cubeList.add(new ModelBox(leftfin, 0, 16, -0.3972F, 2.8062F, 0.8417F, 0, 2, 4, 0.0F, false));

		rightfin = new RendererModel(this);
		rightfin.setRotationPoint(-3.9397F, 18.0F, -1.342F);
		setRotationAngle(rightfin, -0.1745F, -0.6981F, 0.0F);
		rightfin.cubeList.add(new ModelBox(rightfin, 0, 16, 0.8884F, 2.8062F, 0.8417F, 0, 2, 4, 0.0F, false));

		tail = new RendererModel(this);
		tail.setRotationPoint(0.0F, 18.0F, 4.0F);
		setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 0, 0.0F, 0.9886F, -0.7385F, 0, 4, 4, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 16, 18, 0.0F, -1.0114F, 3.2615F, 0, 8, 2, 0.0F, false));
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(BlufferFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.jaw.rotateAngleX = (float) abs((Math.sin(limbSwing * 1) * 0.5F));
		//System.out.println(limbSwing);
		this.leftfin.rotateAngleY = (float) abs((Math.sin(limbSwing) * 1.5F));
		this.rightfin.rotateAngleY = (float) (-1F * abs((Math.sin(limbSwing) * 1.5F)));
		this.tail.rotateAngleY = (float) (Math.sin(limbSwing * 3) * 0.6F);
		this.tail.rotateAngleZ = 0;


	}
}