package edu.sjsu.cs151.tetris;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import edu.sjsu.cs151.tetris.controller.Controller;
import edu.sjsu.cs151.tetris.message.*;
import edu.sjsu.cs151.tetris.ui.Board;



public class Game {
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	
	 
	 
	 
	
	 public static void main(String args[]) throws Exception {
		 
		  Controller gameController = new Controller();
		  try {
			  gameController.mainLoop();
			} catch (Exception e) {
				e.printStackTrace();
			}

		  
		
		    }
	 
	
		}
