import java.util.Collections;
import java.util.TreeMap;

//Needed to initialized the ScoreBoard at the start of Game

public class ScoreBoard {
	
	private static TreeMap<Integer,String> score_list;
	
	public ScoreBoard()
	{
		score_list = new TreeMap<Integer,String>(Collections.reverseOrder());
		
		for(int i = 0; i<User.getUserList().size(); i++)
		{
			score_list.put(User.getUserList().get(i).getScore(), User.getUserList().get(i).getName());
		}
	}
	
	public static TreeMap<Integer,String> getScoreBoardMap()
	{
		return score_list;
	}
	

}
