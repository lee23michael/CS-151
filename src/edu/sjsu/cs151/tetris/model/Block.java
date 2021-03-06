package edu.sjsu.cs151.tetris.model;



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
	public Block(int x, int y, int c ) {
		this.setColor(c);
		this.x = x;
		this.y = y;
		
		
	}
	
	/**
	 * Sets the x and y position of this Block.
	 */
	public void setPostion(int x, int y) {
		this.x = x;
		this.y = y;
		setVisible();
		
	}
	
	public void setVisible()
	{
		Grid.addToGrid(x, y, this);
	}
	/**
	 * Accesses x coordinate of this Block.
	 * @return Value for the x position of this Block.
	 */
	public int getXCoor() {
		return x;
	}
	/**
	 * Accesses y coordinate of this block.
	 * @return Value for the y position of this Block.
	 */
	public int getYCoor() {
		return y;
	}
	
	public void rotateBlock(Block thePivot)
	{
		int t_x = this.getXCoor()-thePivot.getXCoor();
		int t_y = this.getYCoor()-thePivot.getYCoor();
		this.setPostion(-t_y+thePivot.getXCoor(), t_x+thePivot.getYCoor());
	}
	
	

	/**
	 * @return the c
	 */
	public int getColor() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setColor(int c) {
		this.c = c;
	}
	
	public void setMove()
	{
		moving = true;
	}
	
	public void SetMoveToFalse()
	{
		moving = false;
	}
	
	public boolean getMovingStatus() {
		return moving;
	}
	
	



	private int x;
	private int y;
	private int c;
	private boolean moving = false;


}
