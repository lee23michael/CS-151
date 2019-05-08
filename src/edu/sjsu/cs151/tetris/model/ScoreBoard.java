package edu.sjsu.cs151.tetris.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


//Needed to initialized the ScoreBoard at the start of Game

public class ScoreBoard{
	
	private static Map<String,Integer> score_list;
	
	
	public ScoreBoard()
	{
		User.RefreshUserList();
		score_list = new LinkedHashMap<String,Integer>();
		
		for(int i = 0; i<User.getUserList().size(); i++)
		{
			score_list.put(User.getUserList().get(i).getName(),User.getUserList().get(i).getScore());
			
		}
		
	}//use new ScoreBoard to refresh
	
	public static Map<String,Integer> getScoreBoardMap()
	{
		//new ScoreBoard();
		
		return score_list;
	}
	
	
	

}
