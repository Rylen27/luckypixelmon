package com.Rylen27.luckypixelmon.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.blocks.item.ItemBlockVariants;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.util.IMetaName;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;
import com.Rylen27.luckypixelmon.world.feature.tree.WorldGenCherryTree;
import com.Rylen27.luckypixelmon.world.feature.tree.WorldGenTestTree;
import com.google.common.base.Predicate;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockSapling1 extends BlockBush implements IGrowable, IMetaName, IHasModel
{
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	 public static final PropertyEnum<EnumHandlerPlanks1.EnumTypePlanks1> VARIANT = PropertyEnum.<EnumHandlerPlanks1.EnumTypePlanks1>create("variant", EnumHandlerPlanks1.EnumTypePlanks1.class, new Predicate<EnumHandlerPlanks1.EnumTypePlanks1>()
		{
			public boolean apply(@Nullable EnumHandlerPlanks1.EnumTypePlanks1 apply)
			{
				return apply.getMeta() < 2;
			}
		});
	 private String name;   
	 public BlockSapling1(String name)
	 {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.CHERRY).withProperty(STAGE, Integer.valueOf(0)));
		setSoundType(SoundType.PLANT);
		setCreativeTab(CreativeTabs.DECORATIONS);
		this.setTickRandomly(true);
		setHardness(0.0F);
	 
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	 }
	 
	 
//Sapling Shape
	 
	 
	 @Override
	 public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return SAPLING_AABB;
	    }
	 
 	@Override
	 public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	 {
		 return NULL_AABB;
	 }
	 
 	@Override
	 public boolean isOpaqueCube(IBlockState state)
	 {
		 return false;
	 }
	 
	@Override
	 public boolean isFullCube(IBlockState state)
	 {
		 return false;
	 }
	 
//Variants
	
	 
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
		{
			for(EnumHandlerPlanks1.EnumTypePlanks1 enumhandlerplanks1$enumtypeplanks1 : EnumHandlerPlanks1.EnumTypePlanks1.values())
			{
				items.add(new ItemStack(this, 1, enumhandlerplanks1$enumtypeplanks1.getMeta()));
			}
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
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.byMetaData(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT)).getMeta();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
    }
	
	//Tree Code
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }
	
	@Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }
	
	@Override
	protected boolean canSustainBush(IBlockState state)
	{
		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
	}
    
	@Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, rand, pos, state);
        }
    }
    
    public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
    {
    	if (TerrainGen.saplingGrowTree(world, rand, pos)) return;
    	WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
    	int i = 0;
        int j = 0;
        boolean flag = false;
        
        switch ((EnumHandlerPlanks1.EnumTypePlanks1)state.getValue(VARIANT))
        {
        case CHERRY:
        	gen = new WorldGenCherryTree();
        	break;
        case TEST:
        	gen = new WorldGenTestTree();
        	break;
        	
        }
        IBlockState iblockstate = Blocks.AIR.getDefaultState();
        
        if (flag)
        {
            world.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
            world.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
            world.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
            world.setBlockState(pos.add(1, 0, 1), iblockstate, 4);
        }
        else
        {
            world.setBlockState(pos, iblockstate, 4);
        }
        
        if (!gen.generate(world, rand, pos))
        {
            if (flag)
            {
                world.setBlockState(pos.add(0, 0, 0), state, 4);
                world.setBlockState(pos.add(1, 0, 0), state, 4);
                world.setBlockState(pos.add(0, 0, 1), state, 4);
                world.setBlockState(pos.add(1, 0, 1), state, 4);
            }
            else
            {
                world.setBlockState(pos, state, 4);
            }
        }
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
           if (!worldIn.isRemote)
           {
               super.updateTick(worldIn, pos, state, rand); //Calls the BlockBush version

               if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
               {
                   this.grow(worldIn, rand, pos, state);
               }
           }
    }
    
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandlerPlanks1.EnumTypePlanks1.values().length; i++ )
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "sapling_" + EnumHandlerPlanks1.EnumTypePlanks1.values()[i].getName(), "inventory");
		}
		
	}
	@Override
	public int getItemEnchantibility() {
		return 0;
	}
	
	
	
	
	
	
}
