package com.kma.ImageTool.Panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;

@SuppressWarnings("serial")
public class PanelLessMore extends MetroPanel implements ActionListener {
	private MetroTextView txtSize;
	private MetroTextView txtResizeTo;
	private JComboBox comboBoxFirst;
	private JComboBox comboBoxSecond;

	public PanelLessMore() {

		this.setSize(new Dimension(300, 25));

		JLabel lblThan = new JLabel("than");
		Decorator.decorateInfo(lblThan);
		lblThan.setBounds(0, 4, 32, 14);
		add(lblThan);

		txtSize = ComponentFactory.GET.getMetroTextSmall();
		txtSize.setLocation(28, 4);
		add(txtSize);

		JLabel lblResizeTo = new JLabel("resize to");
		lblResizeTo.setBounds(139, 4, 46, 14);
		Decorator.decorateInfo(lblResizeTo);
		add(lblResizeTo);

		txtResizeTo = ComponentFactory.GET.getMetroTextSmall();
		txtResizeTo.setBounds(195, 4, 59, 16);
		add(txtResizeTo);
		txtResizeTo.setColumns(10);

		comboBoxFirst = ComponentFactory.GET.getComboBox();
		comboBoxFirst.setLocation(89, 4);
		add(comboBoxFirst);
		comboBoxFirst.addActionListener(this);

		comboBoxSecond = ComponentFactory.GET.getComboBox();
		comboBoxSecond.setLocation(256, 4);
		add(comboBoxSecond);
		comboBoxSecond.addActionListener(this);

	}

	public void clean() {
		txtSize.setText("");
		txtResizeTo.setText("");

	}

	public MetroTextView getThanSize() {
		return txtSize;
	}

	public MetroTextView getResizeTo() {
		return txtResizeTo;
	}

	public String getCompared() {
		return txtSize.getText();
	}

	public String getResize() {
		return txtResizeTo.getText();
	}

	public void addListener(ActionListener l) {
		txtResizeTo.addActionListener(l);
		txtSize.addActionListener(l);

	}

	public JComboBox getComboBoxFirst() {
		return comboBoxFirst;
	}

	public JComboBox getComboBoxSecond() {
		return comboBoxSecond;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Object source = e.getSource();

		// if (source == comboBoxFirst) {
		// comboBoxSecond.setSelectedIndex(comboBoxFirst.getSelectedIndex());
		// }
		//
		// if (source == comboBoxSecond) {
		// comboBoxFirst.setSelectedIndex(comboBoxSecond.getSelectedIndex());
		// }

	}
}
