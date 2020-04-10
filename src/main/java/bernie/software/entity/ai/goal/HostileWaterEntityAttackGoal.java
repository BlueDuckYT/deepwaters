package bernie.software.entity.ai.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class HostileWaterEntityAttackGoal extends MeleeAttackGoal
{
	public HostileWaterEntityAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory)
	{
		super(creature, speedIn, useLongMemory);
	}

	@Override
	protected double getAttackReachSqr(LivingEntity attackTarget)
	{
		CreatureEntity creature = this.attacker;
		float width = creature.getWidth();

		return (double) (this.attacker.getWidth() * this.attacker.getWidth() + attackTarget.getWidth() - 20);

	}
}
