package edu.sjsu.cs151.tetris;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer; 
import java.util.TimerTask;

import edu.sjsu.cs151.tetris.model.Block;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.model.Piece;
import edu.sjsu.cs151.tetris.model.ScoreBoard;
import edu.sjsu.cs151.tetris.ui.Board;
import edu.sjsu.cs151.tetris.ui.GameOver;
import edu.sjsu.cs151.tetris.ui.MainMenu;
import edu.sjsu.cs151.tetris.ui.TitleScreen;
  
//Controller Class

public class Teteris 
{ 
	/*
	 */
	public static String name;
	public static Model model;
	private static int finalizedCounter;
	public static int gameStart = 0;
	//TestGame gameBoard =	new TestGame();
	
	public Teteris()
	{
		
		
	}
	
	public static void setName(String name)
	{
		Teteris.name = name;
		model = new Model(name);
	}
	
	public void start()
	{
		new Board();
		Timer timer = new Timer(); 
		gameStart = 0;
		model.setGameLost(false);
        timer.scheduleAtFixedRate(new TimerHelperDrop(), 1, 800);
        timer.scheduleAtFixedRate(new PrintHelper(), 200, 16);
        assert true : "Game Started";
        
        
	}
	
//	public static void main(String args[]) {
//		
//		model = new Model("xxsaw");
//		
//		
//		 Map<String,Integer> map = Teteris.getScoreBoardMap();
//	        
//	        String[][] array = new String[map.size()][2];
//	        int count = 0;
//	        for(Map.Entry<String,Integer> entry : map.entrySet()){
//	            array[count][0] = entry.getKey();
//	            array[count][1] = entry.getValue().toString();
//	            count++;
//	        }
//	        
//	        System.out.println(Arrays.deepToString(array));
//	}
	
	public void startGameTitle() {
		new TitleScreen().setVisible(true);
	}
	
	public static Queue<Piece> getNextQueue()
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
	
	public static void refreshScoreBoard() {
		new ScoreBoard();
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
    
    public static void exit()
    {
    	model.exit();
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
				System.out.print(model.getCurrentUser().getScore());
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
		}else if(gameStart==0)
		{
			
			gameStart = 2;
			Teteris.refreshScoreBoard();
			Board.frame.dispose();
			new GameOver();
			
		}
		
		
		
        
       
        
    } 
} 



}
  