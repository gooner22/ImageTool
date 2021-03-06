package com.kma.ImageTool.Controller;

import java.awt.Component;

import javax.swing.JOptionPane;

public enum InfoBox {
	BOX;

	public void alert(Component c, String error) {
		JOptionPane.showConfirmDialog(c, error, "Alert",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION);

	}

	public void info(Component c, String info) {
		JOptionPane.showConfirmDialog(c, info, "Info",
				JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION);
	}

	public int exit(Component c, String info) {
		return JOptionPane.showConfirmDialog(c, info, "Exit",
				JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION);
	}
}
