package edu.sjsu.cs151.teteris.model;


/**
 * Represents a Termino piece on the Grid.
 */


public class Piece {

	private int pivot;
	private TerminoShape shape;
	private Block[] blocks;
	private int pieceColor;
	
	
	public Piece(TerminoShape e,int a0, int a1, int b0, int b1, int c0, int c1, int d0, int d1) {
		shape = e;
		pieceColor = RandomSingleton.getInstance().nextColor();
		blocks = new Block[4];
		blocks[0]= new Block(a0,a1,pieceColor);
		blocks[1]=new Block(b0,b1,pieceColor);
		blocks[2]=new Block(c0,c1,pieceColor);
		blocks[3]=new Block(d0,d1,pieceColor);
	}
	
	public Block getBlock(int a)
	{
		return blocks[a];
	}
	
	public void setBlockXY(int a, int x, int y)
	{
		blocks[a].setPostion(x, y);
	}
	
	public void setPivot(int x)
	{
		pivot = x;
	}
	
	
	
	public void rotate()
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
	

		
}
	
	
	
	
	
	
	
	


