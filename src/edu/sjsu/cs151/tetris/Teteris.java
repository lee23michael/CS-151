package edu.sjsu.cs151.tetris;

import java.util.Map;
import java.util.Timer; 
import java.util.TimerTask;

import edu.sjsu.cs151.tetris.model.Block;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.model.Piece;
import edu.sjsu.cs151.tetris.model.ScoreBoard;
import edu.sjsu.cs151.tetris.ui.Board;
import edu.sjsu.cs151.tetris.ui.Game;
  
//Controller Class

public class Teteris 
{ 
	public String name = "ExampleName";
	public static Model model;
	private static int finalizedCounter;
	//TestGame gameBoard =	new TestGame();
	
	public Teteris()
	{
		model = new Model(name);
		
	}
	
	public void start()
	{
		new Board();
		Timer timer = new Timer(); 
		
        timer.scheduleAtFixedRate(new TimerHelperDrop(), 300, 800);
        timer.scheduleAtFixedRate(new PrintHelper(), 1, 16);
        assert true : "Game Started";
        
        
	}
	
	public static Piece[] getNextQueue()
	{
		return model.getNextQueue();
	}
	
	public static Map<String,Integer> getScoreBoardMap()
	{
		return Model.getScoreBoardMap();
		
	}
	
	
	public static int getFinalizedCounter () {
		return finalizedCounter;
	}
	
	public static void FinalizedCounterPlus() {
		
		finalizedCounter++;
	}
	
	public static void FinalizedCounterReset() {
		
		finalizedCounter = 0;
	}
	
	

    
    public static void moveLeft() {
    	model.moveLeft();
    }
    
    public static void moveRight() {
    	model.moveRight();
    }
    
    public static void rotate() {
    	model.rotate();
    }
    public static boolean drop() {
    	return model.drop();
    }


private class TimerHelperDrop extends TimerTask 
{ 
	public void run() 
    { 
		
		if(!model.getLostCondition())
		{
		
			if(model.drop()||Teteris.getFinalizedCounter()<3)
			{
				Teteris.FinalizedCounterPlus(); //hold three drops till a piece finalize
			}
			else
			{
				model.setFinalized();
				
				Teteris.FinalizedCounterReset();
			}
		}
        
       
        
    } 
} 


private class PrintHelper extends TimerTask 
{ 
	public void run() 
    { 
		if(!model.getLostCondition())
		{
//		
//		model.printBoard();
//		System.out.println(" ------------------- ");
//		System.out.println(" ------------------- ");
			Board.update(model.getGrid());
		}
        
       
        
    } 
} 



}
  