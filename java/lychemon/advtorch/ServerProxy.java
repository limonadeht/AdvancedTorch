package lychemon.advtorch;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.tileentity.TileEntityEnergyGenerator;

public class ServerProxy
{
	public void registerRenderThings()
	{

	}

	public void registerTileEntitySpecialRenderer()
	{
		GameRegistry.registerTileEntity(TileEntityEnergyGenerator.class, AdvancedTorch.MOD_ID + ":EnergyGenerator");
	}
}
