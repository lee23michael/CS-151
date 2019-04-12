package edu.sjsu.cs151.teteris.model;


/**
 * Represents the standard 10 by 20 Tetris grid as an array of 1s and 0s
 */
public class Grid {
	public static final int GRID_X_MAX = 10;
	public static final int GRID_Y_MAX = 20;

	public Grid(int[][] grid) {
		this.grid = new int[GRID_X_MAX][GRID_Y_MAX];
	}
	
	public void fillPosition(int x, int y) {
		grid[x][y] = 1;
	}
	
	private int[][] grid;
}
