package lychemon.advtorch.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.Names;
import net.minecraft.block.Block;

public class tutBlocks
{
	public static Block CABLE;

	public static void init()
	{
		CABLE = new BlockCable();

		GameRegistry.registerBlock(CABLE, ItemBlockStandardMetadata.class, Names.CABLE);
	}
}
