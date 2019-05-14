package edu.sjsu.cs151.tetris.model;


public class Line extends Piece {
	
	
	public Line() {
		super(TerminoShape.LINE,2,0,2,1,2,2,2,3,4);
		setLineStatus(0);
		//no pivot special rotation
	}
	
	@Override
	public void rotate()
	{
	
		Block[] blocks = this.getBlockArray();
		if(this.getLineStatus() == 0)
		{
			
				
				setBlockXY(0, blocks[0].getXCoor()-1, blocks[0].getYCoor()+2);
				setBlockXY(1,blocks[1].getXCoor(),blocks[0].getYCoor());
				setBlockXY(2,blocks[2].getXCoor()+1, blocks[2].getYCoor());
				setBlockXY(3,blocks[3].getXCoor()+2, blocks[3].getYCoor()-1);
				
			
		}
		
		if(this.getLineStatus() == 1)
		{
			
				setBlockXY(0,blocks[0].getXCoor()+2, blocks[0].getYCoor()+1);
				setBlockXY(1,blocks[1].getXCoor()+1,blocks[1].getYCoor());
				setBlockXY(2,blocks[2].getXCoor(), blocks[2].getYCoor()-1);
				setBlockXY(3,blocks[3].getXCoor()-1, blocks[3].getYCoor()-2);
				
			
		}
		
		if(this.getLineStatus() == 2)
		{
			
			
			
				
				setBlockXY(0,blocks[0].getXCoor()+1, blocks[0].getYCoor()-2);
				setBlockXY(1,blocks[1].getXCoor(),blocks[1].getYCoor()-1);
				setBlockXY(2,blocks[2].getXCoor()-1, blocks[2].getYCoor());
				setBlockXY(3,blocks[3].getXCoor()-2, blocks[3].getYCoor()+1);
				
			
		}
		
		if(this.getLineStatus() == 3)
		{
			setBlockXY(0,blocks[0].getXCoor()-2, blocks[0].getYCoor()-1);
			setBlockXY(1,blocks[1].getXCoor()-1,blocks[1].getYCoor());
			setBlockXY(2,blocks[2].getXCoor(), blocks[2].getYCoor()+1);
			setBlockXY(3,blocks[3].getXCoor()+1, blocks[3].getYCoor()+2);
			
			
		}
	}


	
	

}
