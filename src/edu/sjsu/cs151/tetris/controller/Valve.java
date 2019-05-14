package edu.sjsu.cs151.tetris.controller;

import edu.sjsu.cs151.tetris.message.*;

public interface Valve {

	public ValveResponse execute(Message message);
}
