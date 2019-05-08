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
	
	
	 
	 
	 
	
	 public static void main(String args[]) {
		 
		  Teteris test = new Teteris();
		  
		  test.startGameTitle();
		  
		  
		  while(Teteris.gameStart==0)
		  {
			  System.out.println("not Yet");
		  }
		  
		  test.start();
		  
		
		    }
	 
	
		}
