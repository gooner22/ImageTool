package com.kma.ImageTool.View;

import java.awt.event.ActionListener;

import com.kma.ImageTool.Factories.ButtonFactory;
import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;
import com.kma.ImageTool.ViewComponents.MyButton;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class MainArea extends MetroPanel {
	private MetroTextView textField;
	private MyButton btnExit;
	private MyButton btnRun;
	private MyButton btnBrowse;

	private int chooseIntY = 90;
	private JProgressBar progressBar;
	private JLabel lblSetPath;
	private MyButton btnOpenDir;
	private JLabel lblInfo;

	public MainArea() {

		textField = ComponentFactory.GET.getTextView();
		textField.setLocation(128, chooseIntY);
		add(textField);

		btnExit = ButtonFactory.getNormalButton("Exit");
		btnExit.setLocation(10, 335);
		add(btnExit);

		btnRun = ButtonFactory.getNormalButton("Edit & Run");
		btnRun.setLocation(501, 335);
		add(btnRun);

		btnBrowse = ButtonFactory.getNormalButton("Browse");
		btnBrowse.setLocation(419, chooseIntY);
		add(btnBrowse);

		progressBar = ComponentFactory.GET.getProgressBar();
		progressBar.setLocation(128, 131);
		progressBar.setVisible(false);
		add(progressBar);

		lblSetPath = new JLabel("Path to folder with images:");
		Decorator.decorateNormal(lblSetPath);
		lblSetPath.setBounds(127, 63, 230, 21);
		add(lblSetPath);

		btnOpenDir = ButtonFactory.getNormalButton("Open dir");
		btnOpenDir.setLocation(402, 335);
		add(btnOpenDir);

		lblInfo = new JLabel();
		Decorator.decorateNormal(lblInfo);
		lblInfo.setBounds(127, 186, 320, 21);
		add(lblInfo);

	}

	public void addListener(ActionListener l) {
		textField.addActionListener(l);
		btnExit.addActionListener(l);
		btnRun.addActionListener(l);
		btnBrowse.addActionListener(l);
		btnOpenDir.addActionListener(l);

	}

	public MetroTextView getTextField() {
		return textField;
	}

	public MyButton getBtnExit() {
		return btnExit;
	}

	public MyButton getBtnRun() {
		return btnRun;
	}

	public MyButton getBtnBrowse() {
		return btnBrowse;
	}

	public MyButton getBtnOpenDir() {
		return btnOpenDir;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JLabel getLblInfo() {
		return lblInfo;
	}
}
