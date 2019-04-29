package edu.sjsu.cs151.teteris;

import java.util.Timer; 
import java.util.TimerTask;

import edu.sjsu.cs151.teteris.model.Model; 
  

public class Teteris 
{ 
	public String name = "ExampleName";
	public Model model;
	
	public Teteris()
	{
		model = new Model(name);
		
	}
	
	public void start()
	{
		Timer timer = new Timer(); 
        
        timer.scheduleAtFixedRate(new TimerHelperDrop(), 300, 800);
        
        
	}
	
    public static void main(String[] args) 
    { 
          
        
          
    } 


private class TimerHelperDrop extends TimerTask 
{ 
	public void run() 
    { 
        model.drop();
    } 
} 

}
  