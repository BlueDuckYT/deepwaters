package bernie.software.client.renderer.model;
import bernie.software.entity.BabyKracken;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

import static java.lang.Math.abs;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class BabyKrackenModel extends EntityModel<BabyKracken> {
	private final RendererModel hexapus;
	private final RendererModel head;
	private final RendererModel leg1;
	private final RendererModel leg1part2;
	private final RendererModel leg1part3;
	private final RendererModel leg2;
	private final RendererModel leg2part2;
	private final RendererModel leg2part3;
	private final RendererModel leg3;
	private final RendererModel leg3part2;
	private final RendererModel leg3part3;
	private final RendererModel leg4;
	private final RendererModel leg4part2;
	private final RendererModel leg4part3;
	private final RendererModel leg5;
	private final RendererModel leg5part2;
	private final RendererModel leg5part3;
	private final RendererModel leg6;
	private final RendererModel leg6part2;
	private final RendererModel leg6part3;
	private final RendererModel leg7;
	private final RendererModel leg7part2;
	private final RendererModel leg7part3;
	private final RendererModel leg8;
	private final RendererModel leg8part2;
	private final RendererModel leg8part4;

	public BabyKrackenModel() {
		textureWidth = 128;
		textureHeight = 128;

		hexapus = new RendererModel(this);
		hexapus.setRotationPoint(0.0F, -2.0F, 1.0F);

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 1.0F, -1.0F);
		hexapus.addChild(head);
		head.cubeList.add(new ModelBox(head, 0, 0, -8.0F, -10.0F, -8.0F, 16, 17, 16, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 58, 44, -5.0F, -7.0F, 9.0F, 10, 11, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 26, 48, 9.0F, -6.0F, -4.0F, 1, 9, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 42, 33, -5.0F, -12.0F, -5.0F, 10, 1, 10, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 44, -9.0F, -8.0F, -6.0F, 1, 13, 12, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 33, -7.0F, -11.0F, -7.0F, 14, 1, 14, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 62, 62, -10.0F, -6.0F, -4.0F, 1, 9, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 48, 0, -7.0F, -9.0F, 8.0F, 14, 15, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 48, 8.0F, -8.0F, -6.0F, 1, 13, 12, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -3.0F, -7.0F, -9.0F, 6, 10, 1, 0.0F, false));

		leg1 = new RendererModel(this);
		leg1.setRotationPoint(7.0F, 8.0F, -8.0F);
		hexapus.addChild(leg1);
		leg1.cubeList.add(new ModelBox(leg1, 40, 77, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg1part2 = new RendererModel(this);
		leg1part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg1.addChild(leg1part2);
		leg1part2.cubeList.add(new ModelBox(leg1part2, 32, 73, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg1part3 = new RendererModel(this);
		leg1part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg1part2.addChild(leg1part3);
		leg1part3.cubeList.add(new ModelBox(leg1part3, 24, 73, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg2 = new RendererModel(this);
		leg2.setRotationPoint(7.0F, 8.0F, -1.0F);
		hexapus.addChild(leg2);
		leg2.cubeList.add(new ModelBox(leg2, 16, 73, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg2part2 = new RendererModel(this);
		leg2part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg2.addChild(leg2part2);
		leg2part2.cubeList.add(new ModelBox(leg2part2, 8, 73, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg2part3 = new RendererModel(this);
		leg2part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg2part2.addChild(leg2part3);
		leg2part3.cubeList.add(new ModelBox(leg2part3, 0, 73, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg3 = new RendererModel(this);
		leg3.setRotationPoint(7.0F, 8.0F, 6.0F);
		hexapus.addChild(leg3);
		leg3.cubeList.add(new ModelBox(leg3, 72, 56, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg3part2 = new RendererModel(this);
		leg3part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg3.addChild(leg3part2);
		leg3part2.cubeList.add(new ModelBox(leg3part2, 72, 32, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg3part3 = new RendererModel(this);
		leg3part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg3part2.addChild(leg3part3);
		leg3part3.cubeList.add(new ModelBox(leg3part3, 72, 24, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg4 = new RendererModel(this);
		leg4.setRotationPoint(-7.0F, 8.0F, 6.0F);
		hexapus.addChild(leg4);
		leg4.cubeList.add(new ModelBox(leg4, 72, 16, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg4part2 = new RendererModel(this);
		leg4part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg4.addChild(leg4part2);
		leg4part2.cubeList.add(new ModelBox(leg4part2, 50, 69, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg4part3 = new RendererModel(this);
		leg4part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg4part2.addChild(leg4part3);
		leg4part3.cubeList.add(new ModelBox(leg4part3, 42, 69, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg5 = new RendererModel(this);
		leg5.setRotationPoint(-7.0F, 8.0F, -1.0F);
		hexapus.addChild(leg5);
		leg5.cubeList.add(new ModelBox(leg5, 34, 65, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg5part2 = new RendererModel(this);
		leg5part2.setRotationPoint(0.0F, 7.0F, 0.0F);
		leg5.addChild(leg5part2);
		leg5part2.cubeList.add(new ModelBox(leg5part2, 26, 65, -1.0F, -1.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg5part3 = new RendererModel(this);
		leg5part3.setRotationPoint(0.0F, 5.0F, 0.0F);
		leg5part2.addChild(leg5part3);
		leg5part3.cubeList.add(new ModelBox(leg5part3, 64, 24, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg6 = new RendererModel(this);
		leg6.setRotationPoint(-7.0F, 8.0F, -8.0F);
		hexapus.addChild(leg6);
		leg6.cubeList.add(new ModelBox(leg6, 64, 16, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg6part2 = new RendererModel(this);
		leg6part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg6.addChild(leg6part2);
		leg6part2.cubeList.add(new ModelBox(leg6part2, 44, 48, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg6part3 = new RendererModel(this);
		leg6part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg6part2.addChild(leg6part3);
		leg6part3.cubeList.add(new ModelBox(leg6part3, 36, 48, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg7 = new RendererModel(this);
		leg7.setRotationPoint(0.0F, 8.0F, 6.0F);
		hexapus.addChild(leg7);
		leg7.cubeList.add(new ModelBox(leg7, 22, 48, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg7part2 = new RendererModel(this);
		leg7part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg7.addChild(leg7part2);
		leg7part2.cubeList.add(new ModelBox(leg7part2, 14, 48, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg7part3 = new RendererModel(this);
		leg7part3.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg7part2.addChild(leg7part3);
		leg7part3.cubeList.add(new ModelBox(leg7part3, 0, 48, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg8 = new RendererModel(this);
		leg8.setRotationPoint(0.0F, 8.0F, -8.0F);
		hexapus.addChild(leg8);
		leg8.cubeList.add(new ModelBox(leg8, 42, 33, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg8part2 = new RendererModel(this);
		leg8part2.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg8.addChild(leg8part2);
		leg8part2.cubeList.add(new ModelBox(leg8part2, 6, 39, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));

		leg8part4 = new RendererModel(this);
		leg8part4.setRotationPoint(0.0F, 6.0F, 0.0F);
		leg8part2.addChild(leg8part4);
		leg8part4.cubeList.add(new ModelBox(leg8part4, 0, 33, -1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F, false));
	}

	@Override
	public void render(BabyKracken entity, float f, float f1, float f2, float f3, float f4, float f5) {
		hexapus.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(BabyKracken entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.leg2.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg2part2.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing)) * 0.4);
		this.leg2part3.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing)) * 0.5);

		this.leg5.rotateAngleZ = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg5part2.rotateAngleZ = (float)(abs(Math.sin(limbSwing)) * 0.4);
		this.leg5part3.rotateAngleZ = (float)(abs(Math.sin(limbSwing)) * 0.5);

		this.leg8.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg8part2.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.4);
		this.leg8part4.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.5);

		this.leg7.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg7part2.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.4);
		this.leg7part3.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.5);


		this.leg1.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg1.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing )) * 0.3);
		this.leg1part2.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg1part2.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg1part3.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg1part3.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing )) * 0.3);

		this.leg4.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg4.rotateAngleZ = (float)(abs(Math.sin(limbSwing )) * 0.3);
		this.leg4part2.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg4part2.rotateAngleZ = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg4part3.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg4part3.rotateAngleZ = (float)(abs(Math.sin(limbSwing )) * 0.3);

		this.leg6.rotateAngleX = (float)(-1 *abs(Math.sin(limbSwing)) * 0.3);
		this.leg6.rotateAngleZ = (float)(abs(Math.sin(limbSwing )) * 0.3);
		this.leg6part2.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg6part2.rotateAngleZ = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg6part3.rotateAngleX = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg6part3.rotateAngleZ = (float)(abs(Math.sin(limbSwing )) * 0.3);

		this.leg3.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg3.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing )) * 0.3);
		this.leg3part2.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg3part2.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing)) * 0.3);
		this.leg3part3.rotateAngleX = (float)(abs(Math.sin(limbSwing)) * 0.3);
		this.leg3part3.rotateAngleZ = (float)(-1 * abs(Math.sin(limbSwing )) * 0.3);



	}
}