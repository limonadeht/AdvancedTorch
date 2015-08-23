package lychemon.advtorch.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.AdvancedTorch;
import net.minecraft.item.Item;

public class CoalPowder extends Item
{
	public CoalPowder()
	{
		String name = "coal powder";

		this.setCreativeTab(AdvancedTorch.tabAdvTorch);
		this.setUnlocalizedName(name);
		this.setTextureName("advancedtorch:coal_powder");

		GameRegistry.registerItem(this, name);

		return;
	}
}
