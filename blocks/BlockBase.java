package com.Rylen27.luckypixelmon.blocks;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
	}

	@Override
	public int getItemEnchantibility() {
		return 0;
	}
}
