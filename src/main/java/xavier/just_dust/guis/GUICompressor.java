package xavier.just_dust.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import xavier.just_dust.containers.ContainerCompressor;
import xavier.just_dust.tileentities.TileEntityCompressor;

public class GUICompressor extends GuiContainer {
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
    private final InventoryPlayer playerInventory;
    private final IInventory tileCompressor;

    public GUICompressor(InventoryPlayer playerInv, IInventory furnaceInv) {
        super(new ContainerCompressor(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileCompressor = furnaceInv;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.tileCompressor.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if (TileEntityCompressor.isRunning(this.tileCompressor)) {
            int k = this.getBurnLeftScaled();
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled();
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
    }

    private int getCookProgressScaled() {
        int i = this.tileCompressor.getField(2);
        int j = this.tileCompressor.getField(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    private int getBurnLeftScaled() {
        int i = this.tileCompressor.getField(1);
        if (i == 0) {
            i = 200;
        }
        return this.tileCompressor.getField(0) * 13 / i;
    }
}
