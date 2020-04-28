package com.Rylen27.luckypixelmon.blocks;
import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.blocks.item.ItemBlockVariants;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.util.IMetaName;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class BlockPlanks1 extends Block implements IMetaName, IHasModel
{
	public static final PropertyEnum<EnumHandlerPlanks1.EnumTypePlanks1> VARIANT = PropertyEnum.<EnumHandlerPlanks1.EnumTypePlanks1>create("variant", EnumHandlerPlanks1.EnumTypePlanks1.class);
	
	private String name;
	
	public BlockPlanks1(String name) 
	{
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.CHERRY));
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
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
		return this.getDefaultState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.byMetaData(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, (int)(getMetaFromState(world.getBlockState(pos))));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
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
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "planks_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName(), "inventory");
		}
	}

	@Override
	public int getItemEnchantibility() {
		
		return 0;
	}
}