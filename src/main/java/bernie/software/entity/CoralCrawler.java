package bernie.software.entity;

import bernie.software.tag.DeepWatersTags;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class CoralCrawler extends AgeableEntity
{
	public CoralCrawler(EntityType<? extends AgeableEntity> type, World worldIn)
	{
		super(type, worldIn);
	}

	@Nullable
	@Override
	public AgeableEntity createChild(AgeableEntity ageable)
	{
		return null;
	}

	@Override
	protected void registerGoals()
	{
		goalSelector.addGoal(0, new SwimGoal(this));
		goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
		goalSelector.addGoal(3,
				new TemptGoal(this, 1.25D, Ingredient.fromTag(DeepWatersTags.getItemTag("coral_itemblocks")), false));
		goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
	}


	public static <T extends MobEntity> boolean canCoralCrawlerSpawn(EntityType<T> type, IWorld world, SpawnReason spawnReason, BlockPos blockPos, Random random)
	{
		return blockPos.getY() > world.getSeaLevel() && world.getBlockState(blockPos.down()).isSolid();
	}
}
