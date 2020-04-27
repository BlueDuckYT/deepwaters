package bernie.software.gui.surge;

import bernie.software.entity.SurgeVehicle;
import bernie.software.gui.VehicleContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraftforge.items.SlotItemHandler;

public class SurgeContainer extends VehicleContainer {

    public SurgeContainer(final int id, final PlayerInventory playerInv, final SurgeVehicle surge) {
        super(ContainerType.GENERIC_9X6, id, surge);
        final int upperInvHeight = 36;

        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new SlotItemHandler(this.inventory, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }

        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInv, l + k * 9 + 9, 8 + l * 18, 103 + k * 18 + upperInvHeight));
            }
        }

        for (int x = 0; x < 9; ++x) {
            this.addSlot(new Slot(playerInv, x, 8 + x * 18, 161 + upperInvHeight));
        }
    }
}
