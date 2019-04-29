package edu.sjsu.cs151.teteris.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
	private static Queue<Piece> nextPieceQueue;
	
	
	
	public Model(String name)
	{
		User.loadUserList();//load previous users data
		LoadState();
		if(Model.gameSaved == true)
		{
			currentUser = User.getCurrentUser();
			Grid.loadGrid();
			LoadNextQueue();
			
			
		}else
		{
			currentUser = new User(name);
			new Grid();
		}
		
		new ScoreBoard();
	}
	
	public Piece getCurrentPiece()
	{
		return currentPiece;
	}
	
	public User getCurrentUser()
	{
		return currentUser;
	}
	
	public void rotate()
	{
		boolean locationLegal = true;
		int pivot = currentPiece.getPivot();
		Block[] blocks = currentPiece.getBlockArray();
		
		for(int i = 0; i<4;i++)
		{
			int t_x = blocks[i].getXCoor()-blocks[pivot].getXCoor();
			int t_y = blocks[i].getYCoor()-blocks[pivot].getYCoor();
			blocks[i].setPostion(-t_y+blocks[pivot].getXCoor(), t_x+blocks[pivot].getYCoor());
			
			if(!Grid.isLeagllAndEmpty(-t_y+blocks[pivot].getXCoor(), t_x+blocks[pivot].getYCoor()))
			{
				locationLegal = false;
			};
		}
		
		if(locationLegal)
		{
			currentPiece.rotate();
		}
		
	}
	
	public boolean drop()
	{
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
			currentPiece.drop();
		}
		
		return locationLegal;
		
	}
	
	public void moveLeft()
	{
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
			currentPiece.moveLeft();
		}
		
	}
	

	public void moveRight()
	{
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
			currentPiece.moveRight();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model test = new Model("gdsg");
		test.saveStateToFile();
	

	}
	
	public void showSocoreBoard()
	{
		System.out.println(ScoreBoard.getScoreBoardMap().toString());
	}

}
