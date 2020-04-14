package bernie.software.client.renderer.model;

import bernie.software.DeepWatersMod;
import bernie.software.entity.AbstractWormEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.HashMap;

public class wormModel extends EntityModel<AbstractWormEntity> {
    Class<? extends AbstractWormPart> mdl1;
    Class<? extends AbstractWormPart> mdl2;
    Class<? extends AbstractWormPart> mdl3;
    RendererModel main = new RendererModel(this);
    public wormModel(AbstractWormPart mdlH,AbstractWormPart mdlS,AbstractWormPart mdlT) {
        main.setRotationPoint(0,0,0);
        mdl1=mdlH.getClass();
        mdl2=mdlS.getClass();
        mdl3=mdlT.getClass();
    }

    @Override
    public void render(AbstractWormEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        main.render(scale);
    }

    @Override
    public void setRotationAngles(AbstractWormEntity entityIn, float p_212844_2_, float p_212844_3_, float p_212844_4_, float p_212844_5_, float p_212844_6_, float p_212844_7_) {
        super.setRotationAngles(entityIn, p_212844_2_, p_212844_3_, p_212844_4_, p_212844_5_, p_212844_6_, p_212844_7_);
        try {
            Object obj=entityIn.getClass().cast(entityIn);
//            RendererModel model = mdl1.getConstructor().newInstance().toModel().getModel();
            RendererModel model = mdl1.getConstructor().newInstance().getModel();
//            DeepWatersMod.log.log(Level.INFO,mdl1.getConstructor().newInstance());
            main.childModels=new ArrayList<>();
            main.setRotationPoint(0.0F, 0.0F, 0.0F);
            main.offsetY=0.4f;
            HashMap<Integer,Vec3d> poses=entityIn.getClass().cast(obj).getPoses();
            float x1a=-(float)poses.get(0).x;
            float x2a=-(float)entityIn.posX;
            float z1a=(float)poses.get(0).z;
            float z2a=(float)entityIn.posZ;
            model.rotateAngleY=(float)Math.atan2(x2a-x1a,z2a-z1a);
            model.offsetZ=-1;
            main.addChild(model);
            int length=entityIn.getClass().cast(obj).getLength();
            try {
                double distoff=0;
                for (int i=0;i<=length;i++) {
//                    DeepWatersMod.log.log(Level.INFO,poses.get(i));
                    RendererModel model2 = mdl2.getConstructor().newInstance().getModel();
                    if (i==length) {
                        model2=mdl3.getConstructor().newInstance().getModel();
                    }
                    Vec3d offset=(entityIn.getPositionVector().subtract(poses.get(i)));
                    if (i==0) {
                        distoff=offset.distanceTo(new Vec3d(0,0,0));
                    } else {
                        distoff=poses.get(i).distanceTo(poses.get(i-1));
                    }
                    model2.offsetX=-((float)offset.x-(0.2f*((float)offset.x*(float)distoff)));
                    model2.offsetZ=((float)offset.z-(0.2f*((float)offset.z*(float)distoff)));
                    if (i==0) {
                        float x1=-(float)poses.get(i).x;
                        float x2=-(float)entityIn.posX;
                        float z1=(float)poses.get(i).z;
                        float z2=(float)entityIn.posZ;
                        model2.rotateAngleY=(float)Math.atan2(x1-x2,z1-z2);
                    } else {
                        if (i==1) {
                            float x1=-(float)poses.get(i).x;
                            float x2=-(float)poses.get(i-1).x;
                            float z1=(float)poses.get(i).z;
                            float z2=(float)poses.get(i-1).z;
                            model2.rotateAngleY=(float)Math.atan2(x1-x2,z1-z2);
                        } else {
                            float x1=-(float)poses.get(i).x;
                            float x2=-(float)poses.get(i-1).x;
                            float x3=-(float)poses.get(i-2).x;
                            float z1=(float)poses.get(i).z;
                            float z2=(float)poses.get(i-1).z;
                            float z3=(float)poses.get(i-2).z;
                            model2.rotateAngleY=((float)Math.atan2(x1-x2,z1-z2)+(float)Math.atan2(x2-x3,z2-z3))/2f;
                            if (i==length) {
                                model2.rotateAngleY+=Math.toRadians(180f);
                                model2.offsetZ-=(float)Math.cos(model2.rotateAngleY)*1;
                                model2.offsetX-=(float)Math.sin(model2.rotateAngleY)*1;
                            }
                        }
                    }
                    main.addChild(model2);
                }
            } catch (Exception err) {}
        } catch (Exception err) {}
    }
}
