package bernie.software.entity.ai.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class UnderwaterCreatureAttackGoal extends MeleeAttackGoal
{
	protected final CreatureEntity attacker;
	protected final float ReachModifier;
	public UnderwaterCreatureAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory, float reachModifier)
	{
		super(creature, speedIn, useLongMemory);
		attacker = creature;
		ReachModifier = reachModifier;
	}

	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget)
	{
		CreatureEntity creature = this.attacker;
		float width = creature.getWidth();
		if (width < 1) {
			width = 1.5f;
		}
		return (double) (this.attacker.getWidth() * 2.0F * this.attacker.getWidth() * 2.0F + attackTarget.getWidth() + ReachModifier);
	}


}
