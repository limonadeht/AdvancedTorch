package lychemon.advtorch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.block.BlockAdvTorch;
import lychemon.advtorch.block.BlockTorchMk1;
import lychemon.advtorch.block.BlockTorchMk2;
import lychemon.advtorch.item.AdvTorchItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = AdvancedTorch.MODID, version = AdvancedTorch.VERSION, useMetadata = true)
public class AdvancedTorch
{
	@Mod.Instance("AdvancedTorch")
	public static final String MODID = "Advanced-Torch";
	public static final String VERSION = "Alpha-1.0.0";

	//BLOCKS
	public static Block BlockTorchMk1;
	public static Block BlockTorchMk2;
	public static Block BlockAdvTorch;

	//TILEENTITY
	public static Block OMGTile;

	//CREATIVETABS
	public static final CreativeTabs tabAdvTorch = new AdvancedTorchTab("AdvancedTorch");

	//GUI_IDS

	//INSTANCE
	public static AdvancedTorch INSTANCE;

	@EventHandler
    public void preInit( FMLPreInitializationEvent e )
    {
		//GAMEREGISTRY
		//BLOCKS
		BlockTorchMk1 = new BlockTorchMk1().setBlockName("TorchMk_1").setCreativeTab(tabAdvTorch).setBlockTextureName("advancedtorch:torch_on");
		GameRegistry.registerBlock(BlockTorchMk1, "BlockTorchMk1");

		BlockTorchMk2 = new BlockTorchMk2().setBlockName("TorchMk_2").setCreativeTab(tabAdvTorch).setBlockTextureName("advancedtorch:torch_on");
		GameRegistry.registerBlock(BlockTorchMk2, "BlockTorchMk2");

		BlockAdvTorch = new BlockAdvTorch();
		GameRegistry.registerBlock(BlockAdvTorch, "OMG");

		//TILEENTITY

		//ITEMS
		AdvTorchItems.registry(this);
    }

    @EventHandler
    public void Init( FMLInitializationEvent e )
    {
    	Recipes.registry();
    }
}
