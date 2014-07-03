package com.kma.ImageTool.ViewComponents;

import java.awt.event.KeyEvent;

public class MetroTextViewOnlyNumbers extends MetroTextView {

	
	
	/**
	 * Filtered data? allow input only numbers
	 */
	@Override
	public void processKeyEvent(KeyEvent ev) {
		char c = ev.getKeyChar();
		try {
			// Ignore all non-printable characters. Just check the printable
			// ones.
			if (c > 31 && c < 5000) {
				Integer.parseInt(c + "");
			}
			super.processKeyEvent(ev);
		} catch (NumberFormatException nfe) {
			// Do nothing. Character inputted is not a number, so ignore it.
		}
	};
}
