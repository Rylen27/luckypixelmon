package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DeathsteelOre extends BlockBase

{
public DeathsteelOre(String name, Material material) {
		
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(7.0F);
		setResistance(100.0F);
		setHarvestLevel("pickaxe", 3);
	}
}