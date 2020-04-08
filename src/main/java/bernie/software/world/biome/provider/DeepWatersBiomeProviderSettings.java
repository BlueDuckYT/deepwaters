package bernie.software.world.biome.provider;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class DeepWatersBiomeProviderSettings implements IBiomeProviderSettings
{
	private long seed;
	private WorldInfo worldInfo;

	public DeepWatersBiomeProviderSettings setWorldInfo(WorldInfo info)
	{
		this.worldInfo = info;
		return this;
	}

	public DeepWatersBiomeProviderSettings setSeed(long seed)
	{
		this.seed = seed;
		return this;
	}

	public long getSeed()
	{
		return this.seed;
	}


	public WorldInfo getWorldInfo()
	{
		return this.worldInfo;
	}
}
