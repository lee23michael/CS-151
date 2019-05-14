package edu.sjsu.cs151.tetris.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class that provides a text-resizing animation.
 */
public class TextResizeAnimator extends JPanel implements ActionListener {

	public static final int MINFONT = 40;
	public static final int FONT_OFFSET = 1;
	public static final int COLOR_OFFSET = 10;
	public static final int MAXFONT = 50;
    /**
     * Makes a new TextResizeAnimator.
     */
	public TextResizeAnimator() {
		
		timer = new Timer(100, this);
		timer.start();
	}
   /**
    * Helps display this TextResizeAnimator in 2D Graphics.
    */
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		Font font = new Font("Impact", Font.PLAIN, x); //set the font/color
		g2d.setFont(font);
		g2d.setColor(textColor);

		FontMetrics fm = g2d.getFontMetrics();
		String s = "Press Start";

		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();

		int stringWidth = fm.stringWidth(s);

		g2d.drawString(s, (w - stringWidth) / 2, h / 2);
	}

	public static void main(String[] args) {
		TextResizeAnimator tRA = new TextResizeAnimator();
		JFrame frame = new JFrame("Press Start");
		frame.add(tRA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}


	public void actionPerformed(ActionEvent e) { //Manages when the text increases and decreases in size.
		if (x == MAXFONT) {
			hasReachedMax = true;
			hasReachedMin = false;
		} else if (x == MINFONT) {
			hasReachedMin = true;
			hasReachedMax = false;
		}
		if (hasReachedMax) {
			x -= FONT_OFFSET; //decrease font
		} else if (hasReachedMin) {
			x += FONT_OFFSET; //increase font
		}

		repaint();
	}

	private Timer timer;
	private int x = MINFONT;
	private boolean hasReachedMax = false;
	private boolean hasReachedMin = true;
	private Color textColor = new Color(0, 145, 145);
}
