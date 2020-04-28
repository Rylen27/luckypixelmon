package com.Rylen27.luckypixelmon.blocks;

import javax.annotation.Nullable;

import com.Rylen27.luckypixelmon.Main;
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
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockLog1 extends BlockLog implements IHasModel
{
	
	public BlockLog1 (String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));		
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = this.getDefaultState();
		
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
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}
	
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(this);
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
	

