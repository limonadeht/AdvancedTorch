package lychemon.advtorch.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class BlockUtil
{
	public static int determineMetadataBasedOnPlayerOrientation(EntityPlayer player)
	{
		int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.F) + 0.5F) &3;
		if(rotation == 0)
		{
			return 2;
		}
		if(rotation == 1)
		{
			return 5;
		}
		if(rotation == 2)
		{
			return 3;
		}
		if(rotation == 3)
		{
			return 4;
		}
		return 3;
	}
}
