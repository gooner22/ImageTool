package com.kma.ImageTool.View;

import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.kma.ImageTool.Factories.ButtonFactory;
import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;
import com.kma.ImageTool.ViewComponents.MyButton;

public class MainImageMagic extends MetroPanel {

	private MetroTextView textField;
	private MyButton btnSet;
	private MyButton btnExit;
	private MyButton btnInstall;
	private JLabel lblPath;
	private MyButton btnBrowse;

	public MainImageMagic() {

		JLabel lblTitle = new JLabel("Image Magic");
		lblTitle.setSize(170, 35);
		Decorator.decorateTitle(lblTitle);
		add(lblTitle);

		btnInstall = ButtonFactory.getNormalButton("Install");
		btnInstall
				.setToolTipText("Will automatically install required software");
		btnInstall.setLocation(377, 203);
		add(btnInstall);

		btnExit = ButtonFactory.getNormalButton("Exit");
		btnExit.setLocation(179, 203);
		add(btnExit);

		btnSet = ButtonFactory.getNormalButton("Set");
		btnSet.setLocation(278, 203);
		add(btnSet);

		textField = ComponentFactory.GET.getTextView();
		textField.setLocation(182, 142);
		textField.setAlignmentX(CENTER_ALIGNMENT);
		add(textField);

		lblPath = new JLabel("Set path to Image Magic folder");
		Decorator.decorateNormal(lblPath);
		lblPath.setBounds(182, 112, 228, 20);
		add(lblPath);

		btnBrowse = ButtonFactory.getNormalButton("Browse");
		btnBrowse.setLocation(472, 142);
		add(btnBrowse);

	}

	/**
	 * 
	 * @param l
	 *            which grouped all components to one listener
	 */
	public void addListener(ActionListener l) {
		btnExit.addActionListener(l);
		btnInstall.addActionListener(l);
		btnSet.addActionListener(l);
		btnBrowse.addActionListener(l);
	}

	public MetroTextView getTextField() {
		return textField;
	}

	public MyButton getBtnSet() {
		return btnSet;
	}

	public MyButton getBtnExit() {
		return btnExit;
	}

	public MyButton getBtnInstall() {
		return btnInstall;
	}

	public MyButton getBtnBrowse() {
		return btnBrowse;
	}
}
