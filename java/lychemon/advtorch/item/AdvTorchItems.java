package lychemon.advtorch.item;

import lychemon.advtorch.AdvancedTorch;
import net.minecraft.item.Item;

public class AdvTorchItems
{
	public static Item CoalPowder;
	public static Item TorchMk2Placer;

	public static void registry(AdvancedTorch mod)
	{
		CoalPowder = new CoalPowder();
		TorchMk2Placer = new TorchMk2Placer();

		return;
	}
}
