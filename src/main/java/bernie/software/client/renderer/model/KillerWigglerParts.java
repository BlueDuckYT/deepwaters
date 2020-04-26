package bernie.software.client.renderer.model;
//import net.minecraft.client.renderer.entity.model.EntityModel;
//import net.minecraft.client.renderer.entity.model.RendererModel;
//import net.minecraft.client.renderer.model.ModelBox;
////Made with Blockbench
////Paste this code into your mod.
//import net.minecraft.entity.Entity;
//
//public class KillerWigglerParts extends EntityModel {
//	private final RendererModel tail;
//	private final RendererModel tail_left;
//	private final RendererModel tail_right;
//	private final RendererModel head;
//	private final RendererModel right_claws;
//	private final RendererModel right_claws_top;
//	private final RendererModel right_claws_bottom;
//	private final RendererModel left_claws;
//	private final RendererModel left_claws_top;
//	private final RendererModel left_claws_bottom;
//	private final RendererModel center_claws_up;
//	private final RendererModel center_claws_down;
//	private final RendererModel body_part1;
//	private final RendererModel LL1;
//	private final RendererModel pt1_LL1;
//	private final RendererModel pt2_LL1;
//	private final RendererModel RL1;
//	private final RendererModel pt1_RL1;
//	private final RendererModel pt2_RL1;
//
//	public KillerWigglerParts() {
//		textureWidth = 512;
//		textureHeight = 512;
//
//		tail = new RendererModel(this);
//		tail.setRotationPoint(0.0F, -9.0F, 66.0F);
//		tail.cubeList.add(new ModelBox(tail, 0, 40, -8.0F, -5.1F, 0.0F, 16, 10, 14, 0.0F, false));
//
//		tail_left = new RendererModel(this);
//		tail_left.setRotationPoint(4.0F, -0.3F, 12.9F);
//		tail.addChild(tail_left);
//		tail_left.cubeList.add(new ModelBox(tail_left, 66, 66, -2.0F, -2.0F, 0.0F, 4, 4, 16, 0.0F, false));
//
//		tail_right = new RendererModel(this);
//		tail_right.setRotationPoint(-4.0F, -0.3F, 12.9F);
//		tail.addChild(tail_right);
//		tail_right.cubeList.add(new ModelBox(tail_right, 66, 66, -2.0F, -2.0F, 0.0F, 4, 4, 16, 0.0F, false));
//
//		head = new RendererModel(this);
//		head.setRotationPoint(0.0F, -9.0F, -46.0F);
//		head.cubeList.add(new ModelBox(head, 42, 46, -13.0F, -9.4F, -20.0F, 2, 18, 18, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 42, 46, 11.0F, -9.4F, -20.0F, 2, 18, 18, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 0, 82, -11.0F, -9.4F, -22.0F, 22, 18, 4, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 64, 40, -11.0F, -9.4F, -2.0F, 22, 18, 2, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 0, 64, -6.0F, -7.9F, -22.5F, 12, 12, 4, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 0, 20, -11.0F, -11.4F, -20.0F, 22, 2, 18, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 0, 0, -11.0F, 8.6F, -20.0F, 22, 2, 18, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 62, 0, -7.0F, 4.6F, -26.0F, 4, 4, 4, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 62, 0, 3.0F, 4.6F, -26.0F, 4, 4, 4, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 16, 172, -7.0F, 10.6F, -22.9F, 4, 4, 6, 0.0F, false));
//		head.cubeList.add(new ModelBox(head, 16, 172, 3.0F, 10.6F, -22.9F, 4, 4, 6, 0.0F, false));
//
//		right_claws = new RendererModel(this);
//		right_claws.setRotationPoint(-12.0F, -1.2F, -13.6494F);
//		setRotationAngle(right_claws, 0.0F, -0.4363F, 0.0F);
//		head.addChild(right_claws);
//
//		right_claws_top = new RendererModel(this);
//		right_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
//		right_claws.addChild(right_claws_top);
//		right_claws_top.cubeList.add(new ModelBox(right_claws_top, 84, 0, -9.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));
//		right_claws_top.cubeList.add(new ModelBox(right_claws_top, 84, 12, -9.8715F, -2.0F, -2.0F, 10, 4, 4, 0.0F, true));
//
//		right_claws_bottom = new RendererModel(this);
//		right_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
//		right_claws.addChild(right_claws_bottom);
//		right_claws_bottom.cubeList.add(new ModelBox(right_claws_bottom, 84, 12, -9.8715F, -2.0F, -2.0F, 10, 4, 4, 0.0F, true));
//		right_claws_bottom.cubeList.add(new ModelBox(right_claws_bottom, 84, 0, -9.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));
//
//		left_claws = new RendererModel(this);
//		left_claws.setRotationPoint(12.0F, -1.2F, -13.6494F);
//		setRotationAngle(left_claws, 0.0F, 0.4363F, 0.0F);
//		head.addChild(left_claws);
//
//		left_claws_top = new RendererModel(this);
//		left_claws_top.setRotationPoint(0.0F, -3.0F, 0.0F);
//		left_claws.addChild(left_claws_top);
//		left_claws_top.cubeList.add(new ModelBox(left_claws_top, 84, 12, -0.1285F, -2.0F, -2.0F, 10, 4, 4, 0.0F, false));
//		left_claws_top.cubeList.add(new ModelBox(left_claws_top, 84, 0, 5.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));
//
//		left_claws_bottom = new RendererModel(this);
//		left_claws_bottom.setRotationPoint(0.0F, 3.0F, 0.0F);
//		left_claws.addChild(left_claws_bottom);
//		left_claws_bottom.cubeList.add(new ModelBox(left_claws_bottom, 84, 12, -0.1285F, -2.0F, -2.0F, 10, 4, 4, 0.0F, false));
//		left_claws_bottom.cubeList.add(new ModelBox(left_claws_bottom, 84, 0, 5.8715F, -2.0F, -10.0F, 4, 4, 8, 0.0F, false));
//
//		center_claws_up = new RendererModel(this);
//		center_claws_up.setRotationPoint(0.55F, 23.0F, 10.5F);
//		setRotationAngle(center_claws_up, 0.8727F, 0.0F, 0.0F);
//		head.addChild(center_claws_up);
//		center_claws_up.cubeList.add(new ModelBox(center_claws_up, 0, 20, -6.45F, -39.01F, -16.0443F, 2, 2, 6, 0.0F, false));
//		center_claws_up.cubeList.add(new ModelBox(center_claws_up, 0, 20, 3.35F, -39.01F, -16.0443F, 2, 2, 6, 0.0F, false));
//
//		center_claws_down = new RendererModel(this);
//		center_claws_down.setRotationPoint(-0.45F, 26.2866F, 12.1896F);
//		setRotationAngle(center_claws_down, -0.0873F, 0.0F, 0.0F);
//		head.addChild(center_claws_down);
//		center_claws_down.cubeList.add(new ModelBox(center_claws_down, 0, 20, -5.55F, -11.076F, -41.4911F, 2, 2, 6, 0.0F, false));
//		center_claws_down.cubeList.add(new ModelBox(center_claws_down, 0, 20, 4.45F, -11.076F, -41.4911F, 2, 2, 6, 0.0F, false));
//
//		body_part1 = new RendererModel(this);
//		body_part1.setRotationPoint(0.0F, -8.5F, -47.0F);
//		body_part1.cubeList.add(new ModelBox(body_part1, 156, 28, -9.0F, -6.6F, 1.0F, 18, 12, 14, 0.0F, false));
//		body_part1.cubeList.add(new ModelBox(body_part1, 0, 0, -2.0F, -10.6F, 5.8F, 4, 4, 4, 0.0F, false));
//
//		LL1 = new RendererModel(this);
//		LL1.setRotationPoint(7.29F, -0.33F, 7.8F);
//		body_part1.addChild(LL1);
//
//		pt1_LL1 = new RendererModel(this);
//		pt1_LL1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL1, 0.0F, 0.0F, -0.8727F);
//		LL1.addChild(pt1_LL1);
//		pt1_LL1.cubeList.add(new ModelBox(pt1_LL1, 0, 124, -2.0006F, -0.0032F, -3.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL1 = new RendererModel(this);
//		pt2_LL1.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL1, 0.0F, 0.0F, -0.1745F);
//		LL1.addChild(pt2_LL1);
//		pt2_LL1.cubeList.add(new ModelBox(pt2_LL1, 90, 60, -2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F, false));
//
//		RL1 = new RendererModel(this);
//		RL1.setRotationPoint(-7.29F, -0.33F, 7.8F);
//		body_part1.addChild(RL1);
//
//		pt1_RL1 = new RendererModel(this);
//		pt1_RL1.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL1, 0.0F, 0.0F, 0.8727F);
//		RL1.addChild(pt1_RL1);
//		pt1_RL1.cubeList.add(new ModelBox(pt1_RL1, 0, 124, -1.9994F, -0.0032F, -3.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL1 = new RendererModel(this);
//		pt2_RL1.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL1, 0.0F, 0.0F, 0.1745F);
//		RL1.addChild(pt2_RL1);
//		pt2_RL1.cubeList.add(new ModelBox(pt2_RL1, 90, 60, -2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F, false));
//	}
//
//	@Override
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		tail.render(f5);
//		head.render(f5);
//		body_part1.render(f5);
//	}
//	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//}

public class KillerWigglerParts {}