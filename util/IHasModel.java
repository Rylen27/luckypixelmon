package com.Rylen27.luckypixelmon.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IHasModel {

	public void registerModels();

	int getItemEnchantibility();

	
}
