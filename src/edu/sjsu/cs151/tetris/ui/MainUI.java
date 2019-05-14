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
 * Represents the Main UI class of the game.
 */
public class MainUI {
	
	private static boolean boardstatus = false;
    /**
     * Gets the boolean variable hideTutorial.
     * @return A true if the tutorial should be hidden, false otherwise.
     */
    public static boolean getHideTutorial() {
        return hideTutorial;
    }
    /**
     * Toggles the boolean hideTutorial variable to be the opposite of what it is set to be.
     */
    public static void setHideTutorial() {
        hideTutorial = !hideTutorial;
    }
 
    /**
     * Creates a new MainUI that displays the TitleScreen.
     */
    public MainUI()
    {
    	TitleScreen t = new TitleScreen();
        t.setVisible(true);
    }
    /**
     * Creates a new Board and saves it to the board field.
     */
    public static void startGame()
    {	
    	if(!boardstatus)
    	{
    		board = new Board();
    		boardstatus = true;
    	}
    	else
    	{
    		Board.frame.setVisible(true);
    	}
    }
    /**
     * Makes a new HighScores screen with the given list of users and sets visibility to true.
     * @param list List of users.
     */
    public static void oHighscores(ArrayList<User> list)
    {
    	new Highscores(list).setVisible(true);
    }
    
    /**
     * Displays the GameOver screen.
     */
    public static void gameOver()
    {	 
    	Board.frame.setVisible(false);
    	new GameOver();
    }
    
    private static boolean hideTutorial;
    private static Board board;
	
}
