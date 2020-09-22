package blueduck.deepwaters.registry;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.gui.surge.SurgeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeepWatersContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, DeepWatersMod.ModID);

    public static final RegistryObject<ContainerType<SurgeContainer>> SURGE = CONTAINER_TYPES.register("surge", () -> IForgeContainerType.create(SurgeContainer::new));


}
