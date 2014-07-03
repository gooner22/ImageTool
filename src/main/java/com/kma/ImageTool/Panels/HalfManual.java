package com.kma.ImageTool.Panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;

/**
 * CPart of Extended panel only width or height depends on
 * 
 * @param String
 *            s in constructor
 * 
 * 
 */

@SuppressWarnings("serial")
public class HalfManual extends MetroPanel {

	public static Color COLOR = new Color(170, 170, 170);
	private JCheckBox chkbxLessHeight;
	private JCheckBox chkbxBettwenHeight;
	private JCheckBox chkbxMoreHeight;
	private PanelLessMore panelMoreHeight;
	private PanelBetween panelBetweenHeight;
	private PanelLessMore panelLessHeight;
	private JRadioButton rdbtnMode;
	private ArrayList<Component> components;

	public HalfManual(String s) {
		this.setSize(new Dimension(627, 108));
		this.setLayout(null);

		components = new ArrayList<Component>();

		JLabel label = new JLabel("If image " + s);
		Decorator.decorateInfo(label);
		label.setBounds(0, 36, 100, 16);
		this.add(label);

		rdbtnMode = ComponentFactory.GET.getRadioBtn("");
		rdbtnMode.setBounds(10, 20, 16, 16);
		add(rdbtnMode);

		chkbxLessHeight = new JCheckBox("less");
		chkbxLessHeight.setBackground(COLOR);
		Decorator.decorateInfo(chkbxLessHeight);
		chkbxLessHeight.setBounds(79, 15, 61, 23);
		this.add(chkbxLessHeight);
		components.add(chkbxLessHeight);

		chkbxBettwenHeight = new JCheckBox("between");
		chkbxBettwenHeight.setBackground(COLOR);
		Decorator.decorateInfo(chkbxBettwenHeight);
		chkbxBettwenHeight.setBounds(79, 32, 71, 23);
		this.add(chkbxBettwenHeight);
		components.add(chkbxBettwenHeight);

		chkbxMoreHeight = new JCheckBox("more");
		chkbxMoreHeight.setBackground(COLOR);
		Decorator.decorateInfo(chkbxMoreHeight);
		chkbxMoreHeight.setBounds(79, 50, 61, 23);
		this.add(chkbxMoreHeight);

		components.add(chkbxMoreHeight);

		// panels where we put in parametrs
		panelMoreHeight = new PanelLessMore();
		panelMoreHeight.getComboBoxSecond().setLocation(388, 4);
		panelMoreHeight.getResizeTo().setLocation(327, 4);
		panelMoreHeight.setBounds(146, 52, 444, 25);
		this.add(panelMoreHeight);

		components.add(panelMoreHeight.getThanSize());
		components.add(panelMoreHeight.getResizeTo());
		components.add(panelMoreHeight.getComboBoxFirst());
		components.add(panelMoreHeight.getComboBoxSecond());

		panelBetweenHeight = new PanelBetween();
		panelBetweenHeight.getComboBox_2().setLocation(388, 2);
		panelBetweenHeight.getTxtResizeTo().setLocation(327, 4);
		panelBetweenHeight.setBounds(146, 32, 444, 25);
		this.add(panelBetweenHeight);

		components.add(panelBetweenHeight.getTxtFirstSize());
		components.add(panelBetweenHeight.getTxtResizeTo());
		components.add(panelBetweenHeight.getTxtSecondSize());

		components.add(panelBetweenHeight.getComboBox());
		components.add(panelBetweenHeight.getComboBox_1());
		components.add(panelBetweenHeight.getComboBox_2());

		panelLessHeight = new PanelLessMore();
		panelLessHeight.getComboBoxSecond().setLocation(388, 4);
		panelLessHeight.getResizeTo().setLocation(327, 4);
		panelLessHeight.setBounds(146, 11, 444, 25);
		this.add(panelLessHeight);

		components.add(panelLessHeight.getThanSize());
		components.add(panelLessHeight.getResizeTo());

		components.add(panelLessHeight.getComboBoxFirst());
		components.add(panelLessHeight.getComboBoxSecond());

	}

	/**
	 * to clean fields
	 */
	public void clean() {
		panelBetweenHeight.clean();
		panelLessHeight.clean();
		panelMoreHeight.clean();
	}

	public void addListener(ActionListener e) {
		panelBetweenHeight.addListener(e);
		panelLessHeight.addListener(e);
		panelMoreHeight.addListener(e);

		chkbxLessHeight.addActionListener(e);
		chkbxBettwenHeight.addActionListener(e);
		chkbxMoreHeight.addActionListener(e);
	}

	public JCheckBox getChkbxLessHeight() {
		return chkbxLessHeight;
	}

	public JCheckBox getChkbxBetweenHeight() {
		return chkbxBettwenHeight;
	}

	public JCheckBox getChkbxMoreHeight() {
		return chkbxMoreHeight;
	}

	public PanelLessMore getPanelMoreHeight() {
		return panelMoreHeight;
	}

	public PanelBetween getPanelBetweenHeight() {
		return panelBetweenHeight;
	}

	public PanelLessMore getPanelLessHeight() {
		return panelLessHeight;
	}

	public JRadioButton getRdbtnMode() {
		return rdbtnMode;
	}

	/**
	 * set all values empty
	 */
	public void clear() {
		// uncheck comboboxes
		for (int i = 0; i < 3; i++) {
			((JCheckBox) components.get(i)).setSelected(false);
		}

		// 3 cause of checkboxes
		int numbOfCheckBoxes = 3;
		for (int i = numbOfCheckBoxes; i < components.size(); ++i) {
			try {
				((MetroTextView) components.get(i)).setText("");
			} catch (ClassCastException e) {
				// do nothig
			}
		}

	}

	public void freaze() {

		for (Component c : components) {
			c.setEnabled(false);
		}
	}

	public void rise() {

		for (Component c : components) {
			c.setEnabled(true);
		}
	}
}
