package com.Rylen27.luckypixelmon.util.handlers;

import com.Rylen27.luckypixelmon.entity.abigailsArrow.EntityAbigailsArrow;
import com.Rylen27.luckypixelmon.entity.abigailsArrow.RenderAbigailsArrow;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityAbigailsArrow.class, new IRenderFactory<EntityAbigailsArrow>() 
		{
			@Override
			public Render<? super EntityAbigailsArrow> createRenderFor(RenderManager manager)
			{
				return new RenderAbigailsArrow(manager);
			}

		});
	}
}