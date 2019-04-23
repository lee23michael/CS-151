package edu.sjsu.cs151.teteris.model;

public class Square extends Piece {
	public Square() {
		super(TerminoShape.SQUARE,0,0,0,1,1,0,1,1);
	}
	
	@Override
	public void rotate()
	{
		//does nothing since no rotation for Square
	}

}
