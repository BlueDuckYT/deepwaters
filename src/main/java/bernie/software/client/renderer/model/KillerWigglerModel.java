package bernie.software.client.renderer.model;

import bernie.software.entity.KillerWiggler;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
// Designed with Blockbench by pnamota/Sprint
// Paste this code into your mod.
// Make sure to generate all required imports

public class KillerWigglerModel extends EntityModel<KillerWiggler> {
	private final RendererModel main;
//	private final RendererModel body;
//	private final RendererModel body_part1;
//	private final RendererModel LL1;
//	private final RendererModel pt1_LL1;
//	private final RendererModel pt2_LL1;
//	private final RendererModel RL1;
//	private final RendererModel pt1_RL1;
//	private final RendererModel pt2_RL1;
//	private final RendererModel all_except1;
//	private final RendererModel body_part2;
//	private final RendererModel LL2;
//	private final RendererModel pt1_LL2;
//	private final RendererModel pt2_LL2;
//	private final RendererModel RL2;
//	private final RendererModel pt1_RL2;
//	private final RendererModel pt2_RL2;
//	private final RendererModel all_except21;
//	private final RendererModel body_part3;
//	private final RendererModel LL3;
//	private final RendererModel pt1_LL3;
//	private final RendererModel pt2_LL3;
//	private final RendererModel RL3;
//	private final RendererModel pt1_RL3;
//	private final RendererModel pt2_RL3;
//	private final RendererModel all_except321;
//	private final RendererModel body_part4;
//	private final RendererModel LL4;
//	private final RendererModel pt1_LL4;
//	private final RendererModel pt2_LL4;
//	private final RendererModel RL4;
//	private final RendererModel pt1_RL4;
//	private final RendererModel pt2_RL4;
//	private final RendererModel all_except4321;
//	private final RendererModel body_part5;
//	private final RendererModel LL5;
//	private final RendererModel pt1_LL5;
//	private final RendererModel pt2_LL5;
//	private final RendererModel RL5;
//	private final RendererModel pt1_RL5;
//	private final RendererModel pt2_RL5;
//	private final RendererModel all_except54321;
//	private final RendererModel body_part6;
//	private final RendererModel LL6;
//	private final RendererModel pt1_LL6;
//	private final RendererModel pt2_LL6;
//	private final RendererModel RL6;
//	private final RendererModel pt1_RL6;
//	private final RendererModel pt2_RL6;
//	private final RendererModel all_except654321;
//	private final RendererModel body_part7;
//	private final RendererModel LL7;
//	private final RendererModel pt1_LL7;
//	private final RendererModel pt2_LL7;
//	private final RendererModel RL7;
//	private final RendererModel pt1_RL7;
//	private final RendererModel pt2_RL7;
//	private final RendererModel all_except7654321;
//	private final RendererModel body_part8;
//	private final RendererModel LL8;
//	private final RendererModel pt1_LL8;
//	private final RendererModel pt2_LL8;
//	private final RendererModel RL8;
//	private final RendererModel pt1_RL8;
//	private final RendererModel pt2_RL8;
//	private final RendererModel all_except87654321;
//	private final RendererModel tail;
//	private final RendererModel tail_left;
//	private final RendererModel tail_right;
//	private final RendererModel spikes;
//	private final RendererModel head;
//	private final RendererModel right_claws;
//	private final RendererModel right_claws_top;
//	private final RendererModel right_claws_bottom;
//	private final RendererModel left_claws;
//	private final RendererModel left_claws_top;
//	private final RendererModel left_claws_bottom;
//	private final RendererModel center_claws_up;
//	private final RendererModel center_claws_down;

	public KillerWigglerModel() {
		textureWidth = 512;
		textureHeight = 512;

		main = new RendererModel(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);
//
//		body = new RendererModel(this);
//		body.setRotationPoint(0.0F, 0.0F, 0.5F);
//		main.addChild(body);
//
//		body_part1 = new RendererModel(this);
//		body_part1.setRotationPoint(0.0F, -32.5F, -47.5F);
//		body.addChild(body_part1);
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
//
//		all_except1 = new RendererModel(this);
//		all_except1.setRotationPoint(0.0F, -33.0F, -32.0F);
//		body.addChild(all_except1);
//
//		body_part2 = new RendererModel(this);
//		body_part2.setRotationPoint(0.0F, 0.5F, 6.5F);
//		all_except1.addChild(body_part2);
//		body_part2.cubeList.add(new ModelBox(body_part2, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part2.cubeList.add(new ModelBox(body_part2, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL2 = new RendererModel(this);
//		LL2.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part2.addChild(LL2);
//
//		pt1_LL2 = new RendererModel(this);
//		pt1_LL2.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL2, 0.0F, 0.0F, -0.8727F);
//		LL2.addChild(pt1_LL2);
//		pt1_LL2.cubeList.add(new ModelBox(pt1_LL2, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL2 = new RendererModel(this);
//		pt2_LL2.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL2, 0.0F, 0.0F, -0.1745F);
//		LL2.addChild(pt2_LL2);
//		pt2_LL2.cubeList.add(new ModelBox(pt2_LL2, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL2 = new RendererModel(this);
//		RL2.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part2.addChild(RL2);
//
//		pt1_RL2 = new RendererModel(this);
//		pt1_RL2.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL2, 0.0F, 0.0F, 0.8727F);
//		RL2.addChild(pt1_RL2);
//		pt1_RL2.cubeList.add(new ModelBox(pt1_RL2, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL2 = new RendererModel(this);
//		pt2_RL2.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL2, 0.0F, 0.0F, 0.1745F);
//		RL2.addChild(pt2_RL2);
//		pt2_RL2.cubeList.add(new ModelBox(pt2_RL2, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except21 = new RendererModel(this);
//		all_except21.setRotationPoint(0.0F, 0.0F, 13.5F);
//		all_except1.addChild(all_except21);
//
//		body_part3 = new RendererModel(this);
//		body_part3.setRotationPoint(0.0F, 0.5F, 7.0F);
//		all_except21.addChild(body_part3);
//		body_part3.cubeList.add(new ModelBox(body_part3, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part3.cubeList.add(new ModelBox(body_part3, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL3 = new RendererModel(this);
//		LL3.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part3.addChild(LL3);
//
//		pt1_LL3 = new RendererModel(this);
//		pt1_LL3.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL3, 0.0F, 0.0F, -0.8727F);
//		LL3.addChild(pt1_LL3);
//		pt1_LL3.cubeList.add(new ModelBox(pt1_LL3, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL3 = new RendererModel(this);
//		pt2_LL3.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL3, 0.0F, 0.0F, -0.1745F);
//		LL3.addChild(pt2_LL3);
//		pt2_LL3.cubeList.add(new ModelBox(pt2_LL3, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL3 = new RendererModel(this);
//		RL3.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part3.addChild(RL3);
//
//		pt1_RL3 = new RendererModel(this);
//		pt1_RL3.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL3, 0.0F, 0.0F, 0.8727F);
//		RL3.addChild(pt1_RL3);
//		pt1_RL3.cubeList.add(new ModelBox(pt1_RL3, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL3 = new RendererModel(this);
//		pt2_RL3.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL3, 0.0F, 0.0F, 0.1745F);
//		RL3.addChild(pt2_RL3);
//		pt2_RL3.cubeList.add(new ModelBox(pt2_RL3, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except321 = new RendererModel(this);
//		all_except321.setRotationPoint(0.0F, 0.0F, 14.0F);
//		all_except21.addChild(all_except321);
//
//		body_part4 = new RendererModel(this);
//		body_part4.setRotationPoint(0.0F, 0.5F, 7.0F);
//		all_except321.addChild(body_part4);
//		body_part4.cubeList.add(new ModelBox(body_part4, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part4.cubeList.add(new ModelBox(body_part4, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL4 = new RendererModel(this);
//		LL4.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part4.addChild(LL4);
//
//		pt1_LL4 = new RendererModel(this);
//		pt1_LL4.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL4, 0.0F, 0.0F, -0.8727F);
//		LL4.addChild(pt1_LL4);
//		pt1_LL4.cubeList.add(new ModelBox(pt1_LL4, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL4 = new RendererModel(this);
//		pt2_LL4.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL4, 0.0F, 0.0F, -0.1745F);
//		LL4.addChild(pt2_LL4);
//		pt2_LL4.cubeList.add(new ModelBox(pt2_LL4, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL4 = new RendererModel(this);
//		RL4.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part4.addChild(RL4);
//
//		pt1_RL4 = new RendererModel(this);
//		pt1_RL4.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL4, 0.0F, 0.0F, 0.8727F);
//		RL4.addChild(pt1_RL4);
//		pt1_RL4.cubeList.add(new ModelBox(pt1_RL4, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL4 = new RendererModel(this);
//		pt2_RL4.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL4, 0.0F, 0.0F, 0.1745F);
//		RL4.addChild(pt2_RL4);
//		pt2_RL4.cubeList.add(new ModelBox(pt2_RL4, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except4321 = new RendererModel(this);
//		all_except4321.setRotationPoint(0.0F, 0.0F, 14.0F);
//		all_except321.addChild(all_except4321);
//
//		body_part5 = new RendererModel(this);
//		body_part5.setRotationPoint(0.0F, 0.5F, 7.0F);
//		all_except4321.addChild(body_part5);
//		body_part5.cubeList.add(new ModelBox(body_part5, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part5.cubeList.add(new ModelBox(body_part5, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL5 = new RendererModel(this);
//		LL5.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part5.addChild(LL5);
//
//		pt1_LL5 = new RendererModel(this);
//		pt1_LL5.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL5, 0.0F, 0.0F, -0.8727F);
//		LL5.addChild(pt1_LL5);
//		pt1_LL5.cubeList.add(new ModelBox(pt1_LL5, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL5 = new RendererModel(this);
//		pt2_LL5.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL5, 0.0F, 0.0F, -0.1745F);
//		LL5.addChild(pt2_LL5);
//		pt2_LL5.cubeList.add(new ModelBox(pt2_LL5, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL5 = new RendererModel(this);
//		RL5.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part5.addChild(RL5);
//
//		pt1_RL5 = new RendererModel(this);
//		pt1_RL5.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL5, 0.0F, 0.0F, 0.8727F);
//		RL5.addChild(pt1_RL5);
//		pt1_RL5.cubeList.add(new ModelBox(pt1_RL5, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL5 = new RendererModel(this);
//		pt2_RL5.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL5, 0.0F, 0.0F, 0.1745F);
//		RL5.addChild(pt2_RL5);
//		pt2_RL5.cubeList.add(new ModelBox(pt2_RL5, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except54321 = new RendererModel(this);
//		all_except54321.setRotationPoint(0.0F, 0.0F, 14.0F);
//		all_except4321.addChild(all_except54321);
//
//		body_part6 = new RendererModel(this);
//		body_part6.setRotationPoint(0.0F, 0.5F, 7.0F);
//		all_except54321.addChild(body_part6);
//		body_part6.cubeList.add(new ModelBox(body_part6, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part6.cubeList.add(new ModelBox(body_part6, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL6 = new RendererModel(this);
//		LL6.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part6.addChild(LL6);
//
//		pt1_LL6 = new RendererModel(this);
//		pt1_LL6.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL6, 0.0F, 0.0F, -0.8727F);
//		LL6.addChild(pt1_LL6);
//		pt1_LL6.cubeList.add(new ModelBox(pt1_LL6, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL6 = new RendererModel(this);
//		pt2_LL6.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL6, 0.0F, 0.0F, -0.1745F);
//		LL6.addChild(pt2_LL6);
//		pt2_LL6.cubeList.add(new ModelBox(pt2_LL6, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL6 = new RendererModel(this);
//		RL6.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part6.addChild(RL6);
//
//		pt1_RL6 = new RendererModel(this);
//		pt1_RL6.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL6, 0.0F, 0.0F, 0.8727F);
//		RL6.addChild(pt1_RL6);
//		pt1_RL6.cubeList.add(new ModelBox(pt1_RL6, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL6 = new RendererModel(this);
//		pt2_RL6.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL6, 0.0F, 0.0F, 0.1745F);
//		RL6.addChild(pt2_RL6);
//		pt2_RL6.cubeList.add(new ModelBox(pt2_RL6, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except654321 = new RendererModel(this);
//		all_except654321.setRotationPoint(0.0F, 0.0F, 14.0F);
//		all_except54321.addChild(all_except654321);
//
//		body_part7 = new RendererModel(this);
//		body_part7.setRotationPoint(0.0F, 0.5F, 7.0F);
//		all_except654321.addChild(body_part7);
//		body_part7.cubeList.add(new ModelBox(body_part7, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part7.cubeList.add(new ModelBox(body_part7, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL7 = new RendererModel(this);
//		LL7.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part7.addChild(LL7);
//
//		pt1_LL7 = new RendererModel(this);
//		pt1_LL7.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL7, 0.0F, 0.0F, -0.8727F);
//		LL7.addChild(pt1_LL7);
//		pt1_LL7.cubeList.add(new ModelBox(pt1_LL7, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL7 = new RendererModel(this);
//		pt2_LL7.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL7, 0.0F, 0.0F, -0.1745F);
//		LL7.addChild(pt2_LL7);
//		pt2_LL7.cubeList.add(new ModelBox(pt2_LL7, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL7 = new RendererModel(this);
//		RL7.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part7.addChild(RL7);
//
//		pt1_RL7 = new RendererModel(this);
//		pt1_RL7.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL7, 0.0F, 0.0F, 0.8727F);
//		RL7.addChild(pt1_RL7);
//		pt1_RL7.cubeList.add(new ModelBox(pt1_RL7, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL7 = new RendererModel(this);
//		pt2_RL7.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL7, 0.0F, 0.0F, 0.1745F);
//		RL7.addChild(pt2_RL7);
//		pt2_RL7.cubeList.add(new ModelBox(pt2_RL7, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except7654321 = new RendererModel(this);
//		all_except7654321.setRotationPoint(0.0F, 0.0F, 15.0F);
//		all_except654321.addChild(all_except7654321);
//
//		body_part8 = new RendererModel(this);
//		body_part8.setRotationPoint(0.0F, 0.5F, 6.0F);
//		all_except7654321.addChild(body_part8);
//		body_part8.cubeList.add(new ModelBox(body_part8, 156, 0, -9.0F, -6.6F, -7.0F, 18, 12, 14, 0.0F, false));
//		body_part8.cubeList.add(new ModelBox(body_part8, 0, 0, -2.0F, -10.6F, -2.2F, 4, 4, 4, 0.0F, false));
//
//		LL8 = new RendererModel(this);
//		LL8.setRotationPoint(7.29F, -0.33F, 0.8F);
//		body_part8.addChild(LL8);
//
//		pt1_LL8 = new RendererModel(this);
//		pt1_LL8.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_LL8, 0.0F, 0.0F, -0.8727F);
//		LL8.addChild(pt1_LL8);
//		pt1_LL8.cubeList.add(new ModelBox(pt1_LL8, 0, 124, -2.0006F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_LL8 = new RendererModel(this);
//		pt2_LL8.setRotationPoint(12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_LL8, 0.0F, 0.0F, -0.1745F);
//		LL8.addChild(pt2_LL8);
//		pt2_LL8.cubeList.add(new ModelBox(pt2_LL8, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		RL8 = new RendererModel(this);
//		RL8.setRotationPoint(-7.29F, -0.33F, 0.8F);
//		body_part8.addChild(RL8);
//
//		pt1_RL8 = new RendererModel(this);
//		pt1_RL8.setRotationPoint(0.0F, 0.0F, 0.0F);
//		setRotationAngle(pt1_RL8, 0.0F, 0.0F, 0.8727F);
//		RL8.addChild(pt1_RL8);
//		pt1_RL8.cubeList.add(new ModelBox(pt1_RL8, 0, 124, -1.9994F, -0.0032F, -4.0F, 4, 18, 6, 0.0F, false));
//
//		pt2_RL8 = new RendererModel(this);
//		pt2_RL8.setRotationPoint(-12.5781F, 10.487F, 0.0F);
//		setRotationAngle(pt2_RL8, 0.0F, 0.0F, 0.1745F);
//		RL8.addChild(pt2_RL8);
//		pt2_RL8.cubeList.add(new ModelBox(pt2_RL8, 90, 60, -2.0F, 0.0F, -3.0F, 4, 16, 4, 0.0F, false));
//
//		all_except87654321 = new RendererModel(this);
//		all_except87654321.setRotationPoint(0.0F, 0.0F, 13.0F);
//		all_except7654321.addChild(all_except87654321);
//
//		tail = new RendererModel(this);
//		tail.setRotationPoint(0.0F, 0.0F, 0.0F);
//		all_except87654321.addChild(tail);
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
//		spikes = new RendererModel(this);
//		spikes.setRotationPoint(0.0F, 0.0F, -0.5F);
//		body.addChild(spikes);
//
//		head = new RendererModel(this);
//		head.setRotationPoint(0.0F, -33.0F, -46.0F);
//		main.addChild(head);
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
	}

	@Override
	public void render(KillerWiggler entity, float f, float f1, float f2, float f3, float f4, float f5) {
		main.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(KillerWiggler entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor)
	{
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
//		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
//		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

		RendererModel model = new KillerWigglerHead().getModel();
		main.childModels=new ArrayList<>();
		model.offsetX=(float)Math.cos(Math.toRadians(entityIn.rotationYaw-3.2f))*0;
		model.offsetZ=(float)Math.sin(Math.toRadians(entityIn.rotationYaw-3.2f))*0;
//		model.rotateAngleY=(float)Math.toRadians(45+17);
		main.addChild(model);
		int length=entityIn.length;
		try {
			for (int i=0;i<=length;i++) {
				RendererModel model2 = new KillerWigglerBody().getModel();
				if (i==length) {
					model2=new KillerWigglerTail().getModel();
				}
//			model2.offsetX=(float)Math.cos(Math.toRadians(entityIn.rotationYaw-15))*(0-(i*0.875f));
//			model2.offsetZ=(float)Math.sin(Math.toRadians(entityIn.rotationYaw-15))*(0-(i*0.875f));
				model2.offsetZ=(float)(entityIn.posX-entityIn.poses.get(i).x);
				model2.offsetY=(float)(entityIn.posY-entityIn.poses.get(i).y);
				model2.offsetX=(float)(entityIn.posZ-entityIn.poses.get(i).z);
				float x2=(float)Math.cos(Math.toRadians(entityIn.rotationYaw-15))*(0-((i-1)*0.875f));
				float z2=(float)Math.sin(Math.toRadians(entityIn.rotationYaw-15))*(0-((i-1)*0.875f));
				if (i==length) {
					model2.rotateAngleY=(float)Math.atan2(model2.offsetZ-z2,model2.offsetX-x2)+22.575f+91f+(float)Math.toRadians(5f);
					model2.offsetX=(float)Math.cos(Math.toRadians(entityIn.rotationYaw-15))*(1-(i*0.875f));
					model2.offsetZ=(float)Math.sin(Math.toRadians(entityIn.rotationYaw-15))*(1-(i*0.875f));
				} else {
					model2.rotateAngleY=(float)Math.atan2(model2.offsetZ-z2,model2.offsetX-x2)+22.575f;
				}
				main.addChild(model2);
			}
		} catch (Exception err) {}

		float limbSwingSpeed = 0.3F;
//		this.LL1.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL2.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL3.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL4.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL5.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL6.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL7.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//		this.LL8.rotateAngleY = (float) MathHelper.sin((float) limbSwing) * 0.5F;
//
//		this.RL1.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL2.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL3.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL4.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL5.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL6.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL7.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//		this.RL8.rotateAngleY = (float) MathHelper.cos((float) limbSwing) * 0.5F;
//
//		this.tail_left.rotateAngleX = (float) (MathHelper.sin((float) limbSwing) * 0.5F);
//		this.tail_right.rotateAngleX = (float) (MathHelper.cos((float) limbSwing) * 0.5F);
//
//		this.right_claws_top.rotateAngleY = (float) (MathHelper.cos((float) limbSwing) * 0.5F);
//		this.left_claws_bottom.rotateAngleY = (float) (MathHelper.cos((float) limbSwing) * 0.5F);
//		this.right_claws_bottom.rotateAngleY = (float) (MathHelper.sin((float) limbSwing) * 0.5F);
//		this.left_claws_top.rotateAngleY = (float) (MathHelper.sin((float) limbSwing) * 0.5F);

		float speedDivider = 4F;
		float slowness = 4F;
//		this.all_except1.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.1F / speedDivider;
//		this.all_except21.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.2F / speedDivider;
//		this.all_except321.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.3F / speedDivider;
//		this.all_except4321.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.4F / speedDivider;
//		this.all_except54321.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.6F / speedDivider;
//		this.all_except654321.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.6F / speedDivider;
//		this.all_except7654321.rotateAngleY = (float) MathHelper.cos((float) limbSwing / slowness) * 0.6F / speedDivider;

	}

}