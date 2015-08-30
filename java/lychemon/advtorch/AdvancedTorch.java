package lychemon.advtorch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import lychemon.advtorch.block.BlockAdvTorch;
import lychemon.advtorch.block.BlockTorchMk1;
import lychemon.advtorch.block.BlockTorchMk2;
import lychemon.advtorch.block.BlockTv;
import lychemon.advtorch.block.SampleGuiBlock;
import lychemon.advtorch.gui.GuiHandler;
import lychemon.advtorch.item.AdvTorchItems;
import lychemon.advtorch.item.SampleGuiItem;
import lychemon.advtorch.power.CommonProxyPW;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = AdvancedTorch.MOD_ID, version = AdvancedTorch.VERSION, useMetadata = true)
public class AdvancedTorch
{
	@Mod.Instance("AdvancedTorch")
	//INSTANCE
	public static AdvancedTorch instance;
	public static final String MOD_ID = "AdvancedTorch";
	public static final String VERSION = "Alpha-2.3.3";

	//PROXIES
	@SidedProxy(clientSide = "lychemon.advtorch.ClientProxy", serverSide = "lychemon.advtorch.ServerProxy")

	public static ServerProxy Tvproxy;
	public static ServerProxy ServerProxy;

	//BLOCKS
	public static Block BlockTorchMk1;
	public static Block BlockTorchMk2;
	public static Block BlockAdvTorch;
	public static Block SampleGuiBlock;
	public static Block BlockTv;

	//ITEMS
	public static Item SampleGuiItem;

	//TILEENTITY
	public static Block OMGTile;

	//CREATIVETABS
	public static final CreativeTabs tabAdvTorch = new AdvancedTorchTab("AdvancedTorch");

	//GUI_ID
	public static final int GUI_ID = 1;

	//POWER
	@SidedProxy(clientSide = "lychemon.advtorch.power.ClientProxyPW",
			serverSide = "lychemon.advtorch.power.CommonProxyPW")
	public static CommonProxyPW proxy;

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

        BlockTv = new BlockTv(Material.rock).setBlockName("TV");
        GameRegistry.registerBlock(BlockTv, "TV");

		//tutBlocks(CABLES)
		lychemon.advtorch.block.tutBlocks.init();

		//TILEENTITY

        //RENDERERS
        Tvproxy.registerRenderThings();

		//ITEMS
		AdvTorchItems.registry(this);
    }

    @EventHandler
    public void Init( FMLInitializationEvent e )
    {
		//POWER
		proxy.registerRenderers();
		proxy.registerTileEntitys();

		//GUI
		GuiHandler.register();

    	Recipes.registry();
    }
}
