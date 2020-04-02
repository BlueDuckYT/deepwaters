package bernie.software.registry;

import bernie.software.DeepWatersMod;
import bernie.software.biome.DefaultWaterBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, DeepWatersMod.ModID);

    public static final RegistryObject<Biome> default_water = BIOMES.register(
            "default_water", () -> new DefaultWaterBiome());

    public static void addBiomeTypes() {
        BiomeDictionary.addTypes(default_water.get(), BiomeDictionary.Type.NETHER);
    }
}
