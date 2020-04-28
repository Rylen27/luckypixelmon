package com.Rylen27.luckypixelmon.init;

import java.util.ArrayList;
import java.util.List;

import com.Rylen27.luckypixelmon.blocks.AbigailsBlock;
import com.Rylen27.luckypixelmon.blocks.AbigailsOre;
import com.Rylen27.luckypixelmon.blocks.AluminumBlock;
import com.Rylen27.luckypixelmon.blocks.AluminumOre;
import com.Rylen27.luckypixelmon.blocks.BasicTableBlock;
import com.Rylen27.luckypixelmon.blocks.BlockLeaves1;
import com.Rylen27.luckypixelmon.blocks.BlockLog1;
import com.Rylen27.luckypixelmon.blocks.BlockPlanks1;
import com.Rylen27.luckypixelmon.blocks.BlockSapling1;
import com.Rylen27.luckypixelmon.blocks.DeathsteelBlock;
import com.Rylen27.luckypixelmon.blocks.DeathsteelOre;
import com.Rylen27.luckypixelmon.blocks.EmilysBlock;
import com.Rylen27.luckypixelmon.blocks.EmilysOre;
import com.Rylen27.luckypixelmon.blocks.HaileyCake;
import com.Rylen27.luckypixelmon.blocks.HaileysBlock;
import com.Rylen27.luckypixelmon.blocks.HaileysOre;
import com.Rylen27.luckypixelmon.blocks.item.ItemBlockVariants;
import com.Rylen27.luckypixelmon.util.Reference;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;



public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ALUMINUM_BLOCK = new AluminumBlock("aluminum_block", Material.IRON);
	public static final Block ALUMINUM_ORE = new AluminumOre("aluminum_ore", Material.ROCK);
	public static final Block HAILEYS_BLOCK = new HaileysBlock("haileys_block", Material.IRON);
	public static final Block ABIGAILS_BLOCK = new AbigailsBlock("abigails_block", Material.IRON);
	public static final Block EMILYS_BLOCK = new EmilysBlock("emilys_block", Material.IRON);
	public static final Block HAILEYS_ORE = new HaileysOre("haileys_ore", Material.ROCK);
	public static final Block ABIGAILS_ORE = new AbigailsOre("abigails_ore", Material.ROCK);
	public static final Block EMILYS_ORE = new EmilysOre("emilys_ore", Material.ROCK);
	public static final Block DEATHSTEEL_BLOCK = new DeathsteelBlock("deathsteel_block", Material.IRON);
	public static final Block DEATHSTEEL_ORE = new DeathsteelOre("deathsteel_ore", Material.ROCK);
	public static final Block BASIC_TABLE_BLOCK = new BasicTableBlock("basic_table_block", Material.WOOD);
	public static final Block HAILEY_CAKE = new HaileyCake("hailey_cake", Material.CAKE);
	public static final Block PLANKS = new BlockPlanks1("planks");
	public static final Block LOGS = new BlockLog1("log");
	public static final Block LEAF = new BlockLeaves1("leaves");
	public static final Block SAPLINGS = new BlockSapling1("sapling");
	
	
	public static void register()
	{
		registerBlock(PLANKS, new ItemBlockVariants(PLANKS));
		registerBlock(LOGS, new ItemBlockVariants(LOGS));
		registerBlock(LEAF, new ItemBlockVariants(LEAF));
		registerBlock(SAPLINGS, new ItemBlockVariants(SAPLINGS));
	}
	public void registerBlock(Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(CreativeTabs.MATERIALS);
		ItemBlock item =  new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void registerRenders()
	{
		for (int i = 0; i < EnumHandlerPlanks1.EnumTypePlanks1.values().length; i++)
			{
				registerRender(PLANKS, i, "planks_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName());
				registerRender(LOGS, i, "log_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName());
				registerRender(LEAF, i , "leaves_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName());
				registerRender(SAPLINGS, i, "sapling_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName());
			}
	}
	
	public static void registerBlock(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(CreativeTabs.MATERIALS);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public void registerBlockWithVariants(Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		block.setCreativeTab(CreativeTabs.MATERIALS);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
	}
	
	public static void registerRender(Block block, int meta, String filename)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), "inventory"));
	}
}

	

