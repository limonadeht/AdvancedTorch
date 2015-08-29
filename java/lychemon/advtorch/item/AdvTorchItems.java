package lychemon.advtorch.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.AdvancedTorch;
import lychemon.advtorch.Names;
import net.minecraft.item.Item;

public class AdvTorchItems
{
	public static Item CoalPowder;
	public static Item TorchMk2Placer;
	public static Item DEV_TOOL;

	public static void registry(AdvancedTorch mod)
	{
		CoalPowder = new CoalPowder();
		TorchMk2Placer = new TorchMk2Placer();
		DEV_TOOL = new ItemEnergyMeter();

		GameRegistry.registerItem(DEV_TOOL, Names.ENERGY_METER);

		return;
	}
}
