package edu.sjsu.cs151.tetris.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Model implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String filename = "GameSavedState.ser"; 
	private static String filename2 = "nextPieceQueue.ser"; 
	private static boolean gameSaved = false;
	private static User currentUser;
	private static Piece currentPiece;
	private static Queue<Piece> nextPieceQueue = new LinkedList<>();
	private static boolean gameLost = false;
	
	
	
	public Model(String name)
	{
		assert true : "In Model Constructor";
		User.loadUserList();//load previous users data
		assert true : "UserList Loaded";
		LoadState();
		assert true : "State Loaded";
		
		if(Model.gameSaved == true)
		{
			assert true : "Gamed Saved Before";
			currentUser = User.getCurrentUser();
			Grid.loadGrid();
			LoadNextQueue();
			
			
		}else
		{
			assert true : "New Game not saved before";
			currentUser = new User(name);
			new Grid();
			fillNextQueue();
		}
		
		new ScoreBoard();
	}
	
	public void checkLostCondition()
	{
		Block temp[] = 
		currentPiece.getBlockArray();

		for(int i = 0; i<4;i++)
		{
			if(temp[i].getXCoor()<2)
			{
				gameLost = true;
			}
		}
	}
	
	public boolean getLostCondition()
	{
		return gameLost;
	 
	}
	public Piece getCurrentPiece()
	{
		return currentPiece;
	}
	
	public void fillNextQueue()
	{
		currentPiece = RandomSingleton.getInstance().nextPiece();
		currentPiece.setVisible();
		while(nextPieceQueue.size()<3)
		{
			nextPieceQueue.add(RandomSingleton.getInstance().nextPiece());
		}
	}
	
	private void getNextPiece()
	{
		currentPiece = nextPieceQueue.remove();
		currentPiece.setVisible();
		nextPieceQueue.add(RandomSingleton.getInstance().nextPiece());
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	public void setFinalized()
	{
		this.checkLostCondition();
		checkLines();
		currentPiece.setFinalized();
		
		
		getNextPiece();
	}
	
	public void rotate()
	{
		currentPiece.setMoving();
		
		boolean locationLegal = true;
		boolean NormalRotate = true;
		
		
		if(currentPiece.getShap()==TerminoShape.SQUARE)
		{
			NormalRotate = false;
			currentPiece.rotate();
			
		}
		
		if(currentPiece.getShap()==TerminoShape.LINE)
		{
			NormalRotate = false;
			Block[] blocks = currentPiece.getBlockArray();
			
			switch(currentPiece.getLineStatus())
			{	
			
				case 0: 
				{
					if(!Grid.isLeagllAndEmpty(blocks[0].getXCoor()-1, blocks[0].getYCoor()+2))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[1].getXCoor(),blocks[1].getYCoor()))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[2].getXCoor()+1, blocks[2].getYCoor()))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[3].getXCoor()+2, blocks[3].getYCoor()-1))
					{
						locationLegal = false;
					}
					if(locationLegal)
					{
						Grid.removePieceFromGrid(currentPiece);
						currentPiece.rotate();
						currentPiece.setLineStatus(1);
					}
					
					break; 
				}
				case 1: 
				{

					if(!Grid.isLeagllAndEmpty(blocks[0].getXCoor()+2, blocks[0].getYCoor()+1))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[1].getXCoor()+1,blocks[1].getYCoor()))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[2].getXCoor(), blocks[2].getYCoor()-1))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[3].getXCoor()-1, blocks[3].getYCoor()-2))
					{
						locationLegal = false;
					}
					if(locationLegal)
					{
						Grid.removePieceFromGrid(currentPiece);
						currentPiece.rotate();
						currentPiece.setLineStatus(2);
					}
					
					break; 
				}
				case 2: 
				{
					if(!Grid.isLeagllAndEmpty(blocks[0].getXCoor()+1, blocks[0].getYCoor()-2))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[1].getXCoor(),blocks[1].getYCoor()-1))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[2].getXCoor()-1, blocks[2].getYCoor()))
					{
						locationLegal = false;
					}
					if(!Grid.isLeagllAndEmpty(blocks[3].getXCoor()-2, blocks[3].getYCoor()+1))
					{
						locationLegal = false;
					}
					if(locationLegal)
					{
						Grid.removePieceFromGrid(currentPiece);
						currentPiece.rotate();
						currentPiece.setLineStatus(3);
					}
					
					break; 
				}
				case 3: 
				{
				
						if(!Grid.isLeagllAndEmpty(blocks[0].getXCoor()-2, blocks[0].getYCoor()-1))
						{
							locationLegal = false;
						}
						if(!Grid.isLeagllAndEmpty(blocks[1].getXCoor()-1,blocks[1].getYCoor()))
						{
							locationLegal = false;
						}
						if(!Grid.isLeagllAndEmpty(blocks[2].getXCoor(), blocks[2].getYCoor()+1))
						{
							locationLegal = false;
						}
						if(!Grid.isLeagllAndEmpty(blocks[3].getXCoor()+1, blocks[3].getYCoor()+2))
						{
							locationLegal = false;
						}
						if(locationLegal)
						{
							Grid.removePieceFromGrid(currentPiece);
							currentPiece.rotate();
							currentPiece.setLineStatus(0);
						}
					
					break; 
				}
			
			
			}
			
			
		}
		
		if(NormalRotate)
		{
		
			int pivot = currentPiece.getPivot();
			Block[] blocks = currentPiece.getBlockArray();
			
			//t_x = x_p - y_p + y;
		    //t_y = y_p + x_p - x;
			
			int x_p = blocks[pivot].getXCoor();
			int y_p = blocks[pivot].getYCoor();
			
			
			for(int i = 0; i<4;i++)
			{
				int x = blocks[i].getXCoor();
				int y = blocks[i].getYCoor();
				
				int t_x = x_p - y_p + y;
				int t_y = y_p + x_p - x;
				if(!Grid.isLeagllAndEmpty(t_x,t_y))
				{
					locationLegal = false;
				};
			}
		
			
				if(locationLegal)
				{
					Grid.removePieceFromGrid(currentPiece);
					currentPiece.rotate();
				}
			}
		
		currentPiece.SetMoveToFalse();
		
	}
	
	public boolean drop()
	{
		currentPiece.setMoving();
		
		Block[] blocks = currentPiece.getBlockArray();
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor()+1, blocks[i].getYCoor()))
			{
				locationLegal = false;
			};
		}
		
		if(locationLegal)
		{
			Grid.removePieceFromGrid(currentPiece);
			currentPiece.drop();
		}
		
		currentPiece.SetMoveToFalse();
		
		return locationLegal;
		
	}
	
	
	public void moveLeft()
	{
		currentPiece.setMoving();
		Block[] blocks = currentPiece.getBlockArray();
	
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor(), blocks[i].getYCoor()-1))
			{
				locationLegal = false;
			};
		}
		if(locationLegal)
		{
			Grid.removePieceFromGrid(currentPiece);
			currentPiece.moveLeft();
		}
		
		currentPiece.SetMoveToFalse();
		
	}
	

	public void moveRight()
	{
		currentPiece.setMoving();
		Block[] blocks = currentPiece.getBlockArray();
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor(), blocks[i].getYCoor()+1))
			{
				locationLegal = false;
			};
		}
		if(locationLegal)
		{
			Grid.removePieceFromGrid(currentPiece);
			currentPiece.moveRight();
		}
		
		currentPiece.SetMoveToFalse();
	}
	
	private void checkLines()
	{
		//Line clear	Points
				//1 (single)	40
				//2 (double)	100
				//3 (triple)	300
				//4 (tetris)	1200
		int lineCleared = Grid.checkLines();
		switch(lineCleared)
		{
			case 0:
				break;
			case 1:
				currentUser.addScore(40);
				break;
			case 2:
				currentUser.addScore(40);
				break;
			case 3:
				currentUser.addScore(300);
				break;
			case 4:
				currentUser.addScore(1200);
				break;	
		}

	}
	
	
	public static void saveStateToFile()
    {
    	try
    	{    
    		FileOutputStream file = new FileOutputStream(filename); 
    		ObjectOutputStream out = new ObjectOutputStream(file); 
    		out.writeObject(gameSaved); 
    		out.close(); 
    		file.close(); 
    		System.out.println("Game State is Saved"); 

    	} 

    	catch(IOException ex) 
    	{ 
    		System.out.println("IOException is caught"); 
    	} 
    }
	
	public static void LoadState()
    {
   	
    	 try
         {    
             // Reading from the file 
             FileInputStream file = new FileInputStream(filename); 
             ObjectInputStream in = new ObjectInputStream(file); 
               
             // Read UserList File to user_list Array 
             gameSaved = (boolean)in.readObject(); 
               
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

	public static void saveNextQueue()
    {
    	try
    	{    
    		FileOutputStream file = new FileOutputStream(filename2); 
    		ObjectOutputStream out = new ObjectOutputStream(file); 
    		out.writeObject(nextPieceQueue); 
    		out.close(); 
    		file.close(); 
    		System.out.println("nextQueueSaved"); 

    	} 

    	catch(IOException ex) 
    	{ 
    		System.out.println("IOException is caught"); 
    	} 
    }
	
	public static void LoadNextQueue()
    {
   	
    	 try
         {    
             // Reading from the file 
             FileInputStream file = new FileInputStream(filename); 
             ObjectInputStream in = new ObjectInputStream(file); 
               
             // Read UserList File to user_list Array 
             nextPieceQueue = (Queue<Piece>)in.readObject(); 
               
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

	
	public void saveAndExit()
	{
		gameSaved = true;
		Grid.save();
		User.save();
		saveNextQueue();
		saveStateToFile();
	}
	
	
	///Just for test

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	Model test = new Model("gdsg");
	//	test.saveStateToFile();
	
//
	//}
	
	
	public void printBoard()
	{
		Grid.Print();
	}
	
	public void showSocoreBoard()
	{
		System.out.println(ScoreBoard.getScoreBoardMap().toString());
	}

}
