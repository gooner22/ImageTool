package com.kma.ImageTool.Controller;

import com.kma.ImageTool.Log.LoggerUtils;

public enum Debug {
	GET;

	public boolean debugMode = true;

	public void log(String text) {
		if (debugMode)
            LoggerUtils.getLogger().fine("Debug: " + text);
	}

	public void turnOn() {
		debugMode = true;
	}

	public void turnOff() {
		debugMode = false;
	}

}
