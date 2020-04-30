package bernie.software.utils.misc;

import bernie.software.DeepWatersMod;
import bernie.software.entity.SurgeVehicle;
import bernie.software.gui.surge.OpenSurgeGuiPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

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

