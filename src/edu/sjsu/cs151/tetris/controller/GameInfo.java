package edu.sjsu.cs151.tetris.controller;
/**
 * A class that keeps track of information about the game.
 */
public class GameInfo {
	private static boolean UserNameEntered = false;
	private static int gamePage = 1;
	private static boolean gameLost = false;

	public static boolean isUserNameEntered() {
		return UserNameEntered;
	}

	public static void setUserNameEntered(boolean userNameEntered) {
		UserNameEntered = userNameEntered;
	}

	public static int getGamePage() {
		return gamePage;
	}

	public static void setGamePage(int gamePage) {
		GameInfo.gamePage = gamePage;
	}

	public static boolean isGameLost() {
		return gameLost;
	}

	public static void setGameLost(boolean gameLost) {
		GameInfo.gameLost = gameLost;
	}

}
