package bernie.software.biome;

import bernie.software.registry.DeepWatersWorldCarvers;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class WaterBiomeBase extends Biome
{
	protected WaterBiomeBase(Builder biomeBuilder)
	{
		super(biomeBuilder);
	}

	@Override
	public void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry)
	{
		super.addSpawn(type, spawnListEntry);
	}

	public void addWaterCreatureSpawn(SpawnListEntry spawnListEntry)
	{
		addSpawn(EntityClassification.WATER_CREATURE, spawnListEntry);
	}

	public void addWeightedWaterCreatureSpawn(int weight, SpawnListEntry spawnListEntry)
	{
		for(int i = 0; i < weight; i++)
		{
			addWaterCreatureSpawn(spawnListEntry);
		}
	}

	public void AddWorldCarver()
	{
		WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
		this.addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(0.4F)));
	}
}
