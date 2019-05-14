package edu.sjsu.cs151.tetris.ui;
import java.awt.Color;

public class ColorHelper {
	
	public static Color getColor(int x) 
	{
		switch(x)
		{
			case 0:
			{
				return Color.blue;
			}
			case 1:
			{
				return Color.yellow;
			}
			case 2:
			{
				return Color.orange;
			}
			case 3:
			{
				return Color.green;
			}
			case 4:
			{
				return Color.cyan;
			}
			case 5:
			{
				return Color.MAGENTA;
			}
			
			default:
			{
				return Color.red;
			}
		
		}
	}

}
