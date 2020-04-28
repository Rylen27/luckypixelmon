package com.Rylen27.luckypixelmon.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.Rylen27.luckypixelmon.Main;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.init.ModItems;
import com.Rylen27.luckypixelmon.util.IHasModel;
import com.Rylen27.luckypixelmon.util.IMetaName;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;
import com.Rylen27.luckypixelmon.world.generation.generators.WorldGenCherryTree;
import com.Rylen27.luckypixelmon.world.generation.generators.WorldGenTestTree;
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
import net.minecraft.item.ItemBlock;
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

public class BlockSapling1 extends BlockBush implements IGrowable, IHasModel
{
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	 private String type; 
	
	   
	 public BlockSapling1(String name)
	 {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		setSoundType(SoundType.PLANT);
		setCreativeTab(CreativeTabs.DECORATIONS);
		this.setTickRandomly(true);
		setHardness(0.0F);
	 
		type = name.replaceAll("_sapling", "").trim();
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
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
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
	}
	
	//Tree Code
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
    
    public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
    {
    	if (TerrainGen.saplingGrowTree(world, rand, pos)) return;
    	WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
    	int i = 0;
        int j = 0;
        boolean flag = false;
        
        switch (type)
        {
        case "cherry":
        	gen = new WorldGenCherryTree();
        	break;
        case "test":
        	gen = new WorldGenTestTree();
        	break;
        	
        }
        IBlockState iblockstate = Blocks.AIR.getDefaultState();
        
        if (flag)
        {
            world.setBlockState(pos.add(i, 0, j), iblockstate, 4);
            world.setBlockState(pos.add(i + 1, 0, j), iblockstate, 4);
            world.setBlockState(pos.add(i, 0, j + 1), iblockstate, 4);
            world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate, 4);
        }
        else
        {
            world.setBlockState(pos, iblockstate, 4);
        }
        
        if (!gen.generate(world, rand, pos.add(i, 0, j)))
        {
            if (flag)
            {
                world.setBlockState(pos.add(i, 0, j), state, 4);
                world.setBlockState(pos.add(i + 1, 0, j), state, 4);
                world.setBlockState(pos.add(i, 0, j + 1), state, 4);
                world.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
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
	public int getItemEnchantibility() {
		return 0;
	}
	
	
	
	
	
	
}
