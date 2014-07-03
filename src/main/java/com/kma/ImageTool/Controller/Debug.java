package com.kma.ImageTool.Controller;

public enum Debug {
	GET;

	public boolean debugMode = true;

	public void log(String text) {
		if (debugMode)
			System.out.println("Debug: " + text);
	}

	public void turnOn() {
		debugMode = true;
	}

	public void turnOff() {
		debugMode = false;
	}

}
