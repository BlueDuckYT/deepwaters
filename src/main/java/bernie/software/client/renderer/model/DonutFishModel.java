package bernie.software.client.renderer.model;

import bernie.software.entity.DonutFish;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class DonutFishModel extends EntityModel<DonutFish>
{
	private final RendererModel Tail;
	private final RendererModel Body;
	private final RendererModel Fin;
	private final RendererModel Head;

	public DonutFishModel()
	{
		textureWidth = 16;
		textureHeight = 16;

		Tail = new RendererModel(this);
		Tail.setRotationPoint(0.0F, 22.0F, 2.0F);
		Tail.cubeList.add(new ModelBox(Tail, 2, 7, 0.0F, -1.0F, 0.0F, 0, 2, 2, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 4, 7, 0.0F, 0.0F, 2.0F, 0, 1, 1, 0.0F, false));

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 22.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -0.5F, -2.0F, -2.0F, 1, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 0, -0.5F, -2.0F, -1.0F, 1, 1, 2, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 0, -0.5F, -2.0F, 1.0F, 1, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 10, 0, -0.5F, 1.0F, -1.0F, 1, 1, 2, 0.0F, false));

		Fin = new RendererModel(this);
		Fin.setRotationPoint(0.0F, 20.0F, 0.0F);
		Fin.cubeList.add(new ModelBox(Fin, 2, 7, 0.0F, -2.0F, -1.0F, 0, 2, 2, 0.0F, false));
		Fin.cubeList.add(new ModelBox(Fin, 4, 7, 0.0F, -1.0F, 1.0F, 0, 1, 1, 0.0F, false));
		Fin.cubeList.add(new ModelBox(Fin, 2, 7, 0.0F, -1.0F, -2.0F, 0, 1, 1, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(0.0F, 22.0F, -2.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 5, -1.0F, -1.0F, -1.0F, 2, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 7, 0.0F, 0.0F, -2.0F, 0, 1, 1, 0.0F, false));
	}

	@Override
	public void render(DonutFish entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Tail.render(f5);
		Body.render(f5);
		Fin.render(f5);
		Head.render(f5);
	}


	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(DonutFish entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		this.Tail.rotateAngleY = (MathHelper.sin((float) (limbSwing * 2.5)) * 0.5F);
		this.Fin.rotateAngleZ = (MathHelper.sin((float) (limbSwing * 2.5)) * 0.5F);
	}
}