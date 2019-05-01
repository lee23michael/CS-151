package edu.sjsu.cs151.tetris;

import java.util.Timer; 
import java.util.TimerTask;

import edu.sjsu.cs151.tetris.model.Model; 
  
//Controller Class

public class Teteris 
{ 
	public String name = "ExampleName";
	public Model model;
	private static int finalizedCounter;
	
	public Teteris()
	{
		model = new Model(name);
		
	}
	
	public void start()
	{
		Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(new TimerHelperDrop(), 300, 800);
        timer.scheduleAtFixedRate(new PrintHelper(), 1, 16);
        assert true : "Game Started";
        
        
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
	
	

    
    public void moveLeft() {
    	model.moveLeft();
    }
    
    public void moveRight() {
    	model.moveRight();
    }
    
    public void rotate() {
    	model.rotate();
    }
    public void drop() {
    	model.drop();
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
		
		model.printBoard();
		System.out.println(" ------------------- ");
		System.out.println(" ------------------- ");
		}
        
       
        
    } 
} 



}
  