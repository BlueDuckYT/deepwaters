package bernie.software.entity;

import bernie.software.entity.ai.goal.FishSwimGoal;
import bernie.software.entity.ai.goal.UnderwaterCreatureAttackGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DeepGlider extends AbstractFishEntity
{

	public UnderwaterCreatureAttackGoal attackGoal;

	public DeepGlider(EntityType<? extends AbstractFishEntity> p_i50248_1_, World p_i50248_2_)
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

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(36.0D);
		if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);

	}





	//Add Attack Goals and have it kill players and feeder fish

}