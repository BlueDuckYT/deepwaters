package bernie.software.client.renderer.model;

import bernie.software.entity.SeaUrchin;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class SeaUrchinModel extends EntityModel<SeaUrchin>
{
	private final RendererModel unknown_bone;
	private final RendererModel bruh;
	private final RendererModel bruh2;
	private final RendererModel bruh3;
	private final RendererModel bruh4;
	private final RendererModel bruh5;
	private final RendererModel bruh6;
	private final RendererModel bruh7;
	private final RendererModel bruh8;
	private final RendererModel bone;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone5;
	private final RendererModel bone6;
	private final RendererModel bone7;
	private final RendererModel bone8;

	public SeaUrchinModel()
	{
		textureWidth = 64;
		textureHeight = 64;

		unknown_bone = new RendererModel(this);
		unknown_bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		unknown_bone.cubeList.add(new ModelBox(unknown_bone, 0, 0, -6.0F, -6.0F, -6.0F, 12, 6, 12, 0.0F, false));
		unknown_bone.cubeList.add(new ModelBox(unknown_bone, 0, 26, -1.0F, -12.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh = new RendererModel(this);
		bruh.setRotationPoint(0.0F, 16.6F, 7.4F);
		setRotationAngle(bruh, -0.7854F, 0.0F, 0.0F);
		bruh.cubeList.add(new ModelBox(bruh, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh2 = new RendererModel(this);
		bruh2.setRotationPoint(0.0F, 16.6F, -7.4F);
		setRotationAngle(bruh2, 0.7854F, 0.0F, 0.0F);
		bruh2.cubeList.add(new ModelBox(bruh2, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh3 = new RendererModel(this);
		bruh3.setRotationPoint(-6.4F, 16.6F, -6.4F);
		setRotationAngle(bruh3, 0.7854F, 0.7854F, 0.0F);
		bruh3.cubeList.add(new ModelBox(bruh3, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh4 = new RendererModel(this);
		bruh4.setRotationPoint(-6.4F, 16.6F, 6.6F);
		setRotationAngle(bruh4, 0.7854F, 2.3562F, 0.0F);
		bruh4.cubeList.add(new ModelBox(bruh4, 0, 26, -0.8586F, -2.8F, -0.8F, 2, 6, 2, 0.0F, false));

		bruh5 = new RendererModel(this);
		bruh5.setRotationPoint(6.3F, 16.6F, 6.3F);
		setRotationAngle(bruh5, 0.7854F, -2.3562F, 0.0F);
		bruh5.cubeList.add(new ModelBox(bruh5, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh6 = new RendererModel(this);
		bruh6.setRotationPoint(6.4F, 16.6F, -6.7F);
		setRotationAngle(bruh6, 0.7854F, -0.7854F, 0.0F);
		bruh6.cubeList.add(new ModelBox(bruh6, 0, 26, -0.8586F, -2.8F, -0.8F, 2, 6, 2, 0.0F, false));

		bruh7 = new RendererModel(this);
		bruh7.setRotationPoint(7.5F, 16.6F, 0.4F);
		setRotationAngle(bruh7, -0.7854F, 1.5708F, 0.0F);
		bruh7.cubeList.add(new ModelBox(bruh7, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bruh8 = new RendererModel(this);
		bruh8.setRotationPoint(-7.5F, 16.6F, 0.4F);
		setRotationAngle(bruh8, -0.7854F, -1.5708F, 0.0F);
		bruh8.cubeList.add(new ModelBox(bruh8, 0, 26, -1.0F, -3.0F, -1.0F, 2, 6, 2, 0.0F, false));

		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 21.0F, 7.0F);
		setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(0.0F, 21.0F, -7.0F);
		setRotationAngle(bone2, -1.5708F, 3.1416F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(-7.0F, 21.0F, 0.0F);
		setRotationAngle(bone3, -1.5708F, -1.5708F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(7.0F, 21.0F, 0.0F);
		setRotationAngle(bone4, -1.5708F, 1.5708F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(6.4F, 21.0F, -6.0F);
		setRotationAngle(bone5, -1.5708F, 2.3562F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(-6.6F, 21.0F, -6.0F);
		setRotationAngle(bone6, -1.5708F, -2.3562F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone7 = new RendererModel(this);
		bone7.setRotationPoint(-6.6F, 21.0F, 6.0F);
		setRotationAngle(bone7, -1.5708F, -0.8727F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));

		bone8 = new RendererModel(this);
		bone8.setRotationPoint(6.4F, 21.0F, 6.0F);
		setRotationAngle(bone8, -1.5708F, 0.7854F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 0, 26, -1.0F, -3.0F, 1.0F, 2, 6, 2, 0.0F, false));
	}

	@Override
	public void render(SeaUrchin entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		unknown_bone.render(f5);
		bruh.render(f5);
		bruh2.render(f5);
		bruh3.render(f5);
		bruh4.render(f5);
		bruh5.render(f5);
		bruh6.render(f5);
		bruh7.render(f5);
		bruh8.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
		bone5.render(f5);
		bone6.render(f5);
		bone7.render(f5);
		bone8.render(f5);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}