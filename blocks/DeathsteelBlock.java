package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DeathsteelBlock extends BlockBase

{
	public DeathsteelBlock(String name, Material material) 
	{
		super(name, material);	
		setSoundType(SoundType.METAL);
		setHardness(7.0F);
		setResistance(150.0F);
		setHarvestLevel("pickaxe", 3);
		//setLightLevel(1.0F);
		//setLightOpacity();
		//setBlockUnbreakable();
	}
}

