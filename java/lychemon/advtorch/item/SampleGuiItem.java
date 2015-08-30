package lychemon.advtorch.item;

import lychemon.advtorch.AdvancedTorch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SampleGuiItem extends Item
{
	@Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        player.openGui(AdvancedTorch.instance, AdvancedTorch.GUI_ID, world, MathHelper.ceiling_double_int(player.posX), MathHelper.ceiling_double_int(player.posY), MathHelper.ceiling_double_int(player.posZ));
        return itemStack;
    }
}
