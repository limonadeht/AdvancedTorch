package lychemon.advtorch;

import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.item.AdvTorchItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void registry()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(AdvTorchItems.CoalPowder, 1),
			       new ItemStack(Items.coal,1)
			);

		GameRegistry.addRecipe(
			    new ItemStack(AdvancedTorch.BlockTorchMk1, 8),
			    new Object[] {
			        "x",
			        "y",
			        'x', AdvTorchItems.CoalPowder,
			        'y', Items.stick } );
	}
}
