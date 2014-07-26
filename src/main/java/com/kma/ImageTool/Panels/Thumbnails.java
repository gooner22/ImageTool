package com.kma.ImageTool.Panels;

import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;

import javax.swing.JLabel;

public class Thumbnails extends MetroPanel {
	private MetroTextView txtWidth;
	private MetroTextView txtHeight;

	public Thumbnails() {

		JLabel lblWidth = new JLabel("width");
		Decorator.decorateInfo(lblWidth);
		lblWidth.setBounds(10, 7, 46, 14);
		add(lblWidth);

		txtWidth = ComponentFactory.GET.getMetroTextSmall();
		txtWidth.setLocation(39, 4);
		add(txtWidth);

		/*JLabel lblHeight = new JLabel("height");
		Decorator.decorateInfo(lblHeight);
		lblHeight.setBounds(135, 7, 46, 14);
		add(lblHeight);

		txtHeight = ComponentFactory.GET.getMetroTextSmall();
		txtHeight.setLocation(170, 4);
		add(txtHeight);*/

	}

	public MetroTextView getTxtWidth() {
		return txtWidth;
	}

	public MetroTextView getTxtHeight() {
		return txtHeight;
	}

	/**
	 * to clean all fiealds
	 */
	public void clean() {
		txtHeight.setText("");
		txtWidth.setText("");
	}

}
