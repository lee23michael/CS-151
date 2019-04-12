package edu.sjsu.cs151.teteris.model;
import java.awt.*;
import java.util.*;

/**
 * Represents blocks on a Grid.
 */
public class Block {
	
	/**
	 * A constructor that creates a new block with Position p and Color c
	 * 
	 * @param p The Position of this Block.
	 * @param c The Color of this Block.
	 */
	public Block(int x, int y, Color c ) {
		this.p = new Position(x,y);
		this.c = c;
		Grid.addToGrid(x, y, this);
		
	}
	/**
	 * Sets the x and y position of this Block.
	 */
	public void setPostion(int x, int y) {
		Grid.moveBlockOnGrid(getXCoor(), getYCoor(), x, y);
		this.p = new Position(x,y);
		
	}
	/**
	 * Accesses x coordinate of this Block.
	 * @return Value for the x position of this Block.
	 */
	public int getXCoor() {
		return this.p.getXPosition();
	}
	/**
	 * Accesses y coordinate of this block.
	 * @return Value for the y position of this Block.
	 */
	public int getYCoor() {
		return this.p.getYPosition();
	}
	
	public void rotateBlock(Block thePivot)
	{
		int t_x = this.getXCoor()-thePivot.getXCoor();
		int t_y = this.getYCoor()-thePivot.getYCoor();
		this.setPostion(-t_y+thePivot.getXCoor(), t_x+thePivot.getYCoor());
	}
	
	
	private final Point[][][] pieces = {
			// Line-shape
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// Mirrored L -shap
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L-shape
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// Square-shape
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S-shape
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T-shape
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z-shape
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};

	private Position p;
	private Color c;
	private Point blockOri;

	private ArrayList<Integer> nextBlcok = new ArrayList<Integer>();
}
