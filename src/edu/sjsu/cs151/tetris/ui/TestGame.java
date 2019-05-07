package edu.sjsu.cs151.tetris.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import edu.sjsu.cs151.tetris.Teteris;
import edu.sjsu.cs151.tetris.model.Block;
import edu.sjsu.cs151.tetris.model.Piece;

public class TestGame {
	static JFrame frame = new JFrame("Testing");
	static JPanel panel = new TestGamePanel();
	static Piece[] nextQueueArray;
	
	 public static void main(String args[]) {
	 
		
	 }
	 
	
	 public static void update(Block[][] g)
     {
		//nextQueueArray = Teteris.getNextQueue();
     	frame.remove(panel);
     	panel = new TestGamePanel(g);
     	frame.add(panel);
     	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
     }

  
    public TestGame() {
    	
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                KeyListener listener = new KeyListener() {
                	
                	
           		 
            		@Override
            		 
            		public void keyPressed(KeyEvent event) {
            		 
            			int keyCode = event.getKeyCode();
            		    switch( keyCode ) { 
            		        case KeyEvent.VK_UP:	
            		            Teteris.rotate();
            		            break;
            		        case KeyEvent.VK_DOWN:
            		        	Teteris.drop(); 
            		            break;
            		        case KeyEvent.VK_LEFT:
            		        	Teteris.moveLeft();
            		            break;
            		        case KeyEvent.VK_RIGHT :
            		        	Teteris.moveRight();
            		            break;
            		     }
            		 
            		}

            		@Override
            		public void keyTyped(KeyEvent e) {
            			// TODO Auto-generated method stub
            			
            		}

            		@Override
            		public void keyReleased(KeyEvent e) {
            			// TODO Auto-generated method stub
            			
            		}
            };

                frame.addKeyListener(listener);
            }
}
        
        
    

    