package com.Rylen27.luckypixelmon.blocks;

import javax.annotation.Nullable;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.blocks.item.ItemBlockVariants;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.util.IMetaName;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;
import com.google.common.base.Predicate;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockLog1 extends BlockLog implements IMetaName, IHasModel
{
	public static final PropertyEnum<EnumHandlerPlanks1.EnumTypePlanks1> VARIANT = PropertyEnum.<EnumHandlerPlanks1.EnumTypePlanks1>create("variant", EnumHandlerPlanks1.EnumTypePlanks1.class, new Predicate<EnumHandlerPlanks1.EnumTypePlanks1>()
			{
				public boolean apply(@Nullable EnumHandlerPlanks1.EnumTypePlanks1 apply)
				{
					return apply.getMeta() < 2;
				}
			});
	
	private String name;
	public BlockLog1 (String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.CHERRY).withProperty(LOG_AXIS, EnumAxis.Y));
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	
	}
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandlerPlanks1.EnumTypePlanks1 enumhandlerplanks1$enumtypeplanks1 : EnumHandlerPlanks1.EnumTypePlanks1.values())
		{
			items.add(new ItemStack(this, 1, enumhandlerplanks1$enumtypeplanks1.getMeta()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.byMetaData((meta & 1) % 2));
	
		switch(meta & 6)
		{
		case 0:
			state = state.withProperty(LOG_AXIS, EnumAxis.Y);
			break;
		case 2:
			state = state.withProperty(LOG_AXIS, EnumAxis.X);
			break;
		case 4:
			state = state.withProperty(LOG_AXIS, EnumAxis.Z);
			break;		
		default:
			state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
		}
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
		
		switch((BlockLog1.EnumAxis)state.getValue(LOG_AXIS))
		{
		case X:
			i |= 2;
			break;
		case Y:
			i |= 4;
			break;
		case Z:
			i |= 6;
		}
		return i;
	}
	
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
	}
	
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandlerPlanks1.EnumTypePlanks1.values()[stack.getItemDamage()].getName();
	
	}
	
	@Override
	public void registerModels()
	{
		for(int i = 0; i < EnumHandlerPlanks1.EnumTypePlanks1.values().length; i++ )
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "log_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName(), "inventory");
		}
	}

	@Override
	public int getItemEnchantibility() {
		
		return 0;
	}

	}
	

