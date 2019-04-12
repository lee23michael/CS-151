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
	
	public static int checkLines()
	{
		
		//Line clear	Points
		//1 (single)	40
		//2 (double)	100
		//3 (triple)	300
		//4 (tetris)	1200

		
		int counter;
		int lineCleared=0;

		for(int x = 0; x<20; x++)
		{
			counter=0;
			for(int y = 0; y<10; y++)
			{
				if(grid[x][y]!=null)
				{
					counter ++;
				}
			}
			if(counter == 10)
			{
				Grid.deleteLine(x);
				x = x-1; //check line x again becasue everthing went down one line
			}
		}
		
		return lineCleared;
		
	}
	
	public static void deleteLine(int x) {
		for(int i = 0; i<10; i++)
		{
			Grid.grid[x][i] = null;
		}
		for(int i = x+1; i<20; i++)
		{
			for(int j = 0;j<10;j++)
			{
				Grid.grid[i][j].setPostion(i-1, j);
			}
		}
		
	}
	

}
