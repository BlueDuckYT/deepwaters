package bernie.software.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import bernie.software.DeepWatersMod;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Level;

public class KillerWiggler extends AbstractWormEntity
{
	private static final DataParameter<Boolean> MOVING = EntityDataManager.createKey(KillerWiggler.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(KillerWiggler.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> LENGTH = EntityDataManager.createKey(KillerWiggler.class, DataSerializers.VARINT);

	protected float clientSideTailAnimation;
	protected float clientSideTailAnimationO;
	protected float clientSideTailAnimationSpeed;
	protected float clientSideSpikesAnimation;
	protected float clientSideSpikesAnimationO;
	private LivingEntity targetedEntity;
	private int clientSideAttackTime;
	private boolean clientSideTouchedGround;

	@Override
	public boolean extraAI() {
//		try {
//			int segmentTarget=5;
//			Vec3d move=this.getPositionVector().subtract(getPoses().get(segmentTarget));
//			this.setMotion(move.normalize().scale(-0.1f));
//		} catch (Exception err) {}
		return false;
	}

	@Override
	public AxisAlignedBB segmentBox() {
		return new AxisAlignedBB(-0.5,-0.5,-0.5,1,1,1);
	}

	public KillerWiggler(EntityType<? extends KillerWiggler> p_i48554_1_, World p_i48554_2_)
	{
		super(p_i48554_1_, p_i48554_2_);
		this.setBoundingBox(new AxisAlignedBB(getPosX() - 1.5625, getPosY(), getPosZ() - 5.3437, getPosX() + 1.5625, getPosY() + 2.4375, getPosZ() + 5.3437));
		AxisAlignedBB box = this.getBoundingBox();
		this.experienceValue = 10;
		this.moveController = new KillerWiggler.MoveHelperController(this);
		this.clientSideTailAnimation = this.rand.nextFloat();
		this.clientSideTailAnimationO = this.clientSideTailAnimation;
	}


	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return new AxisAlignedBB(getPosX() - 1.5625, getPosY(), getPosZ() - 5.3437, getPosX() + 1.5625, getPosY() + 2.4375, getPosZ() + 5.3437);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return super.getBoundingBox();
	}

	protected void registerGoals()
	{
		super.registerGoals();
		MoveTowardsRestrictionGoal movetowardsrestrictiongoal = new MoveTowardsRestrictionGoal(this, 1.0D);
		//this.goalSelector.addGoal(4, new HostileWaterEntityAttackGoal(this, 5, true));
		this.goalSelector.addGoal(5, movetowardsrestrictiongoal);
		this.goalSelector.addGoal(7, this.wander);
//		this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
		this.wander.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		movetowardsrestrictiongoal.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(1, new attackGoal(this, 2.0D, false));
	}

	public class attackGoal extends MeleeAttackGoal {
		public attackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory) {
			super(creature, speedIn, useLongMemory);
		}

		@Override
		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return super.getAttackReachSqr(attackTarget)/10;
		}
	}

	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(3D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
	}

	/**
	 * Returns new PathNavigateGround instance
	 */
	protected PathNavigator createNavigator(World worldIn)
	{
		return new SwimmerPathNavigator(this, worldIn);
	}

	@Override
	public float getSegmentDistance() {
		return 1;
	}

	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(MOVING, false);
		this.dataManager.register(TARGET_ENTITY, 0);
		this.dataManager.register(LENGTH, 10);
		this.dataManager.set(LENGTH, 10);
	}

	@Override
	public float getYRenderOffset() {
		return 0.4f;
	}

	public boolean canBreatheUnderwater()
	{
		return true;
	}

	public CreatureAttribute getCreatureAttribute()
	{
		return CreatureAttribute.WATER;
	}

	public boolean isMoving()
	{
		return this.dataManager.get(MOVING);
	}

	private void setMoving(boolean moving)
	{
		this.dataManager.set(MOVING, moving);
	}

	public int getEntityLength()
	{
		Integer length = this.dataManager.get(LENGTH);
//		DeepWatersMod.log.log(Level.INFO, length.toString());
		return length;
	}

	public void setLength(int length)
	{
		this.dataManager.set(LENGTH, length);
	}

	public int getAttackDuration()
	{
		return 80;
	}

	private void setTargetedEntity(int entityId)
	{
		this.dataManager.set(TARGET_ENTITY, entityId);
	}

	public boolean hasTargetedEntity()
	{
		return this.dataManager.get(TARGET_ENTITY) != 0;
	}

	@Nullable
	public LivingEntity getTargetedEntity()
	{
		if (!this.hasTargetedEntity())
		{
			return null;
		}
		else if (this.world.isRemote)
		{
			if (this.targetedEntity != null)
			{
				return this.targetedEntity;
			}
			else
			{
				Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
				if (entity instanceof LivingEntity)
				{
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				}
				else
				{
					return null;
				}
			}
		}
		else
		{
			return this.getAttackTarget();
		}
	}

	public void notifyDataManagerChange(DataParameter<?> key)
	{
		super.notifyDataManagerChange(key);
		if (TARGET_ENTITY.equals(key))
		{
			this.clientSideAttackTime = 0;
			this.targetedEntity = null;
		}

	}

	/**
	 * Get number of ticks, at least during which the living entity will be silent.
	 */
	public int getTalkInterval()
	{
		return 160;
	}

	protected SoundEvent getAmbientSound()
	{
		return this.isInWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_AMBIENT : SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return this.isInWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_HURT : SoundEvents.ENTITY_GUARDIAN_HURT_LAND;
	}

	protected SoundEvent getDeathSound()
	{
		return this.isInWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_DEATH : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking()
	{
		return false;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn)
	{
		return sizeIn.height * 0.5F;
	}

	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn)
	{
		return worldIn.getFluidState(pos).isTagged(FluidTags.WATER) ? 10.0F + worldIn.getBrightness(pos) - 0.5F : super.getBlockPathWeight(pos, worldIn);
	}


	@Override
	public void writeAdditional(CompoundNBT p_213281_1_)
	{
		super.writeAdditional(p_213281_1_);
		p_213281_1_.putInt("length", getLength());
	}

	@Override
	public void readAdditional(CompoundNBT p_70037_1_)
	{
		super.readAdditional(p_70037_1_);
		setLength(p_70037_1_.getInt("length"));
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt)
	{
		readAdditional(nbt);
	}

	@Override
	public CompoundNBT serializeNBT()
	{
		CompoundNBT nbt = new CompoundNBT();
		writeAdditional(nbt);
		return nbt;
	}

	@Override
	public int getLength()
	{
		return getEntityLength();
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void livingTick()
	{
		if (getEntityLength()<=0) {
			setLength(10);
		}
		if (this.isAlive())
		{
			if (this.world.isRemote)
			{
				this.clientSideTailAnimationO = this.clientSideTailAnimation;
				this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
				AxisAlignedBB box = this.getBoundingBox();

				if (!this.isInWater())
				{
					this.clientSideTailAnimationSpeed = 2.0F;
					Vec3d vec3d = this.getMotion();
					if (vec3d.y > 0.0D && this.clientSideTouchedGround && !this.isSilent())
					{
						this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), this.getFlopSound(), this.getSoundCategory(), 1.0F, 1.0F, false);
					}
					this.clientSideTouchedGround = vec3d.y < 0.0D && this.world.isTopSolid((new BlockPos(this)).down(), this);
				}
				else if (this.isMoving())
				{
					if (this.clientSideTailAnimationSpeed < 0.5F)
					{
						this.clientSideTailAnimationSpeed = 4.0F;
					}
					else
					{
						this.clientSideTailAnimationSpeed += (0.5F - this.clientSideTailAnimationSpeed) * 0.1F;
					}
				}
				else
				{
					this.clientSideTailAnimationSpeed += (0.125F - this.clientSideTailAnimationSpeed) * 0.2F;
				}

				this.clientSideTailAnimation += this.clientSideTailAnimationSpeed;
				this.clientSideSpikesAnimationO = this.clientSideSpikesAnimation;
				if (!this.isInWaterOrBubbleColumn())
				{
					this.clientSideSpikesAnimation = this.rand.nextFloat();
				}
				else if (this.isMoving())
				{
					this.clientSideSpikesAnimation += (0.0F - this.clientSideSpikesAnimation) * 0.25F;
				}
				else
				{
					this.clientSideSpikesAnimation += (1.0F - this.clientSideSpikesAnimation) * 0.06F;
				}

				if (this.isMoving() && this.isInWater())
				{
					Vec3d vec3d1 = this.getLook(0.0F);

					for (int i = 0; i < 2; ++i)
					{
						this.world.addParticle(ParticleTypes.BUBBLE, this.getPosX() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth() - vec3d1.x * 1.5D, this.getPosY() + this.rand.nextDouble() * (double) this.getHeight() - vec3d1.y * 1.5D, this.getPosZ() + (this.rand.nextDouble() - 0.5D) * (double) this.getWidth() - vec3d1.z * 1.5D, 0.0D, 0.0D, 0.0D);
					}
				}

				if (this.hasTargetedEntity())
				{
					if (this.clientSideAttackTime < this.getAttackDuration())
					{
						++this.clientSideAttackTime;
					}

					LivingEntity livingentity = this.getTargetedEntity();
					if (livingentity != null)
					{
						this.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
						this.getLookController().tick();
						double d5 = (double) this.getAttackAnimationScale(0.0F);
						double d0 = livingentity.getPosX() - this.getPosX();
						double d1 = livingentity.getPosY() + (double) (livingentity.getHeight() * 0.5F) - (this.getPosY() + (double) this.getEyeHeight());
						double d2 = livingentity.getPosZ() - this.getPosZ();
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						double d4 = this.rand.nextDouble();

						while (d4 < d3)
						{
							d4 += 1.8D - d5 + this.rand.nextDouble() * (1.7D - d5);
							//this.world.addParticle(ParticleTypes.BUBBLE, this.posX + d0 * d4, this.posY + d1 * d4 + (double)this.getEyeHeight(), this.posZ + d2 * d4, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			}

			if (this.isInWaterOrBubbleColumn())
			{
				this.setAir(300);
			}
			else if (this.onGround)
			{
				this.setMotion(this.getMotion().add((double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D, (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F)));
				this.rotationYaw = this.rand.nextFloat() * 360.0F;
				this.onGround = false;
				this.isAirBorne = true;
			}

			if (this.hasTargetedEntity())
			{
				this.rotationYaw = this.rotationYawHead;
//				this.spinAttack(this.getTargetedEntity());
			}
		}

		super.livingTick();
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		DeepWatersMod.logger.log(Level.INFO,target.getPositionVector().distanceTo(this.getPositionVec()));
		return target.getPositionVector().distanceTo(this.getPositionVec())<=5;
	}

	protected SoundEvent getFlopSound()
	{
		return SoundEvents.ENTITY_GUARDIAN_FLOP;
	}

	@OnlyIn(Dist.CLIENT)
	public float getTailAnimation(float p_175471_1_)
	{
		return MathHelper.lerp(p_175471_1_, this.clientSideTailAnimationO, this.clientSideTailAnimation);
	}

	@OnlyIn(Dist.CLIENT)
	public float getSpikesAnimation(float p_175469_1_)
	{
		return MathHelper.lerp(p_175469_1_, this.clientSideSpikesAnimationO, this.clientSideSpikesAnimation);
	}

	public float getAttackAnimationScale(float p_175477_1_)
	{
		return ((float) this.clientSideAttackTime + p_175477_1_) / (float) this.getAttackDuration();
	}

	public boolean isNotColliding(IWorldReader worldIn)
	{
		return worldIn.checkNoEntityCollision(this);
	}

	public static boolean func_223329_b(EntityType<? extends KillerWiggler> p_223329_0_, IWorld p_223329_1_, SpawnReason p_223329_2_, BlockPos p_223329_3_, Random p_223329_4_)
	{
		return (p_223329_4_.nextInt(20) == 0 || !p_223329_1_.canBlockSeeSky(p_223329_3_)) && p_223329_1_.getDifficulty() != Difficulty.PEACEFUL && (p_223329_2_ == SpawnReason.SPAWNER || p_223329_1_.getFluidState(p_223329_3_).isTagged(FluidTags.WATER));
	}


	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (!this.isMoving() && !source.isMagicDamage() && source.getImmediateSource() instanceof LivingEntity)
		{
			LivingEntity livingentity = (LivingEntity) source.getImmediateSource();
			if (!source.isExplosion())
			{
				livingentity.attackEntityFrom(DamageSource.causeThornsDamage(this), 2.0F);
			}
		}

		if (this.wander != null)
		{
			this.wander.makeUpdate();
		}

		return super.attackEntityFrom(source, amount);
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
	 * use in wolves.
	 */
	public int getVerticalFaceSpeed()
	{
		return 180;
	}

	public void travel(Vec3d p_213352_1_)
	{
		if (this.isServerWorld() && this.isInWater())
		{
			this.moveRelative(0.1F, p_213352_1_);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale(0.9D));
			if (!this.isMoving() && this.getAttackTarget() == null)
			{
				this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
			}
		}
		else
		{
			super.travel(p_213352_1_);
		}

	}


	static class MoveHelperController extends MovementController
	{
		private final KillerWiggler entityGuardian;

		public MoveHelperController(KillerWiggler guardian)
		{
			super(guardian);
			this.entityGuardian = guardian;
		}

		public void tick()
		{
			if (this.action == MovementController.Action.MOVE_TO && !this.entityGuardian.getNavigator().noPath())
			{
				Vec3d vec3d = new Vec3d(this.posX - this.entityGuardian.getPosX(), this.posY - this.entityGuardian.getPosY(), this.posZ - this.entityGuardian.getPosZ());
				double d0 = vec3d.length();
				double d1 = vec3d.x / d0;
				double d2 = vec3d.y / d0;
				double d3 = vec3d.z / d0;
				float f = (float) (MathHelper.atan2(vec3d.z, vec3d.x) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.entityGuardian.rotationYaw = this.limitAngle(this.entityGuardian.rotationYaw, f, 90.0F);
				this.entityGuardian.renderYawOffset = this.entityGuardian.rotationYaw;
				float f1 = (float) (this.speed * this.entityGuardian.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				float f2 = MathHelper.lerp(0.125F, this.entityGuardian.getAIMoveSpeed(), f1);
				this.entityGuardian.setAIMoveSpeed(f2);
				double d4 = Math.sin((double) (this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.5D) * 0.05D;
				double d5 = Math.cos((double) (this.entityGuardian.rotationYaw * ((float) Math.PI / 180F)));
				double d6 = Math.sin((double) (this.entityGuardian.rotationYaw * ((float) Math.PI / 180F)));
				double d7 = Math.sin((double) (this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.75D) * 0.05D;
				this.entityGuardian.setMotion(this.entityGuardian.getMotion().add(d4 * d5, d7 * (d6 + d5) * 0.25D + (double) f2 * d2 * 0.1D, d4 * d6));
				LookController lookcontroller = this.entityGuardian.getLookController();
				double d8 = this.entityGuardian.getPosX() + d1 * 2.0D;
				double d9 = (double) this.entityGuardian.getEyeHeight() + this.entityGuardian.getPosY() + d2 / d0;
				double d10 = this.entityGuardian.getPosZ() + d3 * 2.0D;
				double d11 = lookcontroller.getLookPosX();
				double d12 = lookcontroller.getLookPosY();
				double d13 = lookcontroller.getLookPosZ();
				if (!lookcontroller.getIsLooking())
				{
					d11 = d8;
					d12 = d9;
					d13 = d10;
				}

				this.entityGuardian.getLookController().setLookPosition(MathHelper.lerp(0.125D, d11, d8), MathHelper.lerp(0.125D, d12, d9), MathHelper.lerp(0.125D, d13, d10), 10.0F, 40.0F);
				this.entityGuardian.setMoving(true);
			}
			else
			{
				this.entityGuardian.setAIMoveSpeed(0.0F);
				this.entityGuardian.setMoving(false);
			}
		}
	}

	static class TargetPredicate implements Predicate<LivingEntity>
	{
		private final KillerWiggler parentEntity;

		public TargetPredicate(KillerWiggler guardian)
		{
			this.parentEntity = guardian;
		}

		public boolean test(@Nullable LivingEntity p_test_1_)
		{
			return (p_test_1_ instanceof PlayerEntity || p_test_1_ instanceof SquidEntity) && p_test_1_.getDistanceSq(this.parentEntity) > 9.0D;
		}
	}
}