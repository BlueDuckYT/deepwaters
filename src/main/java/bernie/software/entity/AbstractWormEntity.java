package bernie.software.entity;

import bernie.software.DeepWatersMod;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;

import java.util.HashMap;

public abstract class AbstractWormEntity extends CreatureEntity {
    public AbstractWormEntity(EntityType<? extends CreatureEntity> p_i48575_1_, World p_i48575_2_) {
        super(p_i48575_1_, p_i48575_2_);
    }
    private HashMap<Integer,Vec3d> poses=new HashMap<>();
    public void setPoses(HashMap<Integer,Vec3d> poses) {
        this.poses=poses;
    }
    public HashMap<Integer,Vec3d> getPoses() {
        return poses;
    }
    public abstract int getLength();
    @Override
    public void livingTick() {
        handlePositions();
        super.livingTick();
    }
    public void handlePositions() {
        HashMap<Integer,Vec3d> poses = this.getPoses();
        int length=this.getLength();
        if (!poses.containsKey(0)) {
            for (int i=0;i<=length;i++) {
                poses.put(i,this.getPositionVec());
            }
        }
        for (int i=0;i<=length;i++) {
            float posX=(float) this.posX;
            float posZ=(float) this.posZ;
            float rotation=0;
            if (i>=1) {
                float x1=(float)poses.get(i).x;
                float x2=(float)poses.get(i-1).x;
                float z1=(float)poses.get(i).z;
                float z2=(float)poses.get(i-1).z;
                rotation=(float)Math.atan2(x1-x2,z1-z2);
                posX=(float)poses.get(i-1).x;
                posZ=(float)poses.get(i-1).z;
            } else {
                float x1=(float)poses.get(i).x;
                float x2=(float)posX;
                float z1=(float)poses.get(i).z;
                float z2=(float)posZ;
                rotation=(float)Math.atan2(x1-x2,z1-z2);
            }
            poses.replace(i,new Vec3d(posX+(Math.sin((rotation))*0.875f),posY,posZ+(Math.cos((rotation))*0.875f)));
        }
//        if (poses.get(0).distanceTo(this.getPositionVec())>=(0.875f)) {
//            DeepWatersMod.log.log(Level.INFO,"h");
//            for (int i=length;i>=1;i--) {
//                if (!poses.containsKey(i)) {
//                    poses.put(i,this.getPositionVector());
//                    DeepWatersMod.log.log(Level.INFO,"h2");
//                } else if (i>=1) {
//                    if ((poses.get(i).distanceTo(poses.get(i-1))>=0.875f)) {
//                        poses.replace(i,poses.get(i-1));
//                        DeepWatersMod.log.log(Level.INFO,"h3");
//                    }
//                }
//            }
//            poses.replace(0,this.getPositionVec());
//        }
        this.setPoses((HashMap<Integer, Vec3d>) poses.clone());
    }
}
