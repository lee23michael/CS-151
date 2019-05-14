package edu.sjsu.cs151.tetris.ui;

import java.awt.Color;
import java.util.Queue;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import edu.sjsu.cs151.tetris.model.Piece;
import edu.sjsu.cs151.tetris.model.TerminoShape;

public class NextQueuePanel extends JPanel {

	public NextQueuePanel(Queue<Piece> q) {
		Piece piece1 = q.remove();
		Piece piece2 = q.remove();
		Piece piece3 = q.remove();
		

		
		JLabel piece1L = new JLabel();
		JLabel piece2L = new JLabel();
		JLabel piece3L = new JLabel();
		
		setLabelIcon(piece1L,piece1);
		setLabelIcon(piece2L,piece2);
		setLabelIcon(piece3L,piece3);
		

		JPanel hold1 = new JPanel();
		hold1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		hold1.add(piece1L);
		
		JPanel hold2 = new JPanel();
		hold2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		hold2.add(piece2L);

		JPanel hold3 = new JPanel();
		hold3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		hold3.add(piece3L);
		GroupLayout gl_hold_panel = new GroupLayout(this);
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
		this.setLayout(gl_hold_panel);
	}
	public void setLabelIcon(JLabel l, Piece p) {
		if(p.getShap() == TerminoShape.LINE) {
			ImageIcon icon5 = new ImageIcon("./images/Tetromino_I.jpg");
	        l.setIcon(icon5);
		} else if (p.getShap() == TerminoShape.LEFT_L) {
			ImageIcon icon2 = new ImageIcon("./images/Tetromino_Reverse_L.png");
	        l.setIcon(icon2);
		} else if (p.getShap() == TerminoShape.RIGHT_L) {
		      ImageIcon icon6 = new ImageIcon("./images/Tetromino_L.png");
		      l.setIcon(icon6);
		} else if (p.getShap() == TerminoShape.PYRAMID) {
			ImageIcon icon4 = new ImageIcon("./images/Tetris_Piece.png");
	        l.setIcon(icon4);
		} else if (p.getShap() == TerminoShape.SQUARE) {
			ImageIcon icon3 = new ImageIcon("./images/Tetromino_o.png");
	        l.setIcon(icon3);
		} else if (p.getShap() == TerminoShape.RIGHT_ZIGZAG) {
			ImageIcon icon1 = new ImageIcon("./images/Tetromino_S.png");
	        l.setIcon(icon1);
		} else if (p.getShap() == TerminoShape.LEFT_ZIGZAG) {
			ImageIcon icon7 = new ImageIcon("./images/Tetromino_Reverse_S.png");
	        l.setIcon(icon7);
		}
        
	}
	public static void main(String args[]) {

	}
    
}
