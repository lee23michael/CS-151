import java.awt.Color;

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
	}
	/**
	 * Sets the x and y position of this Block.
	 */
	public void setPostion(int x, int y) {
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

	private Position p;
	private Color c;
}
