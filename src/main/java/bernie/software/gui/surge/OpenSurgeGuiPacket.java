package bernie.software.gui.surge;

import bernie.software.entity.SurgeVehicle;
import bernie.software.utils.network.Message;
import bernie.software.utils.network.ServerMessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;

public final class OpenSurgeGuiPacket implements Message {
    @Override
    public void encode(final PacketBuffer buf) {
    }

    @Override
    public void decode(final PacketBuffer buf) {
    }

    public static void handle(final OpenSurgeGuiPacket msg, final ServerMessageContext ctx) {
        final PlayerEntity player = ctx.getPlayer();
        final Entity ridden = player.getRidingEntity();
        if (ridden instanceof SurgeVehicle) {
            ((SurgeVehicle) ridden).openContainer(player);
        }
    }
}