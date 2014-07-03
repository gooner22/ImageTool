package com.kma.ImageTool.Factories;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.kma.ImageTool.ViewComponents.MyButton;

public class ButtonFactory {

	public static MyButton getNormalButton() {
		MyButton m = new MyButton();
		return m;
	}

	public static MyButton getNormalButton(String s) {
		MyButton m = new MyButton(s);
		m.setSize(90, 30);
		return m;
	}

	public static MyButton getIconButton(String pathToImage, String toolTips) {
		MyButton m = new MyButton();
		m.setToolTipText(toolTips);
		m.setSize(new Dimension(100, 100));
		ImageIcon start = new ImageIcon(pathToImage);
		m.setIcon(start);
		return m;
	}

	public static MyButton getMnemButton(String text, char mnem) {
		MyButton m = new MyButton(text);
		m.setMnemonic(mnem);
		return m;
	}

}
