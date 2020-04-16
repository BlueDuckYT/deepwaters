package bernie.software.world.gen.structures;

import bernie.software.DeepWatersMod;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import org.apache.logging.log4j.Level;

import java.util.Random;
import java.util.function.Function;

public class Portal extends Structure<NoFeatureConfig> {
    public Portal(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean hasStartAt(ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ) {
        DeepWatersMod.logger.log(Level.INFO,"h");
        return true;
    }

    @Override
    public IStartFactory getStartFactory() {
        return null;
    }

    @Override
    public String getStructureName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
