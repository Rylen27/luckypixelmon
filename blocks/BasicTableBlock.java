package com.Rylen27.luckypixelmon.blocks;

import com.jcraft.jorbis.Block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BasicTableBlock extends BlockBase
{
	//                                                                          ( x1,      y1,       z1,       x2,           y2,       z2)
	public static final AxisAlignedBB BASIC_TABLE_BLOCK_AABB = new AxisAlignedBB(.03125D, .03125D, 0.0D, .96875D, 1.0D, .96875D);
	public BasicTableBlock (String name, Material cake) 
	{
		super(name, Material.WOOD);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public int getItemEnchantibility() {
		return 0;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BASIC_TABLE_BLOCK_AABB;
	}
	

}
