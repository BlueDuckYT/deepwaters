package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.tileentity.TileEntityAquaFan;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, DeepWatersMod.ModID);

    //public static final RegistryObject<TileEntityType<BubbleMachineTileEntity>> BUBBLE_MACHINE = TILE_ENTITIES.register("bubble_machine", () -> TileEntityType.Builder.create(
    //        BubbleMachineTileEntity::new, DeepWatersBlocks.BUBBLE_MACHINE.get()).build(null));
    public static final RegistryObject<TileEntityType<TileEntityAquaFan>> AQUASTONE_FAN = TILE_ENTITIES.register("aquastone_fan", () -> TileEntityType.Builder.create(
            TileEntityAquaFan::new, DeepWatersBlocks.AQUA_FAN.get()).build(null));
}

