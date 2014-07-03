package com.kma.ImageTool.Factories;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import com.kma.ImageTool.Panels.ExtendedPanel;
import com.kma.ImageTool.Panels.ManualPanel;
import com.kma.ImageTool.View.Config;
import com.kma.ImageTool.ViewComponents.MetroTextView;
import com.kma.ImageTool.ViewComponents.MetroTextViewOnlyNumbers;

/**
 * Factory that gives us all main components except buttons
 * 
 * 
 */
public enum ComponentFactory {
	GET;

	private int width = 284;
	private int height = 30;

	/**
	 * 
	 * @return right painted JCheckBox
	 */
	public JCheckBox getCheckBox(String s) {
		JCheckBox c = new JCheckBox(s);
		c.setBackground(Config.bColor);
		return c;
	}

	/**
	 * 
	 * @return panel with mass height and width configuration
	 */

	public ExtendedPanel getExtendedPanel() {

		return new ExtendedPanel();
	}

	/**
	 * 
	 * @param s
	 *            what to deploy
	 * @return radio button
	 */

	public JRadioButton getRadioBtn(String s) {
		JRadioButton rdbtnManual = new JRadioButton(s);
		rdbtnManual.setBackground(Config.bColor);
		return rdbtnManual;
	}

	/**
	 * 
	 * @return MetroTextView to input all number values
	 */
	public MetroTextViewOnlyNumbers getMetroTextSmall() {
		MetroTextViewOnlyNumbers m = new MetroTextViewOnlyNumbers();
		m.setSize(59, 16);
		return m;

	}

	/**
	 * 
	 * @return MetroTextView to input path only
	 */
	public MetroTextView getTextView() {

		MetroTextView m = new MetroTextView();
		m.setSize(width, height);
		return m;
	}

	/**
	 * 
	 * @return for template name only
	 */
	public MetroTextView getTextViewForName() {

		MetroTextView m = new MetroTextView();
		m.setSize(100, 16);
		return m;
	}

	/**
	 * 
	 * @return JProgressBar which be used
	 */
	public JProgressBar getProgressBar() {

		JProgressBar progressBar = new JProgressBar();
		progressBar.setSize(width, height);
		return progressBar;
	}

	/**
	 * 
	 * @return small comboBox with model values px, pt
	 * 
	 */
	public JComboBox getComboBox() {
		JComboBox comboBox = new JComboBox();
		comboBox.setSize(46, 18);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "px", "pt" }));
		return comboBox;
	}

	/**
	 * 
	 * @return ComboBox for ManualPanel panel
	 */
	public JComboBox getComboBoxSize() {
		JComboBox comboBox = new JComboBox();
		comboBox.setSize(46, 18);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "px", "%" }));
		return comboBox;

	}

	/**
	 * Manual adjusting size panel
	 * 
	 * @return
	 */
	public ManualPanel getManualPanel() {
		return new ManualPanel();
	}

}
