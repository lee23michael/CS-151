package edu.sjsu.cs151.tetris.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import edu.sjsu.cs151.tetris.Teteris;
import edu.sjsu.cs151.tetris.model.Block;
import edu.sjsu.cs151.tetris.model.Piece;
import edu.sjsu.cs151.tetris.model.TerminoShape;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.Component;
public class Board {
	static JPanel panel = new TestGamePanel();
	static JPanel next_panel = new JPanel();
	static JFrame frame = new JFrame("Border Layout");
	static JPanel panel_1 = new JPanel();

	public static void update(Block[][] g,Queue<Piece> q,int score)
    {
		//nextQueueArray = Teteris.getNextQueue();
		JLabel imgLabel = new JLabel(Board.getImage(q.peek()));
		next_panel.remove(imgLabel);
		next_panel.add(imgLabel);
		
		panel_1.removeAll();
		JTextPane txtpnScore = new JTextPane();
		txtpnScore.setText("Score:");
		JTextPane textPane = new JTextPane();
		textPane.setText(Integer.toString(score));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(57)
							.addComponent(txtpnScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(149)
					.addComponent(txtpnScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
    	frame.remove(panel);
    	panel = new TestGamePanel(g);
    	frame.getContentPane().add(panel, BorderLayout.CENTER);
    	//frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
	
	public Board()
	{
		
		
		
		
		JPanel panel_3 = new JPanel();
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
		JLabel lable15 = new JLabel();
		
		
		lable1.setText("Level:");
		lable2.setText("Score:");
		lable3.setFont(new Font("Tahoma", 0, 13));
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
		
		next_panel.add(new JLabel(new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/Line.jpg")));
		
		
		panel_1.setPreferredSize(new Dimension(200,200));
		next_panel.setPreferredSize(new Dimension(200,200));
		panel_3.setPreferredSize(new Dimension(200,200));
		
		JLabel label = new JLabel("");
		
		JLabel lblBasicScoring = new JLabel("Basic scoring");
		lblBasicScoring.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblUpArrow = new JLabel("Up Arrow = Rotate");
		lblUpArrow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLrArrows = new JLabel("L/R Arrows = Move L/R");
		lblLrArrows.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDownArrow = new JLabel("Down Arrow = Soft Drop");
		lblDownArrow.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblSpacebarHard = new JLabel("Spacebar = Hard Drop");
		lblSpacebarHard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLineClear = new JLabel("1 Line Clear = 40");
		lblLineClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLineClear_1 = new JLabel("2 Line Clear =100");
		lblLineClear_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLineClear_2 = new JLabel("3 Line Clear = 300  ");
		lblLineClear_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTetrisLine = new JLabel("Tetris (4 line) = 1200");
		lblTetrisLine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout panel3Layout = (new GroupLayout(panel_3));
		panel3Layout.setHorizontalGroup(
			panel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panel3Layout.createSequentialGroup()
					.addGap(183)
					.addGroup(panel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, panel3Layout.createSequentialGroup()
							.addGap(12)
							.addComponent(lable3)
							.addGap(102))
						.addComponent(lblSpacebarHard)
						.addComponent(lblDownArrow, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUpArrow)
						.addComponent(lblLrArrows))
					.addGap(61)
					.addGroup(panel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(panel3Layout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
							.addGroup(panel3Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(panel3Layout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblLineClear_1)
									.addComponent(lblLineClear)
									.addComponent(lblLineClear_2)
									.addComponent(lblTetrisLine))
								.addGroup(Alignment.TRAILING, panel3Layout.createSequentialGroup()
									.addComponent(lblBasicScoring)
									.addGap(39)))
							.addGap(123))
						.addGroup(panel3Layout.createSequentialGroup()
							.addGap(58)
							.addComponent(lable14)
							.addContainerGap(374, Short.MAX_VALUE))))
		);
		panel3Layout.setVerticalGroup(
			panel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(panel3Layout.createSequentialGroup()
					.addComponent(lable14)
					.addGap(77)
					.addComponent(label)
					.addContainerGap(97, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, panel3Layout.createSequentialGroup()
					.addGroup(panel3Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(panel3Layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBasicScoring)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLineClear)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLineClear_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLineClear_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTetrisLine))
						.addGroup(panel3Layout.createSequentialGroup()
							.addGap(33)
							.addComponent(lable3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUpArrow)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLrArrows)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDownArrow, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSpacebarHard)))
					.addGap(30))
		);
        panel_3.setLayout(panel3Layout);

            
		
		frame.getContentPane().add(panel_1,BorderLayout.WEST);
		
		JTextPane txtpnScore = new JTextPane();
		txtpnScore.setText("Score:");
		
		JTextPane textPane = new JTextPane();
		textPane.setText("0");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(57)
							.addComponent(txtpnScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(82)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(149)
					.addComponent(txtpnScore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().add(next_panel, BorderLayout.EAST);
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
	
	public static ImageIcon getImage(Piece im)
	{
		TerminoShape x = im.getShap();
		switch(x)
		{
		
		case LINE:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/Line.png");
		case LEFT_L:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/leftL.png");
		case RIGHT_L:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/rightL");
		case SQUARE:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/square.png");
		case RIGHT_ZIGZAG:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/RightZ.png");
		case LEFT_ZIGZAG:
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/leftZ.png");
		 default: 
			return new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/Prtmaid.png");	
		}
	}
	
	
	public  static void main(String[] args)
	{
		new Board();
	}
}
