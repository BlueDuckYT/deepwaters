package bernie.software.world.biome;

import bernie.software.registry.DeepWatersWorldCarvers;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public abstract class WaterBiomeBase extends Biome
{
	protected WaterBiomeBase(Builder biomeBuilder)
	{
		super(biomeBuilder);
	}

	public static EntityClassification WATER_PASSIVE = EntityClassification.create("water_passive", "WATER_PASSIVE",
			100, true, false);
	public static EntityClassification WATER_MONSTER = EntityClassification.create("water_monster", "WATER_MONSTER",
			100, false, false);
	public static EntityClassification WATER_LAND_PASSIVE = EntityClassification.create("water_land_passive",
			"WATER_LAND_PASSIVE", 15, true, true);

	@Override
	public void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry)
	{
		super.addSpawn(type, spawnListEntry);
	}

	public double getNoiseFactor() {
		return 1;
	}

	public void addWaterPassiveCreatureSpawn(SpawnListEntry spawnListEntry)
	{
		boolean animal = WATER_PASSIVE.getAnimal();
		int maxNumberOfCreature = WATER_PASSIVE.getMaxNumberOfCreature();
		boolean peacefulCreature1 = WATER_PASSIVE.getPeacefulCreature();

		boolean animal1 = EntityClassification.WATER_CREATURE.getAnimal();
		int maxNumberOfCreature1 = EntityClassification.WATER_CREATURE.getMaxNumberOfCreature();
		boolean peacefulCreature = EntityClassification.WATER_CREATURE.getPeacefulCreature();
		addSpawn(WATER_PASSIVE, spawnListEntry);
	}

	public void addWaterMonsterCreatureSpawn(SpawnListEntry spawnListEntry)
	{
		addSpawn(WATER_MONSTER, spawnListEntry);
	}

	public void addWaterLandPassiveCreatureSpawn(SpawnListEntry spawnListEntry)
	{
		addSpawn(EntityClassification.CREATURE, spawnListEntry);
	}

	public void AddWorldCarver()
	{
		WorldCarver<ProbabilityConfig> carver = DeepWatersWorldCarvers.CORAL_CAVE_CARVER.get();
		addCarver(GenerationStage.Carving.AIR, createCarver(carver, new ProbabilityConfig(0.4F)));
	}

	public abstract void addFeatures();

	public abstract void addSpawns();

	public abstract void addWorldCarvers();

}
