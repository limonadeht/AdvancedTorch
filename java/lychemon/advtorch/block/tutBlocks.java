package lychemon.advtorch.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.Names;
import net.minecraft.block.Block;

public class tutBlocks
{
	public static Block CABLE;
	public static Block POWER_GENERATOR;

	public static void init()
	{
		CABLE = new BlockCable();
		POWER_GENERATOR = new BlockEnergyGenerator();

		GameRegistry.registerBlock(CABLE, ItemBlockStandardMetadata.class, Names.CABLE);
		GameRegistry.registerBlock(POWER_GENERATOR, ItemBlockStandardMetadata.class, Names.ENERGY_GENERATOR);
	}
}
