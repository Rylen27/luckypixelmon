package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AbigailsOre extends BlockBase
{
	public AbigailsOre(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 2);
	}
}