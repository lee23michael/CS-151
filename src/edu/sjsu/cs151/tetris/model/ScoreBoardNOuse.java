package edu.sjsu.cs151.tetris.model;

import java.util.LinkedHashMap;
import java.util.Map;




//Needed to initialized the ScoreBoard at the start of Game

public class ScoreBoardNOuse{
	
	private static Map<String,Integer> score_list;
	
	
	public ScoreBoardNOuse()
	{
		//User.RefreshUserList();
		
		
		score_list = new LinkedHashMap<String,Integer>();
		
		//for(int i = 0; i<User.getUserList().size(); i++)
		//{
		//	System.out.println(User.getUserList().get(i).getName());
		//	score_list.put(User.getUserList().get(i).getName(),User.getUserList().get(i).getScore());
			
		//}
		
		 for(User c:User.getUserList())
    	 {
    		 System.out.println(c.getName());
    	 }
		
	}//use new ScoreBoard to refresh
	
//	public static Map<String,Integer> getScoreBoardMap()
//	{
//		new ScoreBoard();
//		
//		return score_list;
//	}
	
	
	

}
