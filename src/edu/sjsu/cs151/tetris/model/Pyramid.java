package edu.sjsu.cs151.tetris.model;

public class Pyramid extends Piece {
	
	public Pyramid() {
		super(TerminoShape.PYRAMID,1,0,1,1,0,1,1,2);
		this.setPivot(2);
	}

}
