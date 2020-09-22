package blueduck.deepwaters.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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
    public abstract float getSegmentDistance();
    public abstract float getYRenderOffset();
    public abstract AxisAlignedBB segmentBox();
    Vec3d moveVec=new Vec3d(0,0,0);
    float wiggle=0;
    int moveChance=16;
    int stopChance=128;
    boolean moving=false;
    @Override
    public void livingTick() {
        super.livingTick();
        if (this.getAttackTarget()==null&&this.isInWater()) {
            if (!extraAI()) {
                handleAI();
            }
        }
        handlePositions();
    }
    public abstract boolean extraAI();
    public void handleAI() {
        if (!moving) {
            if ((rand.nextDouble()*moveChance)<=1) {
                moveVec=(moveVec.add(new Vec3d(rand.nextFloat()-(rand.nextFloat()*2),(rand.nextFloat()-(rand.nextFloat()*2))/16,rand.nextFloat()-(rand.nextFloat()*2)).normalize()).normalize());
                moving=true;
            }
        } else {
            setMotion(moveVec.scale(0.05f));
            if ((rand.nextDouble()*stopChance)<=1) {
                moving=false;
                if (this.collided) {
                    moveVec=new Vec3d(0,0,0);
                    moving=false;
                }
            }
        }
        rotationPitch=0;
        prevRotationPitch=0;
        rotationYaw=0;
        prevRotationYaw=0;
        rotationYawHead=0;
        prevRotationYawHead=0;
        renderYawOffset=0;
        prevRenderYawOffset=0;
    }
    public void handlePositions() {
        HashMap<Integer,Vec3d> poses = this.getPoses();
        int length=this.getLength();
        if (!poses.containsKey(0)) {
            for (int i=0;i<=length;i++) {
                if (i==0) {
                    poses.put(i,this.getPositionVec().add(new Vec3d(0,0,0).subtract(this.getForward())));
                } else {
                    poses.put(i,poses.get(i-1).add(new Vec3d(0,0,0).subtract(this.getForward())));
                }
            }
        }
        poses.replace(0,new Vec3d(prevPosX-getPosX(),prevPosY-getPosY(),prevPosZ-getPosZ()).add(poses.get(0)));
        try {
            for (int i=0;i<=length;i++) {
                float posX=(float) this.getPosX();
                float posZ=(float) this.getPosZ();
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
                float x1=(float)poses.get(i).x;
                float y1=(float)poses.get(i).y;
                float z1=(float)poses.get(i).z;
                if (i>=2) {
                    if (segmentBox().offset(this.getPosX(),this.getPosY(),this.getPosZ()).intersects(segmentBox().offset(x1,y1,z1))) {
                        float x2=(float)poses.get(0).x;
                        float x3=(float)posX;
                        float z2=(float)poses.get(0).z;
                        float z3=(float)posZ;
                        rotation=(float)Math.atan2(x3-x2,z3-z2);
                        poses.replace(i,poses.get(i).add(-Math.cos(rotation)*0.1f,0,-Math.sin(rotation)*0.1f));
                    }
                }
                poses.replace(i,new Vec3d(posX+(Math.sin((rotation))*getSegmentDistance()),getPosY(),posZ+(Math.cos((rotation))*getSegmentDistance())));
            }
        } catch (Exception err) {
            poses.clear();
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
    protected RandomWalkingGoal wander;

    @Override
    protected void registerGoals() {
        //chance=1/value
//        this.wander = new RandomSwimGoal(this, 64, 256);
        this.wander = new RandomSwimmingGoal(this,0,1000000000);
    }
    public float getEntityRotationHead() {
        float x1a=-(float)this.poses.get(0).x;
        float x2a=-(float)this.getPosX();
        float z1a=-(float)this.poses.get(0).z;
        float z2a=-(float)this.getPosZ();
        return (float) (Math.atan2(x2a-x1a,z2a-z1a));
    }

    public class RandomSwimGoal extends RandomSwimmingGoal {
        public RandomSwimGoal(AbstractWormEntity entity,double speed,int chance) {
            super(entity,speed,chance);
        }
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute();
        }
        @Override
        public boolean shouldContinueExecuting() {
            return super.shouldContinueExecuting();
        }
        @Override
        public void startExecuting() {
            super.startExecuting();
            setRotation(0,0);
            setHeadRotation(0,0);
            setRenderYawOffset(0);
        }
    }
}
