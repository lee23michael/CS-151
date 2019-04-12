package edu.sjsu.cs151.teteris.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Represents a Termino piece on the Grid.
 */

enum TerminoShape {
	 LINE,RIGHT_L,LEFT_L, SQUARE, RIGHT_ZIGZAG, PYRAMID, LEFT_ZIGZAG
	}

public class Piece {

	private int pivot;
	private TerminoShape shape;
	private Block[] blocks;
	private int LineStatus;
	
	public Piece(TerminoShape e) {
		shape = e;
		blocks = new Block[4];
		Color pieceColor = new Color((int)(Math.random() * 0x1000000));
		;
		if (shape == TerminoShape.LINE) { 
			blocks[0]= new Block(0,0,pieceColor);
			blocks[1]=new Block(0,1,pieceColor);
			blocks[2]=new Block(0,2,pieceColor);
			blocks[3]=new Block(0,3,pieceColor);
			LineStatus = 0;
			//no pivot special rotation
			}
		
		
		
		
		if (shape == TerminoShape.RIGHT_L) { 
			blocks[0]=new Block(0,0,pieceColor);
			blocks[1]=new Block(1,0,pieceColor);
			blocks[2]=new Block(1,1,pieceColor);
			blocks[3]=new Block(1,2,pieceColor);
			pivot = 2;
			}
		
		if (shape == TerminoShape.RIGHT_L) { 
			blocks[0]=new Block(0,2,pieceColor);
			blocks[1]=new Block(1,0,pieceColor);
			blocks[2]=new Block(1,1,pieceColor);
			blocks[3]=new Block(1,2,pieceColor);
			pivot = 2;
			}
		
		
		if (shape == TerminoShape.SQUARE) { 
			blocks[0]=new Block(0,0,pieceColor);
			blocks[1]=new Block(0,1,pieceColor);
			blocks[2]=new Block(1,0,pieceColor);
			blocks[3]=new Block(1,1,pieceColor);
			//no pivot special no rotation
			}
		
		if (shape == TerminoShape.RIGHT_ZIGZAG) { 
			blocks[0]=new Block(1,0,pieceColor);
			blocks[1]=new Block(1,1,pieceColor);
			blocks[2]=new Block(0,1,pieceColor);
			blocks[3]=new Block(0,2,pieceColor);
			pivot = 2;
			}
		
		if (shape == TerminoShape.PYRAMID) { 
			blocks[0]=new Block(1,0,pieceColor);
			blocks[1]=new Block(1,1,pieceColor);
			blocks[2]=new Block(0,1,pieceColor);
			blocks[3]=new Block(1,2,pieceColor);
			pivot = 2;
			}
		
		if (shape == TerminoShape.LEFT_ZIGZAG) { 
			blocks[0]=new Block(0,0,pieceColor);
			blocks[1]=new Block(0,1,pieceColor);
			blocks[2]=new Block(1,1,pieceColor);
			blocks[3]=new Block(1,2,pieceColor);
			pivot = 2;
			}
	}
	
	public void drop()
	{
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor()+1, blocks[i].getYCoor()))
			{
				locationLegal = false;
			};
		}
		
		if(locationLegal)
		{
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor()+1, blocks[i].getYCoor());
			}
		}
		
	}
	
	public void moveLeft()
	{
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor(), blocks[i].getYCoor()-1))
			{
				locationLegal = false;
			};
		}
		if(locationLegal)
		{
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor(), blocks[i].getYCoor()-1);
			}
		}
	}
	
	public void moveRight()
	{
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			if(!Grid.isLeagllAndEmpty(blocks[i].getXCoor(), blocks[i].getYCoor()+1))
			{
				locationLegal = false;
			};
		}
		if(locationLegal)
		{
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor(), blocks[i].getYCoor()+1);
			}
		}
	}
	
	public TerminoShape getShap()
	{
		return shape;
	}
	
	
	public void rotate()
	{
		if(shape!=TerminoShape.SQUARE)
		{
			if(shape == TerminoShape.LINE)
			{
				rotateLine();
			}else
			{
				rotateNorm();
			}
		}else
		{
			//Square does not require rotate
		}
	}
	
	private void rotateNorm()
	{
		boolean locationLegal = true;
		for(int i = 0; i<4;i++)
		{
			int t_x = blocks[i].getXCoor()-blocks[pivot].getXCoor();
			int t_y = blocks[i].getYCoor()-blocks[pivot].getYCoor();
			blocks[i].setPostion(-t_y+blocks[pivot].getXCoor(), t_x+blocks[pivot].getYCoor());
			
			if(!Grid.isLeagllAndEmpty(-t_y+blocks[pivot].getXCoor(), t_x+blocks[pivot].getYCoor()))
			{
				locationLegal = false;
			};
		}
		
		if(locationLegal)
		{
			for(int i = 0; i<4;i++)
			{
				if(i!=pivot)
				{
					int t_x = blocks[i].getXCoor()-blocks[pivot].getXCoor();
					int t_y = blocks[i].getYCoor()-blocks[pivot].getYCoor();
					blocks[i].setPostion(-t_y+blocks[pivot].getXCoor(), t_x+blocks[pivot].getYCoor());
				}		
			}
		}
		
		
		
	}

	
	private void rotateLine()
	{
		Block a = blocks[0];
		boolean locationLegal = true;
		if(this.LineStatus == 0)
		{
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()+1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()+1, a.getXCoor()+1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()+2, a.getXCoor()+1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()+3, a.getXCoor()+1))
			{
				locationLegal = false;
			}
			
			if(locationLegal)
			{
				blocks[0].setPostion(a.getYCoor(), a.getXCoor()+1);
				blocks[1].setPostion(a.getYCoor()+1, a.getXCoor()+1);
				blocks[2].setPostion(a.getYCoor()+2, a.getXCoor()+1);
				blocks[3].setPostion(a.getYCoor()+3, a.getXCoor()+1);
				LineStatus = 1;
			}
		}
		
		if(this.LineStatus == 1)
		{
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()+3))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()+2))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()+1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()))
			{
				locationLegal = false;
			}
			
			if(locationLegal)
			{
			blocks[0].setPostion(a.getYCoor(), a.getXCoor()+3);
			blocks[1].setPostion(a.getYCoor(), a.getXCoor()+2);
			blocks[2].setPostion(a.getYCoor(), a.getXCoor()+1);
			blocks[3].setPostion(a.getYCoor(), a.getXCoor());
			LineStatus = 2;
			}
		}
		if(this.LineStatus == 2)
		{
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()-1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()-1, a.getXCoor()-1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()-2, a.getXCoor()-1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor()-3, a.getXCoor()-1))
			{
				locationLegal = false;
			}
			
			if(locationLegal)
			{
			blocks[0].setPostion(a.getYCoor(), a.getXCoor()-1);
			blocks[1].setPostion(a.getYCoor()-1, a.getXCoor()-1);
			blocks[2].setPostion(a.getYCoor()-2, a.getXCoor()-1);
			blocks[3].setPostion(a.getYCoor()-3, a.getXCoor()-1);
			LineStatus = 3;
			}
		}
		if(this.LineStatus == 3)
		{
			
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()-3))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()-2))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()-1))
			{
				locationLegal = false;
			}
			if(!Grid.isLeagllAndEmpty(a.getYCoor(), a.getXCoor()))
			{
				locationLegal = false;
			}
			
			if(locationLegal)
			{
			blocks[0].setPostion(a.getYCoor(), a.getXCoor()-3);
			blocks[1].setPostion(a.getYCoor(), a.getXCoor()-2);
			blocks[2].setPostion(a.getYCoor(), a.getXCoor()-1);
			blocks[3].setPostion(a.getYCoor(), a.getXCoor());
			LineStatus = 0;
			}
		}
	}
	
	
	
	
	
	
	
	

}
