package bernie.software.entity.ai.goal;

import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;

public class FishSwimGoal extends RandomSwimmingGoal
{
	private final AbstractFishEntity fish;

	public FishSwimGoal(AbstractFishEntity fish)
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
		return super.shouldExecute();
	}
}