package bernie.software.entity;

import bernie.software.entity.ai.goal.FishSwimGoal;
import bernie.software.entity.ai.goal.HostileWaterEntityAttackGoal;
import bernie.software.entity.ai.goal.UnderwaterCreatureAttackGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class SkullFish extends AbstractFishEntity
{
	public UnderwaterCreatureAttackGoal attackGoal;

	public SkullFish(EntityType<? extends AbstractFishEntity> p_i50248_1_, World p_i50248_2_)
	{
		super(p_i50248_1_, p_i50248_2_);
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

	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
	}

	@Override
	protected void registerGoals()
	{
		attackGoal = new UnderwaterCreatureAttackGoal(this, .75D, false, 0);
		this.goalSelector.addGoal(1, attackGoal);
		this.goalSelector.addGoal(8, new FishSwimGoal(this));

		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ColorfulFish.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, BlufferFish.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, DonutFish.class, true));

	}

}