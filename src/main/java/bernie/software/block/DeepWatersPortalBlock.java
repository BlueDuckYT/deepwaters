package bernie.software.block;

import bernie.software.DeepWatersMod;
import bernie.software.ForgeBusEventSubscriber;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.utils.TeleportUtils;
import bernie.software.world.gen.structures.DeepWatersPortalStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.network.play.server.SRespawnPacket;
import net.minecraft.network.play.server.SServerDifficultyPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.ToolType;

public class DeepWatersPortalBlock extends Block
{

	public DeepWatersPortalBlock(Material material, float hardness, float resist, SoundType sound)
	{
		super(Properties.create(material)
				.hardnessAndResistance(hardness, resist)
				.sound(sound)
				.doesNotBlockMovement()
		);
	}

	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
	{
		return ItemStack.EMPTY;
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		if (!worldIn.isRemote && !entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && VoxelShapes.compare(
				VoxelShapes.create(entityIn.getBoundingBox().offset((double) (-pos.getX()), (double) (-pos.getY()),
						(double) (-pos.getZ()))), state.getShape(worldIn, pos), IBooleanFunction.AND))
		{
			DimensionType dimension = DimensionType.byName(ForgeBusEventSubscriber.DIMENSION_TYPE_RL);
			DimensionType deepWatersDimensionType = dimension;
			ServerWorld overworld = entityIn.getServer().getWorld(
					DimensionType.OVERWORLD);
			if (!entityIn.getEntityWorld().getDimension().getType().equals(
					deepWatersDimensionType))
			{
				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;

					BlockPos.PooledMutableBlockPos decimalPosition = (BlockPos.PooledMutableBlockPos) pos;
					BlockPos center = findPortalCenter(worldIn, decimalPosition);
					if (center == null)
					{
						DeepWatersMod.logger.warn("Could not find portal center");
						return;
					}

					ServerWorld nextWorld = player.getServer().getWorld(
							dimension);
					player.connection.sendPacket(new SChangeGameStatePacket(4, 0.0F));
					WorldInfo worldInfo = nextWorld.getWorldInfo();
					player.connection.sendPacket(new SRespawnPacket(dimension, worldInfo.getGenerator(),
							player.interactionManager.getGameType()));
					player.connection.sendPacket(
							new SServerDifficultyPacket(worldInfo.getDifficulty(), worldInfo.isDifficultyLocked()));
					int spawnHeight = nextWorld.getHeight(Heightmap.Type.WORLD_SURFACE, center).getY() + 1;
					DeepWatersPortalStructure.placePortalAtLocation(nextWorld,
							nextWorld.getChunkProvider().getChunkGenerator(), nextWorld.getRandom(),
							new BlockPos(center.getX(),
									spawnHeight <= nextWorld.getSeaLevel() ? nextWorld.getSeaLevel() - 1 : spawnHeight,
									center.getZ()), new NoFeatureConfig());
					BlockPos spawnPos = new BlockPos(center.getX(),
							center.getY() <= nextWorld.getSeaLevel() ? nextWorld.getSeaLevel() - 1 : center.getY(),
							center.getZ()).east(4).up(3);
					nextWorld.getChunk(spawnPos);    // make sure the chunk is loaded
					player.teleport(nextWorld, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(),
							player.rotationYaw, player.rotationPitch);
				}
				else
				{
					BlockPos center = findPortalCenter(worldIn, pos);
					if (center == null)
					{
						DeepWatersMod.logger.warn("Could not find portal center");
						return;
					}
					ServerWorld nextWorld = entityIn.getServer().getWorld(deepWatersDimensionType);
					Entity entity2 = entityIn.getType().create(nextWorld);
					BlockPos spawnPos = new BlockPos(center.getX(),
							center.getY() <= nextWorld.getSeaLevel() ? nextWorld.getSeaLevel() - 1 : center.getY(),
							center.getZ()).east(4).up(3);
					if (entity2 != null)
					{
						entity2.copyDataFromOld(entityIn);
						entity2.moveToBlockPosAndAngles(spawnPos, entityIn.rotationYaw, entityIn.rotationPitch);
						entity2.setMotion(entityIn.getMotion());
						nextWorld.func_217460_e(entity2);
					}
					entityIn.remove(false);
					worldIn.getProfiler().endSection();
					overworld.resetUpdateEntityTick();
					nextWorld.resetUpdateEntityTick();
					worldIn.getProfiler().endSection();
				}
			}
			else
			{
				if (entityIn instanceof ServerPlayerEntity)
				{
					ServerPlayerEntity player = (ServerPlayerEntity) entityIn;
					BlockPos center = findPortalCenter(worldIn, pos);
					if (center == null)
					{
						DeepWatersMod.logger.warn("Could not find portal center");
						return;
					}

					ServerWorld nextWorld = player.getServer().getWorld(DimensionType.OVERWORLD);
					player.connection.sendPacket(new SChangeGameStatePacket(4, 0.0F));
					WorldInfo worldInfo = nextWorld.getWorldInfo();
					player.connection.sendPacket(new SRespawnPacket(DimensionType.OVERWORLD, worldInfo.getGenerator(),
							player.interactionManager.getGameType()));
					player.connection.sendPacket(
							new SServerDifficultyPacket(worldInfo.getDifficulty(), worldInfo.isDifficultyLocked()));
					BlockPos spawnPos = new BlockPos(center.getX(),
							nextWorld.getSeaLevel(),
							center.getZ()).up(3).west(2).south(1);
					nextWorld.getChunk(spawnPos);    // make sure the chunk is loaded
					player.teleport(nextWorld, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(),
							player.rotationYaw, player.rotationPitch);
					//TeleportUtils.performTeleport(player, deepWatersDimensionType, center, null);
				}
				else
				{
					BlockPos center = findPortalCenter(worldIn, pos);
					if (center == null)
					{
						DeepWatersMod.logger.warn("Could not find portal center");
						return;
					}
					ServerWorld nextWorld = entityIn.getServer().getWorld(DimensionType.OVERWORLD);
					Entity entity2 = entityIn.getType().create(nextWorld);
					BlockPos spawnPos = new BlockPos(center.getX(),
							nextWorld.getSeaLevel(),
							center.getZ()).up(3).west(2).south(1);
					if (entity2 != null)
					{
						entity2.copyDataFromOld(entityIn);
						entity2.moveToBlockPosAndAngles(spawnPos, entityIn.rotationYaw, entityIn.rotationPitch);
						entity2.setMotion(entityIn.getMotion());
						nextWorld.func_217460_e(entity2);
					}
					entityIn.remove(false);
					worldIn.getProfiler().endSection();
					ServerWorld deepwaters = entityIn.getServer().getWorld(deepWatersDimensionType);

					deepwaters.resetUpdateEntityTick();
					nextWorld.resetUpdateEntityTick();
					worldIn.getProfiler().endSection();
				}
			}
		}

	}

	private BlockPos findPortalCenter(World world, BlockPos pos)
	{
		for (Direction dir : new Direction[]{Direction.WEST, Direction.EAST, Direction.SOUTH, Direction.NORTH})
		{
			for (int i = 1; i <= 4; i++)
			{
				Block block = world.getBlockState(
						pos.offset(dir, i)).getBlock();
				Block block1 = world.getBlockState(
						pos.offset(dir, i).east(1)).getBlock();
				Block block2 = world.getBlockState(
						pos.offset(dir, i).west(1)).getBlock();
				DeepWatersPortalPillarEnd pillarEnd = DeepWatersBlocks.ACTIVATED_PORTAL_PILLAR_END.get();
				if (block == pillarEnd)
				{
					return pos.offset(dir, i);
				}
				if (block1 == pillarEnd)
				{
					return pos.offset(dir, i).east(1);
				}
				if (block2 == pillarEnd)
				{
					return pos.offset(dir, i).west(1);
				}
			}
		}
		return null;
	}


}
