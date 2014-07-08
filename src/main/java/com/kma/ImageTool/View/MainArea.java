package com.kma.ImageTool.View;

import java.awt.event.ActionListener;

import com.kma.ImageTool.Factories.ButtonFactory;
import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.Model.settings.WorkingConfigFile;
import com.kma.ImageTool.Model.settings.WorkingDirectoryPath;
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
    private MetroTextView templateName;


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


		lblSetPath = new JLabel("Path to folder with images:");
		Decorator.decorateNormal(lblSetPath);
		lblSetPath.setBounds(127, 63, 230, 21);
		add(lblSetPath);

		btnOpenDir = ButtonFactory.getNormalButton("Open dir");
		btnOpenDir.setLocation(402, 335);
		add(btnOpenDir);


        addTemplateItem();

		lblInfo = new JLabel();
		Decorator.decorateNormal(lblInfo);
		lblInfo.setBounds(127, templateName.getY() + templateName.getHeight() + 50, 320, 21);

        progressBar = ComponentFactory.GET.getProgressBar();
		progressBar.setLocation(128, templateName.getY() + templateName.getHeight() + 30);
		progressBar.setVisible(false);
		add(progressBar);

        add(lblInfo);

        restoreSettings();

	}

    private void addTemplateItem() {
        final int yOffset = textField.getY() + textField.getHeight() + 10;
        final int xOffset = lblSetPath.getX();

        JLabel lblTemplateName = new JLabel("Template name");
        lblTemplateName.setBounds(xOffset, yOffset, 120, 18);
        Decorator.decorateNormal(lblTemplateName);
        add(lblTemplateName);

        templateName = ComponentFactory.GET.getTextView();
        templateName.setLocation(xOffset, lblTemplateName.getY() + lblTemplateName.getHeight() + 10 );
        add(templateName);

        JLabel lbldefault = new JLabel("for default name - leave blank");
        lbldefault.setBounds(xOffset, templateName.getY() + templateName.getHeight() + 10, 200, 25);
        Decorator.decorateInfo(lbldefault);
        add(lbldefault);

    }


    private void restoreSettings() {
        final WorkingDirectoryPath workingDirectoryPath = WorkingDirectoryPath.getFromTmp();
        if (workingDirectoryPath != null)
            textField.setText(workingDirectoryPath.getPath());

        final WorkingConfigFile workingConfigFile = WorkingConfigFile.getFromTmp();
        if (workingConfigFile != null)
            templateName.setText(workingConfigFile.getTemplateName());
    }

    public void savePathToImageFolder(String pathToImageFolder) {
        new WorkingDirectoryPath(pathToImageFolder).serialize();
    }

    public void saveTemplateName(String templateName) {
        new WorkingConfigFile(templateName).serialize();
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

    public MetroTextView getTemplateName() {
        return templateName;
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
