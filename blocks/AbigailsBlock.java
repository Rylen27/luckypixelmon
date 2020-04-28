package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AbigailsBlock extends BlockBase
{
	
	public AbigailsBlock(String name, Material material) 
	{
		super(name, material);	
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(1.0F);
		//setLightOpacity();
		//setBlockUnbreakable();
	}
}
