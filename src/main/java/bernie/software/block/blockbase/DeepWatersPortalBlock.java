package bernie.software.block.blockbase;

import bernie.software.DeepWatersMod;
import bernie.software.utils.EntityUtils;
import bernie.software.utils.TeleportUtils;
import bernie.software.utils.WorldUtils;
import bernie.software.world.gen.structures.DeepWatersPortalStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class DeepWatersPortalBlock extends Block
{

	public DeepWatersPortalBlock(Material material, float hardness, float resist, SoundType sound)
	{
		super(Properties.create(material)
				.hardnessAndResistance(hardness, resist)
				.sound(sound)
				.doesNotBlockMovement()
				.noDrops()
		);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if (rand.nextInt(100) == 0)
		{
			worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,
					SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F,
					false);
		}
		double d0 = (float) pos.getX() + rand.nextFloat();
		double d1 = (float) pos.getY() + rand.nextFloat() + 1;
		double d2 = (float) pos.getZ() + rand.nextFloat();
		if (rand.nextInt(1) == 0)
		{
			worldIn.addParticle(ParticleTypes.BUBBLE_POP, d0, d1, d2, 0.0D, -0.04D, 0.0D);
		}
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
	{
		return ItemStack.EMPTY;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if (TeleportUtils.canEntityBeTeleported(state, worldIn, pos, entityIn))
		{
			MinecraftServer server = entityIn.getServer();
			DimensionType deepWatersDimension = WorldUtils.getDeepWatersDimension();
			DimensionType overworldDimension = DimensionType.OVERWORLD;
			ServerWorld overWorld = server.getWorld(
					overworldDimension);
			ServerWorld deepWatersWorld = server.getWorld(
					deepWatersDimension);

			BlockPos portalCenter = WorldUtils.findPortalCenter(worldIn, pos);
			if (portalCenter == null)
			{
				DeepWatersMod.logger.warn("Could not find portal center");
				return;
			}

			if (entityIn.getEntityWorld().getDimension().getType() != deepWatersDimension)
			{
				int deepWatersSeaLevel = deepWatersWorld.getSeaLevel();
				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
					WorldInfo worldInfo = deepWatersWorld.getWorldInfo();

					TeleportUtils.SendDimensionChangePackets(deepWatersDimension, player, worldInfo);
					int spawnHeight = WorldUtils.getDeepWatersSpawnHeight(deepWatersWorld, portalCenter);
					BlockPos portalCenterDeepWaters = new BlockPos(portalCenter.getX(),
							spawnHeight <= deepWatersSeaLevel ? deepWatersSeaLevel - 1 : spawnHeight,
							portalCenter.getZ());
					if (WorldUtils.findPortalCenter(deepWatersWorld, portalCenterDeepWaters.east(3).south(3)) == null)
					{
						DeepWatersPortalStructure.placePortalAtLocation(deepWatersWorld, deepWatersWorld.getRandom(),
								portalCenterDeepWaters, new NoFeatureConfig());
					}

					BlockPos spawnPos = portalCenterDeepWaters.east(4).up(3);
					TeleportUtils.TeleportPlayerToDimension(deepWatersWorld, player, spawnPos);
				}
				else
				{

					BlockPos spawnPos = new BlockPos(portalCenter.getX(),
							portalCenter.getY() <= deepWatersSeaLevel ? deepWatersSeaLevel - 1 : portalCenter.getY(),
							portalCenter.getZ()).east(4).up(3);
					TeleportUtils.TransferEntityToNewDimension(entityIn, deepWatersWorld, spawnPos);
					EntityUtils.RemoveEntity(worldIn, entityIn, deepWatersWorld, overWorld);
				}
			}
			else
			{
				BlockPos spawnPos = new BlockPos(portalCenter.getX(),
						overWorld.getSeaLevel(),
						portalCenter.getZ()).up(3).west(2).south(1);

				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
					WorldInfo worldInfo = overWorld.getWorldInfo();
					TeleportUtils.SendDimensionChangePackets(overworldDimension, player, worldInfo);
					TeleportUtils.TeleportPlayerToDimension(overWorld, player, spawnPos);
				}
				else
				{
					TeleportUtils.TransferEntityToNewDimension(entityIn, overWorld, spawnPos);
					EntityUtils.RemoveEntity(worldIn, entityIn, overWorld, deepWatersWorld);
				}
			}
		}

	}

}
