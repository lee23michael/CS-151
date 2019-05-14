package edu.sjsu.cs151.tetris.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

public class ScorePanel extends JPanel{
	
	public ScorePanel(String score) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		JLabel lblScore = new JLabel("Score ");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel label_1 = new JLabel(score);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_scoreNlevel_panel = new GroupLayout(this);
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
		setLayout(gl_scoreNlevel_panel);
	}

}
