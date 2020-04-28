package com.Rylen27.luckypixelmon.init;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.entity.abigailsArrow.EntityAbigailsArrow;
import com.Rylen27.luckypixelmon.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntities()
	{
		registerArrow("abigails_arrow", EntityAbigailsArrow.class, Reference.ENTITY_ABIGAILS_ARROW);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, 64, 20, true);
	}
}
