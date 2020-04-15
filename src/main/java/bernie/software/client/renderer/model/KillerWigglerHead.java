package bernie.software.client.renderer.model;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

//Made with Blockbench
//Paste this code into your mod.
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class KillerWigglerHead extends AbstractWormPart {
	private final RendererModel head;
	private final RendererModel right_claws;
	private final RendererModel right_claws_top;
	private final RendererModel right_claws_bottom;
	private final RendererModel left_claws;
	private final RendererModel left_claws_top;
	private final RendererModel left_claws_bottom;
	private final RendererModel center_claws_up;
	private final RendererModel center_claws_down;

	@Override
	ArrayList<ModelBox> bodyBoxes() {
		return null;
	}

	public KillerWigglerHead() {
		textureWidth = 512;
		textureHeight = 512;

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, -9.0F, 9.0F);
		head.cubeList.add(new ModelBox(head, 42, 46, -13.0F, -9.4F, -20.0F, 2, 18, 18, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 42, 46, 11.0F, -9.4F, -20.0F, 2, 18, 18, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 82, -11.0F, -9.4F, -22.0F, 22, 18, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 64, 40, -11.0F, -9.4F, -2.0F, 22, 18, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 64, -6.0F, -7.9F, -22.5F, 12, 12, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 20, -11.0F, -11.4F, -20.0F, 22, 2, 18, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -11.0F, 8.6F, -20.0F, 22, 2, 18, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 62, 0, -7.0F, 4.6F, -26.0F, 4, 4, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 62, 0, 3.0F, 4.6F, -26.0F, 4, 4, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 172, -7.0F, 10.6F, -22.9F, 4, 4, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 172, 3.0F, 10.6F, -22.9F, 4, 4, 6, 0.0F, false));

		right_claws = new RendererModel(this);
		right_claws.setRotationPoint(-12.0F, -1.2F, -13.6494F);
		setRotationAngle(right_claws, 0.0F, -0.4363F, 0.0F);
		head.addChild(right_claws);

		right_claws_top = new RendererModel(this);
		right_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
		right_claws.addChild(right_claws_top);
		right_claws_top.cubeList.add(new ModelBox(right_claws_top, 84, 0, -9.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));
		right_claws_top.cubeList.add(new ModelBox(right_claws_top, 84, 12, -9.8715F, -2.0F, -2.0F, 10, 4, 4, 0.0F, true));

		right_claws_bottom = new RendererModel(this);
		right_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
		right_claws.addChild(right_claws_bottom);
		right_claws_bottom.cubeList.add(new ModelBox(right_claws_bottom, 84, 12, -9.8715F, -2.0F, -2.0F, 10, 4, 4, 0.0F, true));
		right_claws_bottom.cubeList.add(new ModelBox(right_claws_bottom, 84, 0, -9.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));

		left_claws = new RendererModel(this);
		left_claws.setRotationPoint(12.0F, -1.2F, -13.6494F);
		setRotationAngle(left_claws, 0.0F, 0.4363F, 0.0F);
		head.addChild(left_claws);

		left_claws_top = new RendererModel(this);
		left_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
		left_claws.addChild(left_claws_top);
		left_claws_top.cubeList.add(new ModelBox(left_claws_top, 84, 12, -0.1285F, -2.0F, -2.0F, 10, 4, 4, 0.0F, false));
		left_claws_top.cubeList.add(new ModelBox(left_claws_top, 84, 0, 5.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));

		left_claws_bottom = new RendererModel(this);
		left_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
		left_claws.addChild(left_claws_bottom);
		left_claws_bottom.cubeList.add(new ModelBox(left_claws_bottom, 84, 12, -0.1285F, -2.0F, -2.0F, 10, 4, 4, 0.0F, false));
		left_claws_bottom.cubeList.add(new ModelBox(left_claws_bottom, 84, 0, 5.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));

		center_claws_up = new RendererModel(this);
		center_claws_up.setRotationPoint(0.55F, 23.0F, 10.5F);
		setRotationAngle(center_claws_up, 0.8727F, 0.0F, 0.0F);
		head.addChild(center_claws_up);
		center_claws_up.cubeList.add(new ModelBox(center_claws_up, 0, 20, -6.45F, -39.01F, -16.0443F, 2, 2, 6, 0.0F, false));
		center_claws_up.cubeList.add(new ModelBox(center_claws_up, 0, 20, 3.35F, -39.01F, -16.0443F, 2, 2, 6, 0.0F, false));

		center_claws_down = new RendererModel(this);
		center_claws_down.setRotationPoint(-0.45F, 26.2866F, 12.1896F);
		setRotationAngle(center_claws_down, -0.0873F, 0.0F, 0.0F);
		head.addChild(center_claws_down);
		center_claws_down.cubeList.add(new ModelBox(center_claws_down, 0, 20, -5.55F, -11.076F, -41.4911F, 2, 2, 6, 0.0F, false));
		center_claws_down.cubeList.add(new ModelBox(center_claws_down, 0, 20, 4.45F, -11.076F, -41.4911F, 2, 2, 6, 0.0F, false));
		setModel(head);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}