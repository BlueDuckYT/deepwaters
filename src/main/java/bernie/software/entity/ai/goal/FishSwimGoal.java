package bernie.software.entity.ai.goal;

import bernie.software.entity.SkullFish;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class FishSwimGoal extends RandomSwimmingGoal
{
	private final SkullFish fish;

	public FishSwimGoal(SkullFish fish)
	{
		super(fish, 1.0D, 40);
		this.fish = fish;
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean shouldExecute()
	{
		if (fish.attackGoal.attacker.isAggressive()) {
			return false;
		}
		return super.shouldExecute();
	}
}