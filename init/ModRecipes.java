package com.Rylen27.luckypixelmon.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes 
{
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.ALUMINUM_ORE, new ItemStack(ModItems.ALUMINUM_INGOT, 2), 1.5F);
		if (Loader.isModLoaded("pixelmon")) GameRegistry.addSmelting(ModBlocks.ALUMINUM_ORE, new ItemStack(Item.getByNameOrId("pixelmon:aluminium_ingot"), 1), 1.5F);
		GameRegistry.addSmelting(ModBlocks.HAILEYS_ORE, new ItemStack(ModItems.HAILEYS_INGOT, 1), 3F);
		GameRegistry.addSmelting(ModBlocks.ABIGAILS_ORE, new ItemStack(ModItems.ABIGAILS_INGOT, 1), 3F);
		GameRegistry.addSmelting(ModBlocks.EMILYS_ORE, new ItemStack(ModItems.EMILYS_INGOT, 2), 5F);
		GameRegistry.addSmelting(ModBlocks.DEATHSTEEL_ORE, new ItemStack(ModItems.DEATHSTEEL_INGOT, 1), 8F);
	
	}
}
