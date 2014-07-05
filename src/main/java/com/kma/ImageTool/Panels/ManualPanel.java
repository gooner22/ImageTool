package com.kma.ImageTool.Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.View.Config;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ManualPanel extends MetroPanel implements ActionListener {
	private MetroTextView txtWidth;
	private MetroTextView txtHeight;// and holds percent
	private JComboBox comboBox;
	private JLabel lblHeight;
	private Component lblWidth;
	private boolean perCent;
	private ArrayList<Component> list;

	public ManualPanel() {
		setBackground(Config.bColor);
		setSize(628, 120);
		setLayout(null);

		int dt = 40;

		list = new ArrayList<Component>();

		txtWidth = ComponentFactory.GET.getMetroTextSmall();
		txtWidth.setLocation(190 - dt, 81);
		txtWidth.setVisible(false);
		add(txtWidth);

		lblWidth = new JLabel("width");
		Decorator.decorateInfo(lblWidth);
		lblWidth.setBounds(105, 84, 46, 14);
		lblWidth.setVisible(false);
		add(lblWidth);

		lblHeight = new JLabel("width");
		Decorator.decorateInfo(lblHeight);
		lblHeight.setBounds(297 - dt, 84, 46, 14);
		add(lblHeight);

		// now it is width
		txtHeight = ComponentFactory.GET.getMetroTextSmall();
		txtHeight.setLocation(343 - dt, 81);
		add(txtHeight);

		comboBox = ComponentFactory.GET.getComboBoxSize();
		comboBox.setLocation(410 - dt, 81);
		comboBox.addActionListener(this);
		add(comboBox);

		list.add(txtWidth);
		list.add(txtHeight);
		list.add(comboBox);
		list.add(lblHeight);
		list.add(lblWidth);

	}

	/**
	 * disallow to editing figure
	 */
	public void freeze() {
		for (Component l : list) {
			l.setEnabled(false);
		}
	}

	/**
	 * allow to editing components
	 */
	public void rise() {
		for (Component l : list) {
			l.setEnabled(true);
		}
	}

	public void clean() {
		// txtHeight.setText("");
		txtWidth.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// percent in combobox
		if (comboBox.getSelectedIndex() == 1) {
			txtHeight.setText("");
			txtWidth.setText("");

			// lblWidth.setVisible(false);
			lblHeight.setVisible(false);

			// txtWidth.setVisible(false);

			perCent = true;

		} else if (comboBox.getSelectedIndex() == 0) {
			// lblWidth.setVisible(true);
			lblHeight.setVisible(true);

			// txtWidth.setVisible(true);
			txtHeight.setText("");
			// txtWidth.setText("");

			perCent = false;
		}

	}

	/**
	 * method that told au if we are in percent modeor full with width and heigh
	 * 
	 * @return true if percent - false another way
	 */
	public boolean isPerCent() {
		return perCent;
	}

	public MetroTextView getTxtWidth() {
		return txtWidth;
	}

	public MetroTextView getTxtHeight() {
		return txtHeight;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

}
