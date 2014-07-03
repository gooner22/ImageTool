package com.kma.ImageTool.ViewComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kma.ImageTool.View.Config;

@SuppressWarnings("serial")
public class MetroPanel extends JPanel {
	public MetroPanel() {
		this.setSize(new Dimension(Config.WIDTH_MAIN, Config.HEIGHT_MAIN));
		this.setBackground(new Color(170, 170, 170));// grey color
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
	}

}
