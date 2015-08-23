package lychemon.advtorch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.block.BlockAdvTorch;
import lychemon.advtorch.block.BlockTorchMk1;
import lychemon.advtorch.block.BlockTorchMk2;
import lychemon.advtorch.block.SampleGuiBlock;
import lychemon.advtorch.gui.GuiHandler;
import lychemon.advtorch.item.AdvTorchItems;
import lychemon.advtorch.item.SampleGuiItem;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

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
	public static Block SampleGuiBlock;

	//ITEMS
	public static Item SampleGuiItem;

	//TILEENTITY
	public static Block OMGTile;

	//CREATIVETABS
	public static final CreativeTabs tabAdvTorch = new AdvancedTorchTab("AdvancedTorch");

	//GUI_IDS
	public static final int GUI_ID = 0;

	//INSTANCE
	public static AdvancedTorch INSTANCEE;

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

		SampleGuiBlock = new SampleGuiBlock().setBlockTextureName("stone").setBlockName("sampleGuiBlock").setCreativeTab(tabAdvTorch);
        GameRegistry.registerBlock(SampleGuiBlock, "sample_guiGlock");

        SampleGuiItem = new SampleGuiItem().setTextureName("arrow").setUnlocalizedName("sampleGuiItem").setCreativeTab(tabAdvTorch);
        GameRegistry.registerItem(SampleGuiItem, "sample_GuiItem");

		//TILEENTITY

		//ITEMS
		AdvTorchItems.registry(this);
    }

    @EventHandler
    public void Init( FMLInitializationEvent e )
    {
    	Recipes.registry();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }
}
