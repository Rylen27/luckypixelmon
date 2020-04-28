package com.Rylen27.luckypixelmon.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HaileysOre extends BlockBase
{
	public HaileysOre(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(4.0F);
		setResistance(50.0F);
		setHarvestLevel("pickaxe", 2);
	}
}
