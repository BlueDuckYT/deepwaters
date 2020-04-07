package bernie.software.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AbstractUnderwaterEntity extends WaterMobEntity
{
	public float squidPitch;
	public float prevSquidPitch;
	public float squidYaw;
	public float prevSquidYaw;
	public float squidRotation;
	public float prevSquidRotation;
	public float tentacleAngle;
	public float lastTentacleAngle;
	private float randomMotionSpeed;
	private float rotationVelocity;
	private float rotateSpeed;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;

	protected AbstractUnderwaterEntity(EntityType<? extends WaterMobEntity> type, World p_i48565_2_)
	{
		super(type, p_i48565_2_);
		this.rand.setSeed((long) this.getEntityId());

	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(0, new AbstractUnderwaterEntity.MoveRandomGoal(this));

	}


	public void travel(Vec3d p_213352_1_)
	{
		this.move(MoverType.SELF, this.getMotion());
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn)
	{
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	public boolean hasMovementVector()
	{
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	public void livingTick()
	{
		super.livingTick();
		this.prevSquidPitch = this.squidPitch;
		this.prevSquidYaw = this.squidYaw;
		this.squidRotation += this.rotationVelocity;
		if ((double) this.squidRotation > (Math.PI * 2D)) {
			if (this.world.isRemote) {
				this.squidRotation = ((float) Math.PI * 2F);
			} else {
				this.squidRotation = (float) ((double) this.squidRotation - (Math.PI * 2D));
				if (this.rand.nextInt(10) == 0) {
					this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
				}

				this.world.setEntityState(this, (byte) 19);
			}
		}

		if (this.isInWaterOrBubbleColumn()) {
			if (this.squidRotation < (float) Math.PI) {
				float f = this.squidRotation / (float) Math.PI;
				this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
				if ((double) f > 0.75D) {
					this.randomMotionSpeed = 1.0F;
					this.rotateSpeed = 1.0F;
				} else {
					this.rotateSpeed *= 0.8F;
				}
			} else {
				this.tentacleAngle = 0.0F;
				this.randomMotionSpeed *= 0.9F;
				this.rotateSpeed *= 0.99F;
			}

			if (!this.world.isRemote) {
				this.setMotion((double) (this.randomMotionVecX * this.randomMotionSpeed), (double) (this.randomMotionVecY * this.randomMotionSpeed), (double) (this.randomMotionVecZ * this.randomMotionSpeed));
			}

			Vec3d vec3d = this.getMotion();
			float f1 = MathHelper.sqrt(horizontalMag(vec3d));
			this.renderYawOffset += (-((float) MathHelper.atan2(vec3d.x, vec3d.z)) * (180F / (float) Math.PI) - this.renderYawOffset) * 0.1F;
			this.rotationYaw = this.renderYawOffset;
			this.squidYaw = (float) ((double) this.squidYaw + Math.PI * (double) this.rotateSpeed * 1.5D);
			this.squidPitch += (-((float) MathHelper.atan2((double) f1, vec3d.y)) * (180F / (float) Math.PI) - this.squidPitch) * 0.1F;
		} else {
			this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
			if (!this.world.isRemote) {
				double d0 = this.getMotion().y;
				if (this.isPotionActive(Effects.LEVITATION)) {
					d0 = 0.05D * (double) (this.getActivePotionEffect(Effects.LEVITATION).getAmplifier() + 1);
				} else if (!this.hasNoGravity()) {
					d0 -= 0.08D;
				}

				this.setMotion(0.0D, d0 * (double) 0.98F, 0.0D);
			}

			this.squidPitch = (float) ((double) this.squidPitch + (double) (-90.0F - this.squidPitch) * 0.02D);
		}

	}

	class MoveRandomGoal extends Goal
	{
		private final AbstractUnderwaterEntity fish;

		public MoveRandomGoal(AbstractUnderwaterEntity p_i48823_2_)
		{
			this.fish = p_i48823_2_;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute()
		{
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick()
		{
			int i = this.fish.getIdleTime();
			if (i < 100) {
				this.fish.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.fish.getRNG().nextInt(50) == 0 || !this.fish.inWater || !this.fish.hasMovementVector()) {
				float f = this.fish.getRNG().nextFloat() * ((float) Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.fish.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.fish.setMovementVector(f1, f2, f3);
			}

		}
	}
}


