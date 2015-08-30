package lychemon.advtorch.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.GuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == GuiIds.POWER_GENERATOR) return new ContainerEnergyGenerator(player, world, x, y, z);
		if(ID == AdvancedTorch.GUI_ID) return new SampleContainer(x, y, z);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID == GuiIds.POWER_GENERATOR) return new GuiEnergyGenerator(player, world, x, y, z);
		if(ID == AdvancedTorch.GUI_ID) return new SampleGuiContainer(x, y, z);
		return null;
	}

	public static void register()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(AdvancedTorch.instance, new GuiHandler());
	}

}
