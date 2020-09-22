package blueduck.deepwaters.utils.misc;

import blueduck.deepwaters.DeepWatersMod;
import blueduck.deepwaters.entity.SurgeVehicle;
import blueduck.deepwaters.gui.surge.OpenSurgeGuiPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraftforge.client.event.GuiOpenEvent;

public final class ClientInitializer implements Initializer {

    @Override
    public void init(final Context mod) {
        mod.bus().<GuiOpenEvent>addListener(e -> {
            if (e.getGui() instanceof InventoryScreen) {
                final ClientPlayerEntity player = Minecraft.getInstance().player;
                if (player.getRidingEntity() instanceof SurgeVehicle) {
                    e.setCanceled(true);
                    DeepWatersMod.CHANNEL.sendToServer(new OpenSurgeGuiPacket());
                }
            }
        });
    }
}

