package edu.sjsu.cs151.tetris.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer; 
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import edu.sjsu.cs151.tetris.message.*;
import edu.sjsu.cs151.tetris.model.Block;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.model.Piece;
//import edu.sjsu.cs151.tetris.model.ScoreBoard;
import edu.sjsu.cs151.tetris.model.User;
import edu.sjsu.cs151.tetris.ui.Board;
import edu.sjsu.cs151.tetris.ui.GameOver;
import edu.sjsu.cs151.tetris.ui.MainMenu;
import edu.sjsu.cs151.tetris.ui.MainUI;
import edu.sjsu.cs151.tetris.ui.TitleScreen;
  
//Controller Class
/**
 * The Controller class for our game.
 */
public class Controller 
{ 
	/*
	 */
	public static String name;
	public static Model model;
	public static MainUI ui;
	public static GameInfo gameInfo;
	public static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static int finalizedCounter;
	private List<Valve> valves = new LinkedList<Valve>();

	
	public Controller()
	{
		ui = new MainUI();
		gameInfo = new GameInfo();
		valves.add(new NewGameValve());
		valves.add(new GameOverValve());
		valves.add(new UpKeyValve());
		valves.add(new DownKeyValve());
		valves.add(new SpaceKeyValve());
		valves.add(new LeftKeyValve());
		valves.add(new RightKeyValve());
		valves.add(new EscapeKeyValve());
		valves.add(new ScoreValve());
		Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(new TimerHelperDrop(), 1, 800);
        timer.scheduleAtFixedRate(new PrintHelper(), 200, 16);
        
	}
	
	public static void setName(String name)
	{
		Controller.name = name;
		model = new Model(name);
		GameInfo.setUserNameEntered(true);
		
	}
	
	
	public void mainLoop() throws Exception {
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while (response != ValveResponse.FINISH) {
			try {
				message = (Message) queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Valve valve : valves) {
				response = valve.execute(message);
				if (response != ValveResponse.MISS)
					break;
			}
		}

	}
	
	private class NewGameValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != NewGameMessage.class) {
				return ValveResponse.MISS;
			}
			queue.clear();
			model.resetGame();
			gameInfo = new GameInfo();
			System.out.print("game start message");
			Controller.start();
			return ValveResponse.EXECUTED;
		}
	}
	
	private class GameOverValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != GameOverMessage.class) {
				return ValveResponse.MISS;
			}
			MainUI.gameOver();
			return ValveResponse.EXECUTED;
		}
	}
	private class ScoreValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != ScoreMessage.class) {
				return ValveResponse.MISS;
			}
			//TO-DO
			System.out.println("score board message trigged"+model.getCurrentUser().getUserList().size());
			for(User c: User.getUserList()){
	        	System.out.println();
	        	System.out.println("score board opened");
	        	 System.out.println(c.getName());
	        	}
			MainUI.oHighscores(User.getUserList());
			
			return ValveResponse.EXECUTED;
		}
	}
	
	private class UpKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != UpKeyMessage.class) {
				return ValveResponse.MISS;
			}
			model.rotate();
			return ValveResponse.EXECUTED;
		}
	}
	
	private class DownKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != DownKeyMessage.class) {
				return ValveResponse.MISS;
			}
			model.drop();
			return ValveResponse.EXECUTED;
		}
	}
	
	private class LeftKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != LeftKeyMessage.class) {
				return ValveResponse.MISS;
			}
			model.moveLeft();
			return ValveResponse.EXECUTED;
		}
	}
	private class RightKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != RightKeyMessage.class) {
				return ValveResponse.MISS;
			}
			model.moveRight();
			return ValveResponse.EXECUTED;
		}
	}
	private class SpaceKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != SpaceKeyMessage.class) {
				return ValveResponse.MISS;
			}
			Controller.HardDrop();
			return ValveResponse.EXECUTED;
		}
	}
	
	private class EscapeKeyValve implements Valve {
		@Override
		public ValveResponse execute(Message message) {
			if (message.getClass() != EscapeKeyMessage.class) {
				return ValveResponse.MISS;
			}
			model.setGameLost(true);
			return ValveResponse.EXECUTED;
		}
	}
	
	
	
	
	public static void start()
	{
		MainUI.startGame();
		Model.setGameLost(false);
		
        
	}
	

	public static Queue<Piece> getNextQueue()
	{
		return model.getNextQueue();
	}
	
//	public static Map<String,Integer> getScoreBoardMap()
//	{
//		return Model.getScoreBoardMap();
//		
//	}
	
	
	public static int getFinalizedCounter () {
		return finalizedCounter;
	}
	
	public static void FinalizedCounterPlus() {
		
		finalizedCounter++;
	}
	
	public static void FinalizedCounterReset() {
		
		finalizedCounter = 0;
	}
	
//	public static void refreshScoreBoard() {
//		new ScoreBoard();
//	}
	
	

    
//    public static void moveLeft() {
//    	model.moveLeft();
//    }
//    
//    public static void moveRight() {
//    	model.moveRight();
//    }
//    
//    public static void rotate() {
//    	model.rotate();
//    }
	
	
 private static void HardDrop() {

  	while (model.drop())
  	{
  		
  	}
  	
  	
  	
  }
 

public class TimerHelperDrop extends TimerTask 
{ 
	public void run() 
    { 
		if(GameInfo.getGamePage()==4)
		{
		
		if(!model.getLostCondition())
		{
		
			if(model.drop()||Controller.getFinalizedCounter()<3)
			{
				Controller.FinalizedCounterPlus(); //hold three drops till a piece finalize
				System.out.print(model.getCurrentUser().getScore());
			}
			else
			{
				try {
					model.setFinalized();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Controller.FinalizedCounterReset();
			}
		}
        
       
        
    } 
    }
} 


public class PrintHelper extends TimerTask 
{ 
	public void run() 
    { 
		if(GameInfo.getGamePage()==4)
		{
		if(!model.getLostCondition())
		{
			Board.update(model.getGrid());
			Board.setScore(model.getCurrentUser().getScore());
		}else if(GameInfo.isGameLost())
		{
			try {
				queue.put(new GameOverMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
      
    } 
    }
} 



}
  