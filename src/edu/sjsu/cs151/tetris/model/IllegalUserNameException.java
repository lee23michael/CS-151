package edu.sjsu.cs151.tetris.model;

public class IllegalUserNameException extends Exception {
	public IllegalUserNameException(String errorMessage) {
        super(errorMessage);
    }
}
