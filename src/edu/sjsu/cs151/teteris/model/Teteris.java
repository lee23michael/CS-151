package edu.sjsu.cs151.teteris.model;

public class Teteris {
	
	public Teteris(String name)
	{
		User.loadUserList();//load previous users data
		new User(name);
		new ScoreBoard();
		
	}
	
	public void play()
	{
		new Grid();
	}
	
	
	///Just for test

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Teteris test = new Teteris("Jack");
		test.Save();
		test.showSocoreBoard();
	

	}
	
	public void Save() {
		User.save();
		
	}
	
	
	public void showSocoreBoard()
	{
		System.out.println(ScoreBoard.getScoreBoardMap().toString());
	}

}
