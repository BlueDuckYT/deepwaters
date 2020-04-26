package bernie.software.client.renderer.model;

import bernie.software.DeepWatersMod;
import bernie.software.entity.AbstractWormEntity;
import bernie.software.utils.render.RenderHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

public class WormModel extends EntityModel<AbstractWormEntity>
{
	Class<? extends AbstractWormPart> mdl1;
	Class<? extends AbstractWormPart> mdl2;
	Class<? extends AbstractWormPart> mdl3;
	Class<? extends AbstractWormEntity> type;
	AbstractWormEntity EntityRendering;
	boolean wigglerCorrection;
	ModelRenderer main = new ModelRenderer(this);

	public WormModel(AbstractWormPart mdlH, AbstractWormPart mdlS, AbstractWormPart mdlT, Class<? extends AbstractWormEntity> type, boolean wigglecorrect)
	{
		main.setRotationPoint(0, 0, 0);
		main.addBox(0, 0, 0,10,10,10,0);
		mdl1 = mdlH.getClass();
		mdl2 = mdlS.getClass();
		mdl3 = mdlT.getClass();
		this.type = type;
		wigglerCorrection = wigglecorrect;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha)
	{
//		main = new ModelRenderer(this);
//		main.setRotationPoint(0, 0, 0);
//		main.addBox(0, 0, 0,10,10,10,0);
//		try {
//			GlStateManager.pushMatrix();
//			try {
//				GlStateManager.translatef(0, type.newInstance().getYRenderOffset(), 0);
//			} catch (Exception err) {}
//			main.render(matrixStackIn,bufferIn,packedLightIn,packedOverlayIn,red,blue,green,alpha);
//			GlStateManager.popMatrix();
//		} catch (Exception err) {}
		GlStateManager.pushMatrix();
		try
		{
			try {
				GlStateManager.translatef(0, type.newInstance().getYRenderOffset(), 0);
			} catch (Exception err) {}
			float offsetX = 0;
			float offsetY = 0;
			float offsetZ = 0;
			try
			{
				Object obj = EntityRendering.getClass().cast(EntityRendering);
				AbstractWormPart modelW = mdl1.getConstructor().newInstance();
				AbstractWormPart model = modelW;
				main = new ModelRenderer(this);
				main.setRotationPoint(0.0F, 0.0F, 0.0F);
				HashMap<Integer, Vec3d> poses = EntityRendering.getClass().cast(obj).getPoses();
				float x1a = -(float) poses.get(0).x;
				float x2a = -(float) EntityRendering.getPosX();
				float z1a = (float) poses.get(0).z;
				float z2a = (float) EntityRendering.getPosZ();
				model.getModel().rotateAngleY = (float) Math.atan2(x2a - x1a, z2a - z1a);
				if (wigglerCorrection)
				{
					offsetZ = -1;
				}
				matrixStackIn.push();
				matrixStackIn.translate(offsetX,offsetY,offsetZ);
				model.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
				matrixStackIn.translate(-offsetX,-offsetY,-offsetZ);
				matrixStackIn.pop();
				int length = EntityRendering.getClass().cast(obj).getLength();
				try
				{
					double distoff = 0;
					for (int i = 0; i <= length; i++)
					{
						offsetX = 0;
						offsetY = 0;
						offsetZ = 0;
						AbstractWormPart modelW2 = mdl2.getConstructor().newInstance();
						ModelRenderer model2 = modelW2.getModel();
						if (i == length)
						{
							model2 = mdl3.getConstructor().newInstance().getModel();
						}
						Vec3d offset = (EntityRendering.getPositionVector().subtract(poses.get(i)));
						if (i == 0)
						{
							distoff = offset.distanceTo(new Vec3d(0, 0, 0));
						}
						else
						{
							distoff = poses.get(i).distanceTo(poses.get(i - 1));
						}
						offsetX = -((float) offset.x - (0.2f * ((float) offset.x * (float) distoff)));
						offsetZ = ((float) offset.z - (0.2f * ((float) offset.z * (float) distoff)));
						if (i == 0)
						{
							float x1 = -(float) poses.get(i).x;
							float x2 = -(float) EntityRendering.getPosX();
							float z1 = (float) poses.get(i).z;
							float z2 = (float) EntityRendering.getPosZ();
							model2.rotateAngleY = (float) Math.atan2(x1 - x2, z1 - z2);
						}
						else
						{
							if (i == 1)
							{
								float x1 = -(float) poses.get(i).x;
								float x2 = -(float) poses.get(i - 1).x;
								float z1 = (float) poses.get(i).z;
								float z2 = (float) poses.get(i - 1).z;
								model2.rotateAngleY = (float) Math.atan2(x1 - x2, z1 - z2);
							}
							else
							{
								float x1 = -(float) poses.get(i).x;
								float x2 = -(float) poses.get(i - 1).x;
//                            float x3=-(float)poses.get(i-2).x;
								float z1 = (float) poses.get(i).z;
								float z2 = (float) poses.get(i - 1).z;
//                            float z3=(float)poses.get(i-2).z;
								model2.rotateAngleY = ((float) Math.atan2(x1 - x2, z1 - z2)) / 1f;
								if (i == length && wigglerCorrection)
								{
									model2.rotateAngleY += Math.toRadians(180f);
									offsetZ -= (float) Math.cos(model2.rotateAngleY) * 1;
									offsetX -= (float) Math.sin(model2.rotateAngleY) * 1;
								}
							}
						}
						matrixStackIn.push();
						matrixStackIn.translate(offsetX,offsetY,offsetZ);
						model2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
						matrixStackIn.translate(-offsetX,-offsetY,-offsetZ);
						matrixStackIn.pop();
					}
				}
				catch (Exception err)
				{
				}
			}
			catch (Exception err)
			{
			}
		}
		catch (Exception err)
		{
		}
		GlStateManager.popMatrix();
	}

	@Override
	public void setRotationAngles(AbstractWormEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		EntityRendering = entityIn;
	}
}
