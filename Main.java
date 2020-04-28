package com.Rylen27.luckypixelmon;

import com.Rylen27.luckypixelmon.init.ModRecipes;
import com.Rylen27.luckypixelmon.init.OreDictionaryInit;
import com.Rylen27.luckypixelmon.proxy.CommonProxy;
import com.Rylen27.luckypixelmon.util.Reference;
import com.Rylen27.luckypixelmon.util.handlers.RegistryHandler;
import com.Rylen27.luckypixelmon.world.ModWorldGen;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.Name, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
		OreDictionaryInit.registerOres();
		RegistryHandler.initRegistries(event);
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries();
	}
	
	
	
}

