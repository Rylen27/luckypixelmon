package com.Rylen27.luckypixelmon.init;

import java.util.ArrayList;
import java.util.List;

import com.Rylen27.luckypixelmon.blocks.AbigailsBlock;
import com.Rylen27.luckypixelmon.blocks.AbigailsOre;
import com.Rylen27.luckypixelmon.blocks.AluminumBlock;
import com.Rylen27.luckypixelmon.blocks.AluminumOre;
import com.Rylen27.luckypixelmon.blocks.BasicTableBlock;
import com.Rylen27.luckypixelmon.blocks.BlockBase;
import com.Rylen27.luckypixelmon.blocks.BlockLeaves1;
import com.Rylen27.luckypixelmon.blocks.BlockLog1;
import com.Rylen27.luckypixelmon.blocks.BlockSapling1;
import com.Rylen27.luckypixelmon.blocks.DeathsteelBlock;
import com.Rylen27.luckypixelmon.blocks.DeathsteelOre;
import com.Rylen27.luckypixelmon.blocks.EmilysBlock;
import com.Rylen27.luckypixelmon.blocks.EmilysOre;
import com.Rylen27.luckypixelmon.blocks.HaileyCake;
import com.Rylen27.luckypixelmon.blocks.HaileysBlock;
import com.Rylen27.luckypixelmon.blocks.HaileysOre;
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
	
	
	//Pixelmon
	public static final Block ALUMINUM_BLOCK = new AluminumBlock("aluminum_block", Material.IRON);
	public static final Block ALUMINUM_ORE = new AluminumOre("aluminum_ore", Material.ROCK);
	
	//Blocks
	public static final Block HAILEYS_BLOCK = new HaileysBlock("haileys_block", Material.IRON);
	public static final Block ABIGAILS_BLOCK = new AbigailsBlock("abigails_block", Material.IRON);
	public static final Block EMILYS_BLOCK = new EmilysBlock("emilys_block", Material.IRON);
	
	//ORE
	public static final Block HAILEYS_ORE = new HaileysOre("haileys_ore", Material.ROCK);
	public static final Block ABIGAILS_ORE = new AbigailsOre("abigails_ore", Material.ROCK);
	public static final Block EMILYS_ORE = new EmilysOre("emilys_ore", Material.ROCK);
	
	//Dad
	public static final Block DEATHSTEEL_BLOCK = new DeathsteelBlock("deathsteel_block", Material.IRON);
	public static final Block DEATHSTEEL_ORE = new DeathsteelOre("deathsteel_ore", Material.ROCK);
	
	//Furniture
	public static final Block BASIC_TABLE_BLOCK = new BasicTableBlock("basic_table_block", Material.WOOD);
	
	//Cake
	public static final Block HAILEY_CAKE = new HaileyCake("hailey_cake", Material.CAKE);
	
	//Cherry
	public static final Block CHERRY_PLANKS = new BlockBase("cherry_planks", Material.WOOD);
	public static final Block CHERRY_LOG = new BlockLog1("cherry_log");
	public static final Block CHERRY_LEAVES = new BlockLeaves1("cherry_leaves");
	public static final Block CHERRY_SAPLING = new BlockSapling1("cherry_sapling");
	
	//Test
	public static final Block TEST_PLANKS = new BlockBase("test_planks", Material.WOOD);
	public static final Block TEST_LOG = new BlockLog1("test_log");
	public static final Block TEST_LEAVES = new BlockLeaves1("test_leaves");
	public static final Block TEST_SAPLING = new BlockSapling1("test_sapling");	
	
	
}

	

