package lychemon.advtorch;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AdvancedTorchTab extends CreativeTabs
{
	public AdvancedTorchTab(String label) {
		super(label);
	}

	//ここでタブのアイコンを返している。
	/*アイテムの場合はそのままわたせばよいが、ブロックの場合はItemStackのgetItemメソッドを利用する。*/
	@Override
	public Item getTabIconItem() {
		return new ItemStack(Items.apple, 1, 0).getItem();
	}
}
