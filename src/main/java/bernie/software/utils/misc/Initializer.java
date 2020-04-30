package bernie.software.utils.misc;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;

public interface Initializer {
    void init(final Context mod);

    interface Context {
        ModLoadingContext context();

        IEventBus bus();

        IEventBus modBus();
    }
}
