package lychemon.advtorch.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import lychemon.advtorch.AdvancedTorch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	//SERVER
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == AdvancedTorch.GUI_ID) {
            return new SampleContainer(x, y, z);
        }
        return null;
    }

    //CLIENT
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == AdvancedTorch.GUI_ID) {
            return new SampleGuiContainer(x, y, z);
        }
        return null;
    }
}
