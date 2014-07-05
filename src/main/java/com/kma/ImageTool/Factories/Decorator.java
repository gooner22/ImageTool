package com.kma.ImageTool.Factories;

import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

import com.kma.ImageTool.View.Config;

public class Decorator {

	/** FontType uses in Titles */
	public static final String FontType = "Segoe UI";
    public static final Font FONT = new Font(FontType, Font.ROMAN_BASELINE, 15);
    private static final String ConfigColor = null;
	private static final int H1 = 21;

    public static Font getFont() {
        return FONT;
    }

    public static void decorateTitle(JLabel label) {

		label.setFont(new Font(FontType, Font.PLAIN, H1));

		label.setAlignmentX(label.CENTER_ALIGNMENT);
		label.setLocation(Config.WIDTH_MAIN / 2 - label.getWidth() / 2, 26);

	}

	/**
	 * 
	 * @param label
	 *            all info about statement which user need to know
	 */
	public static void decorateNormal(JComponent label) {

		label.setFont(FONT);

	}

	/**
	 * 
	 * @param l
	 *            JLabel which we need to decorate using it only in compared
	 *            panels
	 */
	public static void decorateInfo(Component l) {
		l.setFont(new Font(FontType, Font.PLAIN, 11));
	}

}
