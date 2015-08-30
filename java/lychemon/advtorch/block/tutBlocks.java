package lychemon.advtorch.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.Names;
import net.minecraft.block.Block;

public class tutBlocks
{
	public static Block CABLE;
	public static Block EnergyGenerator;

	public static void init()
	{
		CABLE = new BlockCable();
		//EnergyGenerator = new BlockEnergyGenerator();

		GameRegistry.registerBlock(CABLE, ItemBlockStandardMetadata.class, Names.CABLE);
		//GameRegistry.registerBlock(EnergyGenerator, Names.ENERGY_GENERATOR);
	}
}
