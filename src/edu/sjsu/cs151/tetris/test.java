package edu.sjsu.cs151.tetris;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class test {
	
	 public static void main(String args[]) {
		 
		 
		 
		  JFrame frame = new JFrame("Key Listener");
		 
		  Container contentPane = frame.getContentPane();
		  Teteris test = new Teteris();
	        
	      test.start();
		 
	      KeyListener listener = new KeyListener() {
	
	
		 
		@Override
		 
		public void keyPressed(KeyEvent event) {
		 
			int keyCode = event.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            test.rotate();
		            break;
		        case KeyEvent.VK_DOWN:
		        	test.drop(); 
		            break;
		        case KeyEvent.VK_LEFT:
		            test.moveLeft();
		            break;
		        case KeyEvent.VK_RIGHT :
		            test.moveRight();
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

		
		
		 
		  JTextField textField = new JTextField();
		 
		  textField.addKeyListener(listener);
		 
		  contentPane.add(textField, BorderLayout.NORTH);
		 
		  frame.pack();
		 
		  frame.setVisible(true);
		  
		  
		    }
		}


