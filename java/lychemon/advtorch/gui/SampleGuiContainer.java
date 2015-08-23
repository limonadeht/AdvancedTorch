package lychemon.advtorch.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class SampleGuiContainer extends GuiContainer
{
	 private static final ResourceLocation TEXTURE = new ResourceLocation("<DomainName>", "textures/gui/gui_texture.png");
	    public SampleGuiContainer(int x, int y, int z) {
	        super(new SampleContainer(x, y, z));
	    }

	    @Override
	    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseZ) {
	        super.drawGuiContainerForegroundLayer(mouseX, mouseZ);
	    }

	    @Override
	    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseZ) {
	        this.mc.renderEngine.bindTexture(TEXTURE);
	        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
	    }

	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
}
