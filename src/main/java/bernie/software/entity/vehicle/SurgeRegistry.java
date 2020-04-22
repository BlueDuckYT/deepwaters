package bernie.software.entity.vehicle;

import bernie.software.DeepWatersMod;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.IContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = DeepWatersMod.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SurgeRegistry
{
    private static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();

    public static final ContainerType<SurgeContainer> SURGE_CONTAINER = register(new ResourceLocation(DeepWatersMod.ModID, "backpack"), (IContainerFactory<SurgeContainer>) (windowId, playerInventory, data) -> new SurgeContainer(windowId, playerInventory, data.readVarInt()));

    private static <T extends Container> ContainerType<T> register(ResourceLocation name, ContainerType.IFactory<T> factory)
    {
        ContainerType<T> type = new ContainerType<>(factory);
        type.setRegistryName(name);
        CONTAINER_TYPES.add(type);
        return type;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerTypes(final RegistryEvent.Register<ContainerType<?>> event)
    {
        CONTAINER_TYPES.forEach(type -> event.getRegistry().register(type));
        CONTAINER_TYPES.clear();
    }
}

