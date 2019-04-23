package edu.sjsu.cs151.teteris.model;

public class Line extends Piece {
	private int LineStatus;
	
	public Line() {
		super(TerminoShape.LINE,0,0,0,1,0,2,0,3);
		LineStatus = 0;
		//no pivot special rotation
	}
	
	@Override
	public void rotate()
	{
		Block a = this.getBlock(0);
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
				
				this.setBlockXY(0, a.getYCoor(), a.getXCoor()+1);
				this.setBlockXY(1, a.getYCoor()+1, a.getXCoor()+1);
				this.setBlockXY(2, a.getYCoor()+2, a.getXCoor()+1);
				this.setBlockXY(3, a.getYCoor()+3, a.getXCoor()+1);
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
				this.setBlockXY(0, a.getYCoor(), a.getXCoor()+3);
				this.setBlockXY(1, a.getYCoor(), a.getXCoor()+2);
				this.setBlockXY(2, a.getYCoor(), a.getXCoor()+1);
				this.setBlockXY(3, a.getYCoor(), a.getXCoor());
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
				this.setBlockXY(0, a.getYCoor(), a.getXCoor()-1);
				this.setBlockXY(1, a.getYCoor()-1, a.getXCoor()-1);
				this.setBlockXY(2, a.getYCoor()-2, a.getXCoor()-1);
				this.setBlockXY(3, a.getYCoor()-3, a.getXCoor()-1);
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
				this.setBlockXY(0, a.getYCoor(), a.getXCoor()-3);
				this.setBlockXY(1, a.getYCoor(), a.getXCoor()-2);
				this.setBlockXY(2, a.getYCoor(), a.getXCoor()-1);
				this.setBlockXY(3, a.getYCoor(), a.getXCoor());
			LineStatus = 0;
			}
		}
	}


	
	

}
