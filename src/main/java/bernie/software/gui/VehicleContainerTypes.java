package bernie.software.gui;

import bernie.software.DeepWatersMod;
import bernie.software.gui.surge.SurgeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VehicleContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, DeepWatersMod.ModID);

    public static final RegistryObject<ContainerType<SurgeContainer>> SURGE = CONTAINER_TYPES.register("surge", () -> IForgeContainerType.create(SurgeContainer::new));


}
