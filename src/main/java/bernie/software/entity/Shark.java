package bernie.software.entity;

import bernie.software.entity.ai.goal.UnderwaterCreatureAttackGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Shark extends AbstractFishEntity
{
	private static final DataParameter<Boolean> IS_ATTACKING = EntityDataManager.createKey(Shark.class, DataSerializers.BOOLEAN);


	public Shark(EntityType<? extends AbstractFishEntity> type, World worldIn)
	{
		super(type, worldIn);
		this.moveController = new MoveHelperController(this);
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 *
	 * @param entitylivingbaseIn
	 */
	@Override
	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn)
	{
		super.setAttackTarget(entitylivingbaseIn);
		this.dataManager.set(IS_ATTACKING, entitylivingbaseIn != null);
	}

	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(IS_ATTACKING, false);
	}

	public boolean isAttacking()
	{
		return this.dataManager.get(IS_ATTACKING);
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return null;
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return null;
	}

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);

		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
	}

	@Override
	protected void registerGoals() {
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, PlayerEntity.class, true));
		this.goalSelector.addGoal(0, new UnderwaterCreatureAttackGoal(this, 3.0D, false));
		this.goalSelector.addGoal(4, new SwimGoal(this));

	}

	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		this.setHomePosAndDistance(new BlockPos(this), 50);
	}

	static class MoveHelperController extends MovementController
	{
		private final Shark shark;

		public MoveHelperController(Shark p_i48909_1_) {
			super(p_i48909_1_);
			this.shark = p_i48909_1_;
		}

		public void tick() {
			if (this.shark.isInWater()) {
				if (this.action != MovementController.Action.MOVE_TO || this.shark.getNavigator().noPath()) {
					this.shark.setAIMoveSpeed(0.0F);
					return;
				}

				double d0 = this.posX - this.shark.getPosX();
				double d1 = this.posY - this.shark.getPosY();
				double d2 = this.posZ - this.shark.getPosZ();
				double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
				d1 = d1 / d3;
				float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.shark.rotationYaw = this.limitAngle(this.shark.rotationYaw, f, 90.0F);
				this.shark.renderYawOffset = this.shark.rotationYaw;
				float f1 = (float)(this.speed * this.shark.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
				float f2 = MathHelper.lerp(0.125F, this.shark.getAIMoveSpeed(), f1);
				this.shark.setAIMoveSpeed(f2);
				this.shark.setMotion(this.shark.getMotion().add((double)f2 * d0 * 0.005D, (double)f2 * d1 * 0.1D, (double)f2 * d2 * 0.005D));
			} else {
				if (!this.shark.onGround) {
					this.shark.setMotion(this.shark.getMotion().add(0.0D, -0.008D, 0.0D));
				}

				super.tick();
			}

		}
	}
	static class SwimGoal extends RandomSwimmingGoal
	{
		private final AbstractFishEntity fish;

		public SwimGoal(AbstractFishEntity fish) {
			super(fish, 1.0D, 40);
			this.fish = fish;
		}

	}
}
