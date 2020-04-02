package bernie.software.world;

import bernie.software.ModEventSubscriber;
import bernie.software.biome.provider.DeepWatersSingleBiomeProvider;
import bernie.software.registry.DeepWatersBiomes;
import bernie.software.registry.DeepWatersBlocks;
import bernie.software.world.gen.DeepWatersChunkGenerator;
import bernie.software.world.gen.DeepWatersGenSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import net.minecraft.world.biome.provider.SingleBiomeProvider;
import net.minecraft.world.biome.provider.SingleBiomeProviderSettings;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;


public class DeepWatersDimension extends Dimension
{
	public DeepWatersDimension(World worldIn, DimensionType typeIn)
	{
		super(worldIn, typeIn);
	}
	@Override
	public ChunkGenerator<?> createChunkGenerator()
	{
		DeepWatersGenSettings deepWatersGenSettings = new DeepWatersGenSettings();
		BlockState oceanFloor = DeepWatersBlocks.OCEAN_FLOOR.get().getDefaultState();
		deepWatersGenSettings.setDefaultBlock(oceanFloor);
		deepWatersGenSettings.setDefaultFluid(Blocks.WATER.getDefaultState());
		SingleBiomeProviderSettings settings = new SingleBiomeProviderSettings();

		settings.setBiome(DeepWatersBiomes.default_water.get());
		DeepWatersSingleBiomeProvider provider = new DeepWatersSingleBiomeProvider(settings);
		return new DeepWatersChunkGenerator(world, provider, deepWatersGenSettings);
	}

	@Nullable
	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid)
	{
		return null;
	}

	@Nullable
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid)
	{
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
	{
		double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
		double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
		return (float)(d0 * 2.0D + d1) / 3.0F;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}
	@Override
	@OnlyIn(Dist.CLIENT)
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		return new Vec3d((double)0.2F, (double)0.03F, (double)0.03F);
	}
	protected void generateLightBrightnessTable() {
		float f = 0.1F;

		for(int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float)i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 0.9F + 0.1F;
		}

	}
	public WorldBorder createWorldBorder() {
		return new WorldBorder() {
			public double getCenterX() {
				return super.getCenterX() / 8.0D;
			}

			public double getCenterZ() {
				return super.getCenterZ() / 8.0D;
			}
		};
	}
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z)
	{
		return true;
	}

	@Override
	public int getSeaLevel()
	{
		return 256;
	}

}
