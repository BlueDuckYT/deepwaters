package blueduck.deepwaters.utils;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.network.play.server.SRespawnPacket;
import net.minecraft.network.play.server.SServerDifficultyPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;

public class TeleportUtils
{
	public static void TeleportPlayerToDimension(ServerWorld deepWatersWorld, ServerPlayerEntity player,
	                                             BlockPos spawnPos)
	{
		deepWatersWorld.getChunk(spawnPos);
		player.teleport(deepWatersWorld, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(),
				player.rotationYaw, player.rotationPitch);
	}

	public static Entity TransferEntityToNewDimension(Entity entityIn, ServerWorld destinationWorld, BlockPos spawnPos)
	{
		Entity entity2 = entityIn.getType().create(destinationWorld);
		if (entity2 != null)
		{
			entity2.copyDataFromOld(entityIn);
			entity2.moveToBlockPosAndAngles(spawnPos, entityIn.rotationYaw, entityIn.rotationPitch);
			entity2.setMotion(entityIn.getMotion());
			destinationWorld.addFromAnotherDimension(entity2);
		}
		return entity2;
	}

	/*
		Show the changing dimension screen, this is usually pretty brief
	*/
	public static void SendDimensionChangePackets(DimensionType dimension, ServerPlayerEntity player, WorldInfo worldInfo)
	{
		player.connection.sendPacket(new SChangeGameStatePacket(4, 0.0F));
		player.connection.sendPacket(new SRespawnPacket(dimension, WorldInfo.byHashing(worldInfo.getSeed()), worldInfo.getGenerator(),
				player.interactionManager.getGameType()));
		player.connection.sendPacket(
				new SServerDifficultyPacket(worldInfo.getDifficulty(), worldInfo.isDifficultyLocked()));
	}

	public static boolean canEntityBeTeleported(BlockState state, World worldIn, BlockPos pos, Entity entityIn)
	{
		return !worldIn.isRemote && !entityIn.isPassenger() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && VoxelShapes.compare(
				VoxelShapes.create(entityIn.getBoundingBox().offset((double) (-pos.getX()), (double) (-pos.getY()),
						(double) (-pos.getZ()))), state.getShape(worldIn, pos), IBooleanFunction.AND);
	}
}
