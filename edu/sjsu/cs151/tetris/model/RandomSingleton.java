package edu.sjsu.cs151.tetris.model;

import java.util.Random;

public class RandomSingleton {
	private static RandomSingleton instance = new RandomSingleton();
    private Random randomgen;
    
    private RandomSingleton() {
    	randomgen = new Random();
    }

    public static RandomSingleton getInstance() {
    	
        return instance;
    }

   // public int nextColor() {
   //      return randomgen.nextInt(6);
         
   // }
    
    public Piece nextPiece()
    {
    	int x = randomgen.nextInt(7);
    	
    	if(x == 0)
    	{
    		return new LeftL();
    	}
    	if(x == 1)
    	{
    		return new RightL();
    	}
    	if(x == 2)
    	{
    		return new Line();
    	}
    	if(x == 3)
    	{
    		return new Square();
    	}
    	if(x == 4)
    	{
    		return new RightZigzag();
    	}
    	if(x == 5)
    	{
    		return new LeftZigzag();
    	}
    	else
    	{
    		return new Pyramid();
    	}
    	
    	
    	
    }
    
    
}


