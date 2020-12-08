package xavier.just_dust.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import xavier.just_dust.containers.ContainerGrinder;
import xavier.just_dust.tileentities.TileEntityGrinder;

public class GUIGrinder extends GuiContainer {
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
    private final InventoryPlayer playerInventory;
    private final IInventory tileGrinder;

    public GUIGrinder(InventoryPlayer playerInv, IInventory furnaceInv) {
        super(new ContainerGrinder(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileGrinder = furnaceInv;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.tileGrinder.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if (TileEntityGrinder.isRunning(this.tileGrinder)) {
            int k = this.getBurnLeftScaled();
            this.drawTexturedModalRect(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled();
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, l + 1, 16);
    }

    private int getCookProgressScaled() {
        int i = this.tileGrinder.getField(2);
        int j = this.tileGrinder.getField(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    private int getBurnLeftScaled() {
        int i = this.tileGrinder.getField(1);
        if (i == 0) {
            i = 200;
        }
        return this.tileGrinder.getField(0) * 13 / i;
    }
}
