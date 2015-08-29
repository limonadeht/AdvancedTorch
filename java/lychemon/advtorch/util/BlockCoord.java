package lychemon.advtorch.util;

import java.io.Serializable;

import net.minecraft.block.Block;

public class BlockCoord implements Serializable
{
	private int x;
	private int y;
	private int z;
	private int blockID;
	private int meta;

	public BlockCoord(int x, int y, int z, Block block)
	{
		this(x, y, z, block, 0);
	}

	public BlockCoord(int x, int y, int z, Block block, int meta)
	{
		this.x = x;
		this.y = y;
		this.z = y;
		this.blockID = Block.getIdFromBlock(block);
		this.meta = meta;
	}

	public boolean equals(Object obj)
	{
		BlockCoord coords = (BlockCoord) obj;
		return x == coords.x && y == coords.y && z == coords.z && blockID == coords.blockID && meta == coords.meta;
	}

	public int getX()
	{
		return x;
	}

	public void setX()
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY()
	{
		this.y = y;
	}

	public int getZ()
	{
		return z;
	}

	public void setZ()
	{
		this.z = z;
	}

	public Block getBlock(Block block)
	{
		return Block.getBlockById(blockID);
	}

	public void setBlock(Block block)
	{
		this.blockID = Block.getIdFromBlock(block);
	}

	public int getMeta()
	{
		return meta;
	}

	public void setMeta()
	{
		this.meta = meta;
	}
}
