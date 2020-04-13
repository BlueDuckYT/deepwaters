package bernie.software.client.renderer.model;

import bernie.software.entity.vehicle.SurgeVehicle;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class SurgeModel extends EntityModel<SurgeVehicle>
{
	private final RendererModel Main;
	private final RendererModel Hatch;
	private final RendererModel Body;
	private final RendererModel Right_Screw;
	private final RendererModel Left_Screw;

	public SurgeModel()
	{
		textureWidth = 94;
		textureHeight = 47;

		Main = new RendererModel(this);
		Main.setRotationPoint(0.0F, 24.0F, -3.0F);

		Hatch = new RendererModel(this);
		Hatch.setRotationPoint(0.0F, -3.1F, -4.0F);
		Main.addChild(Hatch);
		Hatch.cubeList.add(new ModelBox(Hatch, 70, 24, -2.0F, -2.5F, -6.1F, 4, 1, 6, 0.0F, false));

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, -1.0F, -0.3F);
		Main.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 0, 21, 4.0F, -5.5F, -10.7F, 1, 6, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 21, -10.0F, -5.5F, -8.7F, 1, 6, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 21, 9.0F, -5.5F, -8.7F, 1, 6, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 21, -5.0F, -5.5F, -10.7F, 1, 6, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, 5.0F, -5.5F, -9.7F, 4, 1, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -9.0F, -5.5F, -9.7F, 4, 1, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 42, 26, 5.0F, -0.5F, -9.7F, 4, 1, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 42, 26, -9.0F, -0.5F, -9.7F, 4, 1, 20, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 28, 2, -3.0F, -4.5F, -9.7F, 6, 4, 14, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 72, 18, -3.0F, -3.5F, -11.7F, 6, 2, 2, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 6, -4.0F, -3.5F, -6.7F, 1, 2, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 6, 3.0F, -3.5F, -6.7F, 1, 2, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 54, 13, -3.0F, -3.0F, 5.3F, 6, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 1, 0, 2.0F, -3.5F, 4.3F, 1, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -3.0F, -3.5F, 4.3F, 1, 2, 1, 0.0F, false));

		Right_Screw = new RendererModel(this);
		Right_Screw.setRotationPoint(-7.0F, -3.5F, 1.0F);
		Main.addChild(Right_Screw);
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, -2.0F, -10.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 46, 0, -1.0F, -1.0F, -11.0F, 2, 2, 22, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, -2.0F, 6.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, -2.0F, 5.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, -2.0F, 9.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, 0.0F, 4.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, 0.0F, 8.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, 0.0F, 3.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, 0.0F, 7.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, -2.0F, 2.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, -2.0F, -2.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, -2.0F, -6.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, -2.0F, 1.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, -2.0F, -3.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, -2.0F, -7.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, 0.0F, -4.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, -2.0F, 0.0F, -8.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, 0.0F, -5.0F, 2, 2, 1, 0.0F, false));
		Right_Screw.cubeList.add(new ModelBox(Right_Screw, 0, 0, 0.0F, 0.0F, -9.0F, 2, 2, 1, 0.0F, false));

		Left_Screw = new RendererModel(this);
		Left_Screw.setRotationPoint(7.0F, -3.5F, 1.0F);
		Main.addChild(Left_Screw);
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, -2.0F, -10.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 46, 0, -1.0F, -1.0F, -11.0F, 2, 2, 22, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, -2.0F, 6.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, -2.0F, 5.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, -2.0F, 9.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, 0.0F, 4.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, 0.0F, 8.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, 0.0F, 3.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, 0.0F, 7.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, -2.0F, 2.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, -2.0F, -2.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, -2.0F, -6.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, -2.0F, 1.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, -2.0F, -3.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, -2.0F, -7.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, 0.0F, -4.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, 0.0F, 0.0F, -8.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, 0.0F, -5.0F, 2, 2, 1, 0.0F, false));
		Left_Screw.cubeList.add(new ModelBox(Left_Screw, 0, 0, -2.0F, 0.0F, -9.0F, 2, 2, 1, 0.0F, false));
	}

	@Override
	public void render(SurgeVehicle entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Main.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(SurgeVehicle entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{

		if (entityIn.getControllingPassenger() != null)
		{
			this.Right_Screw.rotateAngleZ = ageInTicks * 0.3F;
			this.Left_Screw.rotateAngleZ = ageInTicks * 0.3F;

		}

		this.Main.rotateAngleY = entityIn.rotationYaw * ((float) Math.PI / 180F) / 180;
		this.Main.rotateAngleX = entityIn.rotationPitch * ((float) Math.PI / 180F) / 180;

		this.Main.rotateAngleX = 0;
		//this.Main.rotateAngleY = entityIn.rotationYaw * ((float) Math.PI / 180F);
	}
}