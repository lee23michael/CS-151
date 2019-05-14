package edu.sjsu.cs151.tetris.model;


/**
 * Represents a Termino piece on the Grid.
 */

public class Piece {

	private int pivot = -1;
	private TerminoShape shape;
	protected Block[] blocks;
	//private int pieceColor;
	private boolean finalized = false;
	private boolean visible = false;
	private int LineStatus;
	
	
	public Piece(TerminoShape e,int a0, int a1, int b0, int b1, int c0, int c1, int d0, int d1,int color) {
		shape = e;
		//pieceColor = RandomSingleton.getInstance().nextColor();
		//pieceColor = color;
		blocks = new Block[4];
		blocks[0]= new Block(a0,a1,color);
		blocks[1]=new Block(b0,b1,color);
		blocks[2]=new Block(c0,c1,color);
		blocks[3]=new Block(d0,d1,color);
	}
	
	public void setVisible() {
		visible = true;
		for(int i=0;i<4;i++)
		{
			blocks[i].setVisible();
		}
		System.out.println(this.getShap().toString());
		
	}
	
	public Block[] getBlockArray()
	{
		return blocks;
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
	
	public int getPivot()
	{
		return pivot;
	}
	
	
	
	public void rotate()
	{
		int x_p = blocks[pivot].getXCoor();
		int y_p = blocks[pivot].getYCoor();
		
			for(int i = 0; i<4;i++)
			{
				
				int x = blocks[i].getXCoor();
				int y = blocks[i].getYCoor();
				
				int t_x = x_p - y_p + y;
				int t_y = y_p + x_p - x;
				
				if(i!=pivot)
				{
					blocks[i].setPostion(t_x,t_y);
				}else
				{
					blocks[i].setPostion(blocks[pivot].getXCoor(),blocks[pivot].getYCoor());
				}
			}
		
		
	}
	
	public void drop()
	{
		
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor()+1, blocks[i].getYCoor());
			}
	}
		
	
	
	public void moveLeft()
	{
		
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor(), blocks[i].getYCoor()-1);
			}
		
	}
	
	public void moveRight()
	{
		
			for(int i = 0; i<4;i++)
			{
				blocks[i].setPostion(blocks[i].getXCoor(), blocks[i].getYCoor()+1);
			}
		
	}
	
	public TerminoShape getShap()
	{
		return shape;
	}
	
	public void setFinalized()
	{
		finalized = true;
	}
	
	//if the piece has finalized
	public boolean getStatus()
	{
		return finalized;
	}
	
	
	public void setMoving() {
		for(int i=0;i<4;i++)
		{
			blocks[i].setMove();
		}
	}
		
	public void SetMoveToFalse() {
		for(int i=0;i<4;i++)
		{
			blocks[i].SetMoveToFalse();
		}
	}

	public int getLineStatus() {
		return LineStatus;
	}

	public void setLineStatus(int lineStatus) {
		LineStatus = lineStatus;
	}
	}
	
	
	
	

		

	
	
	
	
	
	
	
	


