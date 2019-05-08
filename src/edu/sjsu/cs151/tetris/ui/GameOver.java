package edu.sjsu.cs151.tetris.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import edu.sjsu.cs151.tetris.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOver extends JFrame{
	private JTextField txtGameOver;
	JFrame frame = new JFrame("Testing");
	JLabel imgLabel = new JLabel(new ImageIcon("src/edu/sjsu/cs151/tetris/ui/images/GAMEOVER.jpg"));
	public GameOver() {
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionText);
	        frame.getContentPane().add(panel);
	        SpringLayout sl_panel = new SpringLayout();
	        panel.setLayout(sl_panel);
	        
	        JButton btnShowScore = new JButton("Show Score");
	        btnShowScore.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		frame.dispose();
	                new Highscores().setVisible(true);
	        	}
	        });
	        sl_panel.putConstraint(SpringLayout.SOUTH, btnShowScore, -71, SpringLayout.SOUTH, panel);
	        sl_panel.putConstraint(SpringLayout.EAST, btnShowScore, -492, SpringLayout.EAST, panel);
	        panel.add(btnShowScore);
	        panel.add(imgLabel);
	        frame.setResizable(false);
	        frame.setSize(1126, 639);  
	        frame.setLocationRelativeTo(null);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.setVisible(true);  
	        User.save();
	}
	
	public static void main(String args[]) {
		new GameOver();
	}
}
