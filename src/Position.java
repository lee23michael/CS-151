package edu.sjsu.cs151.teteris.model;
/**
 * Keeps track of the position of objects on a Grid.
 */
public class Position {
/**
 * Creates a new Position object with x and y coordinates.
 * 
 * @param x The x-coordinate
 * @param y The y-coordinate
 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Sets the position of this object with coordinates x and y.
	 * 
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @return 
	 */
	public int setPosition(int x, int y) {
		pre_x = this.x;
		pre_y = this.y;
		this.x = x;
		this.y = y;
		if(x>19||y>9||y<0)
		{
			return -1;
		}else
			return 1;
	}
	/**
	 * Gets the x position of this object.
	 * @return Value for the x position.
	 */
	public int getXPosition() {
		return this.x;
	}
	/**
	 * Gets the y position of this object.
	 * @return Value for the y position.
	 */
	public int getYPosition() {
		return this.y;
	}
	
	
	
	
	
	public int getPreXPosition() {
		return this.pre_x;
	}
	
	public int getPreYPosition() {
		return this.pre_y;
	}
	
	
	

	
	private int x;
	private int y;
	private int pre_x;
	private int pre_y;

}
