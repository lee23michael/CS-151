/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sjsu.cs151.tetris.ui;

import java.awt.event.KeyEvent;

/**
 *
 * @author David
 */
public class KeyListener {
    
    
		 
		public void keyPressed(KeyEvent event) {
		 
			int keyCode = event.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            //test.rotate();
		            break;
		        case KeyEvent.VK_DOWN:
		        	//test.drop(); 
		            break;
		        case KeyEvent.VK_LEFT:
		            //test.moveLeft();
		            break;
		        case KeyEvent.VK_RIGHT :
		            //test.moveRight();
		            break;
                        case KeyEvent.VK_ESCAPE:
                            System.out.print("xx");
                            new Login().setVisible(true);
                            break;
		     }
		 
		}

		
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
