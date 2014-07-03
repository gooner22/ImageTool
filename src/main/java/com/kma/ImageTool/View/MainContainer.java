package com.kma.ImageTool.View;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainContainer extends JFrame {

	public MainContainer() {
		setSize(Config.WIDTH_MAIN, Config.HEIGHT_MAIN);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));

	}

	// switching panels
	public void showPane(JPanel m) {
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().revalidate();

		getContentPane().add(m);
		getContentPane().repaint();
		getContentPane().revalidate();

	}

}
