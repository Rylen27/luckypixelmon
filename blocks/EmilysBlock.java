package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;


public class EmilysBlock extends BlockBase
{


	public EmilysBlock(String name, Material material) 
	{
		super(name, material);	
		setSoundType(SoundType.METAL);
		setHardness(3.0F);
		setResistance(100.0F);
		setHarvestLevel("pickaxe", 1);
		setLightLevel(2.0F);
		setLightOpacity(200);
	}
		//setBlockUnbreakable();
	    @Override
	    public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    @Override
	    public boolean isTranslucent(IBlockState state)
	    {
	        return true;
	    }

	    @Override
	    public BlockRenderLayer getBlockLayer() {
	        return BlockRenderLayer.TRANSLUCENT;
		
	}
}
