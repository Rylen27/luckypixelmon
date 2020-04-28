package com.Rylen27.luckypixelmon.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.blocks.item.ItemBlockVariants;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.util.IMetaName;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;
import com.google.common.base.Predicate;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaves1 extends BlockLeaves implements IMetaName, IHasModel
{
	public static final PropertyEnum<EnumHandlerPlanks1.EnumTypePlanks1> VARIANT = PropertyEnum.<EnumHandlerPlanks1.EnumTypePlanks1>create("variant", EnumHandlerPlanks1.EnumTypePlanks1.class, new Predicate<EnumHandlerPlanks1.EnumTypePlanks1>()
	{
		public boolean apply(@Nullable EnumHandlerPlanks1.EnumTypePlanks1 apply)
		{
			return apply.getMeta() < 2;
		}
	});
	private String name;
	public BlockLeaves1(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.CHERRY).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		setCreativeTab(CreativeTabs.DECORATIONS);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.byMetaData(meta % 2));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
		
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 2;
		}
		
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 4;
		}
		
		return i;
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandlerPlanks1.EnumTypePlanks1 EnumHandlerPlanks1$EnumTypePlanks1 : EnumHandlerPlanks1.EnumTypePlanks1.values())
		{
			items.add(new ItemStack(this, 1, EnumHandlerPlanks1$EnumTypePlanks1.getMeta()));
		}
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack (Item.getItemFromBlock(this), 1, ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta());
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
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) 
	{
		return;
	}
	
	@Override
	protected int getSaplingDropChance(IBlockState state) 
	{
		return 20;
	}
	
	@Override
	public EnumType getWoodType(int meta) 
	{
		return null;
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public void registerModels()
	{
		for(int i = 0; i < EnumHandlerPlanks1.EnumTypePlanks1.values().length; i++ )
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "leaves_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName(), "inventory");
		}
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
	    return Item.getItemFromBlock(ModBlocks.SAPLINGS);
	}

	@Override
	public int getItemEnchantibility() {
		
		return 0;
	}
}
