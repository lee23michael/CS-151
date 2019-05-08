package edu.sjsu.cs151.tetris.model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents the standard 10 by 20 Tetris grid as an array of 1s and 0s
 */
public class Grid implements Serializable{
	public static final int GRID_X_MAX = 22;
	public static final int GRID_Y_MAX = 10; // extra first two is not visable
	private static Block[][] grid;
	private static final long serialVersionUID = 1L;
    private static String filename = "GIRD.ser"; 

	public Grid() {
		Grid.grid = new Block[GRID_X_MAX][GRID_Y_MAX];
	}
	
	//public void fillPosition(int x, int y) {
	//	grid[x][y] = 1;
	//}
	
	public static void addToGrid(int x, int y, Block b)
	{
		grid[x][y] = b;
	}
	
	public static void addPieceToGrid(Piece p)
	{
		for(int i=0;i<4;i++)
		{
			addToGrid(p.getBlock(i).getXCoor(),p.getBlock(i).getYCoor(),p.getBlock(i));
		}
	}

	
	public static void removePieceFromGrid(Piece p) {
		
		for(int i=0;i<4;i++)
		{
			grid[p.getBlock(i).getXCoor()][p.getBlock(i).getYCoor()] = null;
		}
	}
	
	public static void moveBlockOnGrid(int x, int y, int newX, int newY)
	{
		grid[newX][newY] = grid[x][y];
		grid[x][y] = null;
	}
	
	
	public static boolean isLeagllAndEmpty(int x,int y)
	{
		if(x>21||y>9||y<0)
		{
			return false;
		}else if(x<2||grid[x][y]==null||grid[x][y].getMovingStatus())//ignore first two lines of board, invisible
		{
			return true;
		}else
			return false;
	
	}
	
	
	
	
	 public static void save()
     {
    	
     	try
     	{    
     		FileOutputStream file = new FileOutputStream(filename); 
     		ObjectOutputStream out = new ObjectOutputStream(file); 
     		out.writeObject(grid); 
     		out.close(); 
     		file.close(); 
     		System.out.println("Grid Saved"); 

     	} 

     	catch(IOException ex) 
     	{ 
     		System.out.println("IOException is caught"); 
     	} 
     }
	 
	 public static void loadGrid()
     {
		 Grid.grid = new Block[GRID_X_MAX][GRID_Y_MAX];

  
     	 try
          {    
              // Reading from the file 
              FileInputStream file = new FileInputStream(filename); 
              ObjectInputStream in = new ObjectInputStream(file); 
                
              // Read UserList File to user_list Array 
              Grid.grid = (Block[][])in.readObject(); 
                
              in.close(); 
              file.close(); 
              System.out.println("Object has been deserialized "); 
              
          } 
            
          catch(IOException ex) 
          { 
              System.out.println("IOException is caught"); 
          } 
            
          catch(ClassNotFoundException ex) 
          { 
              System.out.println("ClassNotFoundException is caught"); 
          } 
     }
	 
	 
	 
	
	public static int checkLines()
	{
		
		
		int counter;
		int lineCleared=0;

		for(int x = 21; x>2; x--)
		{
			counter=0;//if counter goes to 10 means the line is filled
			for(int y = 0; y<10; y++)
			{
				if(grid[x][y]!=null)
				{
					counter ++;
				}
			}
			if(counter == 10)
			{
				lineCleared++;
				Grid.deleteLine(x);
				x = x+1; //check line x again becasue everthing went down one line
			}
		}
	
		return lineCleared;
		
	}
	
	private static void deleteLine(int x) {
		for(int j = 0; j<10; j++)
		{
			Grid.grid[x][j] = null;
		}
		for(int i = x-1; i>1; i--)
		{
			for(int j = 0;j<10;j++)
			{
				
			if(Grid.grid[i][j]!=null)
			{
				Grid.grid[i][j].setPostion(i+1, j);
				Grid.grid[i][j] = null;
			}
				
			}
		}
		
	}
	
	public static Block[][] getGrids()
	{
		return grid;
	}
	
	public static void Print()
	{
		
		for(int x = 0; x<22; x++)
		{
			for(int y = 0; y<10; y++)
			{
				if(grid[x][y]!=null)
				{
					System.out.print("O");
				} else 
				{
					System.out.print("+");
				}
				
			}
			System.out.println("");
			
		}
		
	}
	

}
	


