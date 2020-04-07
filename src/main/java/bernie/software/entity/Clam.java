package bernie.software.entity;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class Clam extends AbstractFishEntity
{
	public Clam(EntityType<? extends AbstractFishEntity> p_i50246_1_, World p_i50246_2_)
	{
		super(p_i50246_1_, p_i50246_2_);
	}

	@Override
	protected void registerGoals()
	{
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 16.0F));
	}

	@Override
	protected ItemStack getFishBucket()
	{
		return new ItemStack(Items.BUCKET);
	}

	@Override
	protected SoundEvent getFlopSound()
	{
		return SoundEvents.ENTITY_SALMON_FLOP;
	}

	@Override
	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn)
	{
		if (worldIn.getBlockState(pos.down()).getBlock() == DeepWatersBlocks.OCEAN_FLOOR.get()) {
			return 10.0F;
		} else {
			return -1.0F;
		}
	}
}
