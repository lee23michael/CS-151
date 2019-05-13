/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sjsu.cs151.tetris.ui;

/**
 *
 * @author David
 */
public class Main {

    public static boolean getHideTutorial() {
        return hideTutorial;
    }
    public static void setHideTutorial() {
        hideTutorial = !hideTutorial;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TitleScreen t = new TitleScreen();
        t.setVisible(true);
    }
    
    private static boolean hideTutorial;
    
}
