package edu.sjsu.cs151.tetris.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import edu.sjsu.cs151.tetris.controller.Controller;
import edu.sjsu.cs151.tetris.controller.GameInfo;
import edu.sjsu.cs151.tetris.message.*;
import edu.sjsu.cs151.tetris.model.Block;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
public class Board {
	static JPanel grid_panel = new TestGamePanel();
	static JPanel scoreNlevel_panel = new JPanel();
	static JPanel hold_panel = new JPanel();
	public static JFrame frame = new JFrame("Border Layout");
	private static String score = "0";

	
	public static void setScore(int x)
	{
		score = String.valueOf(x);
	}
	
	public Board()
	{
		frame.setBackground(Color.black);
		
		GameInfo.setGamePage(4);
		frame.setResizable(false);
		
		JPanel tutorial_panel = new JPanel();
		tutorial_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		
		JLabel lable1 = new JLabel();
		JLabel lable2 = new JLabel();
		JLabel lable3 = new JLabel();
		JLabel lable4 = new JLabel();
		JLabel lable5 = new JLabel();
		JLabel lable6 = new JLabel();
		JLabel lable7 = new JLabel();
		JLabel lable8 = new JLabel();
		JLabel lable9 = new JLabel();
		JLabel lable10 = new JLabel();
		JLabel lable11 = new JLabel();
		JLabel lable12 = new JLabel();
		JLabel lable13 = new JLabel();
		JLabel lable14 = new JLabel();
		
		
		lable1.setText("Level:");
		lable2.setText("Score:");
		lable3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lable3.setText("Controls");
		lable4.setFont(new Font("Tahoma", 0, 13));
		lable4.setText("Rotate");
		lable5.setText("Up Arrow = Rotate");
		lable6.setText("L/R Arrows = Move L/R");
		lable7.setText("Down Arrow = Soft Drop");
		lable9.setFont(new Font("Tahoma", 0, 13));
		lable9.setText("Basic Scoring");
		lable8.setText("Spacebar = Hard Drop");
		lable10.setText("1 Line Clear = 100 x Level");
		lable11.setText("2 Line Clear = 300 x Level");
		lable12.setText("3 Line Clear = 500 x Level ");
		lable13.setText("Tetris (4 line) = 800 x Level");
		lable14.setText("Tutorial");
		lable14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		
		
JLabel label = new JLabel("");
		
		JLabel lblBasicScoring = new JLabel("Basic scoring");
		lblBasicScoring.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblUpArrow = new JLabel("Up Arrow = Rotate");
		lblUpArrow.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblLrArrows = new JLabel("L/R Arrows = Move L/R");
		lblLrArrows.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblDownArrow = new JLabel("Down Arrow = Soft Drop");
		lblDownArrow.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblSpacebarHard = new JLabel("Spacebar = Hard Drop");
		lblSpacebarHard.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblLineClear = new JLabel("1 Line Clear = 40");
		lblLineClear.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblLineClear_1 = new JLabel("2 Line Clear =100");
		lblLineClear_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblLineClear_2 = new JLabel("3 Line Clear = 300  ");
		lblLineClear_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblTetrisLine = new JLabel("Tetris (4 line) = 1200");
		lblTetrisLine.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GroupLayout gl_tutorial_panel = (new GroupLayout(tutorial_panel));
		gl_tutorial_panel.setHorizontalGroup(
			gl_tutorial_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tutorial_panel.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_tutorial_panel.createSequentialGroup()
							.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLrArrows)
								.addComponent(lblDownArrow, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUpArrow)
								.addComponent(lblSpacebarHard))
							.addGap(9))
						.addGroup(gl_tutorial_panel.createSequentialGroup()
							.addComponent(lable3)
							.addGap(164)))
					.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_tutorial_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lable14)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_tutorial_panel.createSequentialGroup()
									.addGap(309)
									.addComponent(label))
								.addGroup(gl_tutorial_panel.createSequentialGroup()
									.addGap(174)
									.addComponent(lblBasicScoring)))
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_tutorial_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
							.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLineClear_1)
								.addComponent(lblLineClear)
								.addComponent(lblLineClear_2)
								.addComponent(lblTetrisLine))
							.addGap(57))))
		);
		gl_tutorial_panel.setVerticalGroup(
			gl_tutorial_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tutorial_panel.createSequentialGroup()
					.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBasicScoring)
						.addComponent(lable3)
						.addComponent(lable14))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tutorial_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_tutorial_panel.createSequentialGroup()
							.addComponent(lblUpArrow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLrArrows)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDownArrow, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSpacebarHard))
						.addGroup(gl_tutorial_panel.createSequentialGroup()
							.addComponent(lblLineClear)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLineClear_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLineClear_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTetrisLine)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
        tutorial_panel.setLayout(gl_tutorial_panel);

            
        
        
        //editing 
        
        
		

        
		scoreNlevel_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		hold_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		frame.getContentPane().add(scoreNlevel_panel,BorderLayout.WEST);
		
		JLabel lblScore = new JLabel("Score ");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel label_1 = new JLabel(score);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_scoreNlevel_panel = new GroupLayout(scoreNlevel_panel);
		gl_scoreNlevel_panel.setHorizontalGroup(
			gl_scoreNlevel_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoreNlevel_panel.createSequentialGroup()
					.addGroup(gl_scoreNlevel_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_scoreNlevel_panel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblScore))
						.addGroup(gl_scoreNlevel_panel.createSequentialGroup()
							.addGap(83)
							.addComponent(label_1)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_scoreNlevel_panel.setVerticalGroup(
			gl_scoreNlevel_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_scoreNlevel_panel.createSequentialGroup()
					.addGap(167)
					.addComponent(lblScore)
					.addGap(18)
					.addComponent(label_1)
					.addContainerGap(479, Short.MAX_VALUE))
		);
		scoreNlevel_panel.setLayout(gl_scoreNlevel_panel);
		
		
		JPanel hold1 = new JPanel();
		hold1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel hold2 = new JPanel();
		hold2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel hold3 = new JPanel();
		hold3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout gl_hold_panel = new GroupLayout(hold_panel);
		gl_hold_panel.setHorizontalGroup(
			gl_hold_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hold_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_hold_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(hold3, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(hold2, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(hold1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_hold_panel.setVerticalGroup(
			gl_hold_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_hold_panel.createSequentialGroup()
					.addGap(94)
					.addComponent(hold1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(hold2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(hold3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		hold_panel.setLayout(gl_hold_panel);
		
		
		
		
        //hold_panel.setLayout(gl_hold_panel);
		
		frame.getContentPane().add(tutorial_panel, BorderLayout.SOUTH);
		grid_panel.setForeground(Color.WHITE);
		frame.getContentPane().add(grid_panel, BorderLayout.CENTER);
		grid_panel.setBackground(Color.WHITE);
		grid_panel.setPreferredSize(new Dimension(300, 300));
		grid_panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		
		frame.getContentPane().add(scoreNlevel_panel,BorderLayout.WEST);
    	frame.getContentPane().add(hold_panel, BorderLayout.EAST);
		
		////
		
		 KeyListener listener = new KeyListener() {
         	
         	//board Need to be update from below
       		 
     		@Override
     		 
     		public void keyPressed(KeyEvent event) {
     		 
     			int keyCode = event.getKeyCode();
     		    switch( keyCode ) { 
     		        case KeyEvent.VK_UP:	
     		            Controller.queue.add(new UpKeyMessage());
     		            break;
     		        case KeyEvent.VK_DOWN:
     		        	Controller.queue.add(new DownKeyMessage());
     		            break;
     		        case KeyEvent.VK_LEFT:
     		        	Controller.queue.add(new LeftKeyMessage());
     		            break;
     		        case KeyEvent.VK_RIGHT :
     		        	Controller.queue.add(new RightKeyMessage());
     		            break;
     		       case KeyEvent.VK_SPACE :
    		        	{
    		        		Controller.queue.add(new SpaceKeyMessage());
    		        	}
    		            break;
     		       case KeyEvent.VK_ESCAPE:
     		       {
     		    	   frame.setVisible(false);
     		    	  //frame.dispose();
     		    	  Controller.queue.add(new EscapeKeyMessage());
     		    	 Controller.queue.add(new GameOverMessage());
     		    	
     		    	  break;
     		       }
     		    	   
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
		
	
		
		
		frame.setSize(937,908);  
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);  
		
		
		

		//board changes ends here

		
		
	}
	
	public static void update(Block[][] g)
    {
		//nextQueueArray = Teteris.getNextQueue();
    	frame.remove(grid_panel);
    	frame.remove(scoreNlevel_panel);
    	
    	
    	
    	//
    	
    	//
    	grid_panel = new TestGamePanel(g);
    	scoreNlevel_panel = new ScorePanel(score);
    	
    	
    	
    	frame.getContentPane().add(grid_panel, BorderLayout.CENTER);
    	frame.getContentPane().add(scoreNlevel_panel,BorderLayout.WEST);
    	
    	
    	
    	//frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
	
	
	
	
	public  static void main(String[] args)
	{
		new Board();
	}
}