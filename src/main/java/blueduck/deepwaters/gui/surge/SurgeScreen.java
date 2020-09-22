package blueduck.deepwaters.gui.surge;

import blueduck.deepwaters.utils.GeneralUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Author: MrCrayfish
 */
@OnlyIn(Dist.CLIENT)
public class SurgeScreen extends ContainerScreen<SurgeContainer>
{
    private static final ResourceLocation GUI_TEXTURE = GeneralUtils.Location("textures/gui/surgegui.png");
    private static final ResourceLocation RECIPE_BUTTON_TEXTURE = new ResourceLocation("textures/gui/recipe_button.png");

    public SurgeScreen(SurgeContainer surgeContainer, PlayerInventory playerInventory, ITextComponent titleIn)
    {
        super(surgeContainer, playerInventory, titleIn);
        this.xSize = 175;
        this.ySize = 165;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 0x404040);
        this.font.drawString("Upgrades", 98.0F, 6.0F, 0x404040);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 92), 0x404040);
//        this.addButton(new ImageButton(this.guiLeft + 90, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, (button) -> {
//            ((SurgeVehicle) this.container.vehicle).playerInteracted.closeScreen();
//            this.container.vehicle.getEntityWorld().addParticle(ParticleTypes.EXPLOSION, this.container.vehicle.getPosX(), this.container.vehicle.getPosY(), this.container.vehicle.getPosZ(), 0, 0, 0);
//            this.container.vehicle.setHealth(0);
//            ((ImageButton)button).setPosition(this.guiLeft + 90, this.height / 2 - 49);
//        }));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
        int startX = (this.width - this.xSize) / 2;
        int startY = (this.height - this.ySize) / 2;
        this.blit(startX, startY, 0, 0, this.xSize, this.ySize);
//        this.blit(startX, startY + this.rows * 18 + 17, 0, 126, this.xSize, 96);
    }


}
