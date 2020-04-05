package bernie.software.entity;

import bernie.software.registry.DeepWatersBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
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
	public void travel(Vec3d p_213352_1_)
	{

	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn)
	{
		if(world.getBlockState(new BlockPos(this).down()).getBlock() == DeepWatersBlocks.OCEAN_FLOOR.get())
		{
			return true;
		}
		return false;
	}
}
