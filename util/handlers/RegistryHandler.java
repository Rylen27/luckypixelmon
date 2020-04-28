package com.Rylen27.luckypixelmon.util.handlers;

import java.beans.EventHandler;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.init.EntityInit;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.init.OreDictionaryInit;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.world.generation.WorldGenCustomTrees;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void registerModel(ModelRegistryEvent event)
	{
		
		
		
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) 
	{

		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
		RenderHandler.registerEntityRenders();

	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
		
		OreDictionaryInit.registerOres();
		
	}
	
	public static void postInitRegistries()
	{
		
	
	}
}
