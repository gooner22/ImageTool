package com.kma.ImageTool.Panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;

/**
 * Between part of HalfManual panel
 * 
 * @author yaroslav
 * 
 */

@SuppressWarnings("serial")
public class PanelBetween extends MetroPanel implements ActionListener {

	private MetroTextView txtFirstSize;
	private MetroTextView txtResizeTo;
	private JLabel lblAnd;
	private MetroTextView txtSecondSize;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	public PanelBetween() {

		this.setSize(new Dimension(516, 25));

		JLabel lblThan = new JLabel("the");
		lblThan.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		lblThan.setBounds(3, 4, 32, 14);
		add(lblThan);

		txtFirstSize = ComponentFactory.GET.getMetroTextSmall();
		txtFirstSize.setBounds(28, 4, 59, 16);

		add(txtFirstSize);
		txtFirstSize.setColumns(10);

		JLabel lblResizeTo = new JLabel("resize to");
		lblResizeTo.setBounds(277, 4, 46, 14);
		lblResizeTo.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		add(lblResizeTo);

		txtResizeTo = ComponentFactory.GET.getMetroTextSmall();
		txtResizeTo.setBounds(326, 4, 59, 16);

		add(txtResizeTo);
		txtResizeTo.setColumns(10);

		lblAnd = new JLabel("and");
		lblAnd.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblAnd.setBounds(139, 4, 26, 14);
		add(lblAnd);

		txtSecondSize = ComponentFactory.GET.getMetroTextSmall();
		txtSecondSize.setColumns(10);
		txtSecondSize.setBounds(162, 4, 59, 16);
		add(txtSecondSize);

		comboBox = ComponentFactory.GET.getComboBox();
		comboBox.setLocation(89, 2);
		add(comboBox);
		comboBox.addActionListener(this);

		comboBox_1 = ComponentFactory.GET.getComboBox();
		comboBox_1.setLocation(224, 2);
		add(comboBox_1);
		comboBox_1.addActionListener(this);

		comboBox_2 = ComponentFactory.GET.getComboBox();
		comboBox_2.setLocation(390, 2);
		add(comboBox_2);
		comboBox_2.addActionListener(this);
	}

	public void clean() {
		txtFirstSize.setText("");
		txtResizeTo.setText("");
		txtSecondSize.setText("");
	}

	public MetroTextView getTxtFirstSize() {
		return txtFirstSize;
	}

	public MetroTextView getTxtResizeTo() {
		return txtResizeTo;
	}

	public MetroTextView getTxtSecondSize() {
		return txtSecondSize;
	}

	public String getFirst() {
		return txtFirstSize.getText();
	}

	public String getSecond() {
		return txtSecondSize.getText();
	}

	public String getResizeTo() {
		return txtResizeTo.getText();
	}

	// add listener
	public void addListener(ActionListener e) {
		txtFirstSize.addActionListener(e);
		txtSecondSize.addActionListener(e);
		txtResizeTo.addActionListener(e);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == comboBox) {
			comboBox_1.setSelectedIndex(comboBox.getSelectedIndex());
			
		}

		if (source == comboBox_1) {
			comboBox.setSelectedIndex(comboBox_1.getSelectedIndex());
			
		}
//
//		if (source == comboBox_2) {
//			comboBox.setSelectedIndex(comboBox_2.getSelectedIndex());
//			comboBox_1.setSelectedIndex(comboBox_2.getSelectedIndex());
//		}

	}
}
