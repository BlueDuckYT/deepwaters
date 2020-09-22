package blueduck.deepwaters.gui.surge;

import blueduck.deepwaters.entity.SurgeVehicle;
import blueduck.deepwaters.utils.network.Message;
import blueduck.deepwaters.utils.network.ServerMessageContext;
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