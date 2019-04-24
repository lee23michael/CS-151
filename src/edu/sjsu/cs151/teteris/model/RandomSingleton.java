package edu.sjsu.cs151.teteris.model;

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

    public int nextColor() {
         return randomgen.nextInt(6);
         
    }
    
    public int nextPiece()
    {
    	return randomgen.nextInt(6);
    }
    
    
}


