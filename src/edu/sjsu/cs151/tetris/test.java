package edu.sjsu.cs151.tetris;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JTextField;
import edu.sjsu.cs151.tetris.ui.Board;



public class test {
	
	public static int game = 0;
	
	 private class loop extends TimerTask 
	 { 
	 	public void run() 
	     { 
	 		game = Teteris.getGame();
	         
	     } 
	 } 
	 
	 public void startLoop()
	 {
		 Timer timer = new Timer(); 
		  timer.scheduleAtFixedRate(new loop(), 1, 16);
	 }
	
	 public static void main(String args[]) {
		 
		  Teteris test = new Teteris();
		  test.startTitle();
		  new test().startLoop();
		  
		  while(game == 0)
		  {
			  
		  }
		  System.out.println("run started");
		  
		  test.start();
		
		    }
	 
	
		}
