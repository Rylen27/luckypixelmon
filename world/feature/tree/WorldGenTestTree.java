package com.Rylen27.luckypixelmon.world.feature.tree;

import java.util.Random;

import com.Rylen27.luckypixelmon.blocks.BlockLeaves1;
import com.Rylen27.luckypixelmon.blocks.BlockLog1;
import com.Rylen27.luckypixelmon.blocks.BlockSapling1;
import com.Rylen27.luckypixelmon.init.ModBlocks;
import com.Rylen27.luckypixelmon.util.handlers.EnumHandlerPlanks1;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTestTree extends WorldGenAbstractTree 
{
	public static final IBlockState LOG = ModBlocks.LOGS.getDefaultState().withProperty(BlockLog1.VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.TEST);
	public static final IBlockState LEAF = ModBlocks.LEAF.getDefaultState().withProperty(BlockLeaves1.VARIANT, EnumHandlerPlanks1.EnumTypePlanks1.TEST);
	
	private int minHeight;
	
	public WorldGenTestTree()
	{
		super(false);
		this.minHeight = 8;
		
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
		int height = this.minHeight + rand.nextInt(4);
		boolean flag = true;
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		for (int yPos = y; yPos <= y + 1 + height; yPos++)
		{
			int b0 = 2;
			if(yPos == y) b0 = 1;
			if(yPos >= y + 1 + height - 2) b0 = 2;
			
			BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
			
			for (int xPos = x -b0; xPos <= x + b0 && flag; xPos++)
			{
				for (int zPos = z - b0; zPos <= z + b0 && flag; zPos++)
				{
					if (yPos >= 0 && yPos < world.getHeight())
					{
						if (!this.isReplaceable(world, new BlockPos(xPos, yPos, zPos)))
						{
							flag = false;
						}
					}
					else 
					{
						flag = false;
					}
			
				}
			}
		}
		if (!flag)
		{
			return false;
		}
		else
		{
			BlockPos down = pos.down();
			IBlockState state = world.getBlockState(down);
			boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, (BlockSapling1)ModBlocks.SAPLINGS);
			
			if (isSoil && y < world.getHeight() - height - 1)
			{
				state.getBlock().onPlantGrow(state, world, down, pos);
				
				for (int yPos = y - 3 + height; yPos <= y + height; yPos++)
				{
					int b1 = yPos - (y + height);
					int b2 = 1 - b1 / 2;
					
					for (int xPos = x - b2; xPos <= x + b2; xPos++)
					{
						int b3 = xPos - x;
						for (int zPos = z - b2; zPos <= z + b2; zPos++)
						{
							int b4 = zPos - z;
							if (Math.abs(b3) != b2 || Math.abs(b4) != b2 || rand.nextInt(2) != 0 && b1 != 0)
							{
								BlockPos treePos = new BlockPos(xPos, yPos, zPos);
								IBlockState treeState = world.getBlockState(treePos);
								if (treeState.getBlock().isAir(treeState, world, treePos) || treeState.getBlock().isAir(treeState, world, treePos))
								{
									this.setBlockAndNotifyAdequately(world, treePos, LEAF);
									this.setBlockAndNotifyAdequately(world, treePos.add(1, -0.25 * height, 1), LEAF);
									this.setBlockAndNotifyAdequately(world, treePos.add(1, -0.5 * height, 1), LEAF);
								}
							}
						}
					}
				}
				
				for (int logHeight = 0; logHeight < height; logHeight++)
				{
					BlockPos up = pos.up(logHeight);
					IBlockState logState = world.getBlockState(up);
					
					if (logState.getBlock().isAir(logState, world, up) || logState.getBlock().isLeaves(logState, world, up))
					{
						this.setBlockAndNotifyAdequately(world, pos.up(logHeight), LOG);
					}
				}
				
				return true;
			}
		}
		
		return true;
	}

}
