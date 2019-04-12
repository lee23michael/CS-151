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
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	
	
	
	

	
	
	

	
	private int x;
	private int y;


}
