package edu.sjsu.cs151.tetris.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.sjsu.cs151.tetris.Teteris;
import edu.sjsu.cs151.tetris.model.Block;
public class Board {
	static JPanel panel = new TestGamePanel();
	static JFrame frame = new JFrame("Border Layout");

	public static void update(Block[][] g)
    {
		//nextQueueArray = Teteris.getNextQueue();
    	frame.remove(panel);
    	panel = new TestGamePanel(g);
    	frame.getContentPane().add(panel, BorderLayout.CENTER);
    	//frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
	
	public Board()
	{
		
		JButton button,button1, button3,button4;
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_3 = new JPanel();
		
		panel_1.setPreferredSize(new Dimension(200,200));
		panel_2.setPreferredSize(new Dimension(200,200));
		panel_3.setPreferredSize(new Dimension(200,200));
		
		frame.getContentPane().add(panel_1,BorderLayout.WEST);
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
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
     		       case KeyEvent.VK_SPACE :
    		        	{
    		        		while(Teteris.drop())
    		        		{
    		        			
    		        		}
    		        	}
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
		
	
		
		
		frame.setSize(934,936);  
		frame.setVisible(true);  
	}
	
	
	
	public  static void main(String[] args)
	{
		new Board();
	}
}
