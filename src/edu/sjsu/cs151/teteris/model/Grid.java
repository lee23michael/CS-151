package edu.sjsu.cs151.teteris.model;


/**
 * Represents the standard 10 by 20 Tetris grid as an array of 1s and 0s
 */
public class Grid {
	public static final int GRID_X_MAX = 10;
	public static final int GRID_Y_MAX = 20;
	private static Block[][] grid;

	public Grid(int[][] grid) {
		Grid.grid = new Block[GRID_X_MAX][GRID_Y_MAX];
	}
	
	//public void fillPosition(int x, int y) {
	//	grid[x][y] = 1;
	//}
	
	public static void addToGrid(int x, int y, Block b)
	{
		grid[x][y] = b;
	}
	
	public static void moveBlockOnGrid(int x, int y, int newX, int newY)
	{
		grid[newX][newY] = grid[x][y];
		grid[x][y] = null;
	}
	public static boolean isLeagllAndEmpty(int x,int y)
	{
		if(x>19||y>9||y<0)
		{
			return false;
		}else if(grid[x][y]==null)
		{
			return true;
		}else
			return false;
	
	}
	
	public static void checkLines()
	{
		int lineList[] = null;
		int counter;
		for(int x = 0; x<20; x++)
		{
			counter=0;
			for(int y = 0; y<20; y++)
			{
				if(grid[x][y]!=null)
				{
					counter ++;
				}
			}
			if(counter == 10)
			{
				lineList[x] = 1;
			}
		}
	}
	

}
