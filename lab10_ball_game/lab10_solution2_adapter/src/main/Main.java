package main;

import game.BallGame;
import platforms.AndroidPlatform;

public class Main {
	
	public static void main(String[] args) {
		BallGame game = new BallGame(new AndroidPlatform());
		game.play();
	}
}
