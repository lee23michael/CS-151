/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sjsu.cs151.tetris.ui;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.tetris.message.Message;
import edu.sjsu.cs151.tetris.model.User;


/**
 *
 * @author David
 */


public class MainUI {
	private static Board board;
	private static boolean reset = false;
	

    public static boolean getHideTutorial() {
        return hideTutorial;
    }
    public static void setHideTutorial() {
        hideTutorial = !hideTutorial;
    }
    /**
     * @param args the command line arguments
     */
 
    
    public MainUI()
    {
    	TitleScreen t = new TitleScreen();
        t.setVisible(true);
    }
    
    public static void startGame()
    {
    	if(!reset)
    	{
    	board = new Board();
    	reset = true;
    	}
    	else
    	{
    		board.frame.setVisible(true);
    	}
    }
    
    
    public static void oHighscores(ArrayList<User> list)
    {
    	new Highscores(list).setVisible(true);
    }
    
    public static void gameOver()
    {	 
    	Board.frame.setVisible(false);;
    	new GameOver();
    }
    
    private static boolean hideTutorial;
    
}
