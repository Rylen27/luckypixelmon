package com.Rylen27.luckypixelmon.util.handlers;

import net.minecraft.util.IStringSerializable;

public class EnumHandlerPlanks1 
{
	public static enum EnumTypePlanks1 implements IStringSerializable
	{
		CHERRY( 0, "cherry"),
		TEST( 1, "test");
		
		private static final EnumTypePlanks1[] META_LOOKUP = new EnumTypePlanks1[values().length];
		private final int meta;
		private final String name, unlocalizedName;
		
		private EnumTypePlanks1(int meta, String name)
		{
			this(meta, name, name);
		}
		
		private EnumTypePlanks1(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public int getMeta() 
		{
			return this.meta;
		}
		
		public String getUnlocalizedName() 
		{
			return this.unlocalizedName;
		}
		
		@Override
		public String toString() 
		{
			return this.name;
		}
		
		public static EnumTypePlanks1 byMetaData(int meta)
		{
			return META_LOOKUP[meta];
		}
		
		static
		{
			for(EnumTypePlanks1 enumtypeplanks1 : values())
			{
				META_LOOKUP[enumtypeplanks1.getMeta()] = enumtypeplanks1;
			}
		}
	}
}