package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EmilysOre extends BlockBase {
	
	public EmilysOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(15.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 1);
	}
}		

