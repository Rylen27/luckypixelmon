package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AluminumBlock extends BlockBase 
{
	
	public AluminumBlock(String name, Material material) 
	{
		super(name, material);	
		setSoundType(SoundType.METAL);
		setHardness(4.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightLevel(1.0F);
		//setLightOpacity();
		//setBlockUnbreakable();
	}
}
