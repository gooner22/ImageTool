package com.kma.ImageTool.Controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import com.kma.ImageTool.DTO.ImageParametrs;
import com.kma.ImageTool.DataStrategy.HoldDataStrategy;
import com.kma.ImageTool.DataStrategy.Strategy;
import com.kma.ImageTool.Error.InvalidImageFileNameException;
import com.kma.ImageTool.Error.NotExistingXMLError;
import com.kma.ImageTool.Model.Model;
import com.kma.ImageTool.Model.settings.WorkingDirectoryPath;
import com.kma.ImageTool.View.MainArea;
import com.kma.ImageTool.View.MainContainer;
import com.kma.ImageTool.View.MainImageMagic;
import com.kma.ImageTool.View.XmlEditor;
import com.kma.ImageTool.View.XmlWrapper;
import com.kma.ImageTool.ViewComponents.MetroTextView;

/**
 * com.kma.ImageTool.Model com.kma.ImageTool.View com.kma.ImageTool.Controller. Controll all relationship between frames and panels of
 * our program
 * 
 * 
 */
public class Controller {

	private MainContainer frame;
	private Model model;
	private MainImageMagic imageMagicPanel;
	private Debug log = Debug.GET;
	private MainArea mainArea;
	private XmlEditor editor;
	private XmlWrapper wrapper;
	private ImageParametrs imageDTO;

	public Controller() {

		log.turnOn();

		frame = new MainContainer();
		model = Model.GET;

		if (!model.doImageMagicInstalled()) {
			initImageMagicPanel();
			frame.showPane(imageMagicPanel);
		} else {
			initMainArea();
			frame.showPane(mainArea);
		}
		frame.setVisible(true);
	}

	/**
	 * com.kma.ImageTool.Panels wich allow to choose directory of Image magic and save it runs
	 * only once, and create setting.txt if does not exist will invoke second
	 * time
	 * 
	 * @author yaroslav
	 * 
	 */
	private class InstallImageMagicListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == imageMagicPanel.getBtnInstall()) {

                if(!Model.GET.doInstallImageMagic()){
                    InfoBox.BOX.info(frame,
                            "Can't install dependencies. Something went wrong.");
                }
            }

			if (source == imageMagicPanel.getBtnBrowse()) {
				invokeJChooser(imageMagicPanel.getTextField());
			}

			if (source == imageMagicPanel.getBtnExit()) {
				if (InfoBox.BOX.exit(frame, "Are you sure?") == 0) {
					System.exit(0);
				}
			}

			if (source == imageMagicPanel.getBtnSet()) {
				String path = imageMagicPanel.getTextField().getText();
				if (Model.GET.doSetPathToImageLibrary(path)) {
					initMainArea();
					frame.showPane(mainArea);
				} else {
					InfoBox.BOX.info(frame,
							"Please set path to Image Magic folder");
				}
			}

		}

	}// END of InstallImageMagicListener

	/**
	 * This class holding all event in MainArea implements delegated listener to
	 * controller from view
	 * 
	 * @author yaroslav
	 * 
	 */
	private class MainAreaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			if (source == mainArea.getBtnBrowse()) {

				invokeJChooser(mainArea.getTextField());

			}// btn browse

			if (source == mainArea.getBtnExit()) {
				if (InfoBox.BOX.exit(frame, "Are you sure?") == 0) {
					System.exit(0);
				}

			}

			if (source == mainArea.getBtnOpenDir()) {
				openDirectory();
			}

			if (source == mainArea.getBtnRun()) {
                final String pathToImageFolder = mainArea.getTextField().getText();
                if (checkPath(pathToImageFolder)) {
					// set path to image folder
					invokeEditor();

                    mainArea.savePathToImageFolder(pathToImageFolder);
				} else {
					InfoBox.BOX.info(mainArea, "Please choose path first");
				}

			}

		}// end ACtionPerformed
			// END of MainAreaListener
	}


    /**
	 * This one holding all delegated ActionListener FRom XmlEditor com.kma.ImageTool.View
	 * 
	 * @author yaroslav
	 * 
	 */

	private class WrapperListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();

			// watching of xml editor's interface
			manageFace(source);

			if (source == wrapper.getBtnCancel()) {
				if (InfoBox.BOX.exit(editor, "Are you sure") == 0) {
					invokeMain();
				}
			}

			// run after creatino
			if (source == wrapper.getBtnOk()) {

				// return false
				if (!checkThumbnail()) {
					InfoBox.BOX.info(editor,
							"Please, input thumbnail's width and height");

				} else {

					// save data to xml file

					holdData();
					// com.kma.ImageTool.Model.GET.doSaveXmlFile(imageDTO);
					InfoBox.BOX.info(editor, "Now you start editing images");

					// start editing photos
					runEditing();

				}
			}

		}
	}// END of WrapperListener

	// /////////////// HELP ////////////////////

	// /////////////// //////////////////////
	/**
	 * Invoke XML editor is xml already exists fetch all info
	 */
	private void invokeEditor() {
		frame.setEnabled(false);
		initEditor();
		// set path to image folder
		Model.GET.doSetPathToFolderWorkingWith(mainArea.getTextField()
				.getText());
		// wrapper.clean();
		initDataInEditor();
	}

	/**
	 * Run editing folder with images
	 */
	private void runEditing() {
		class MyWorker extends SwingWorker<Object, Object> {

			private boolean isProblem;

			@Override
			protected Object doInBackground() throws Exception {
				mainArea.getProgressBar().setVisible(true);
				mainArea.getProgressBar().setIndeterminate(true);
				mainArea.getLblInfo().setText(
						"Please wait while we converting your images");
				mainArea.getBtnRun().setEnabled(false);
				invokeMain();
                try {
                    if (!Model.GET.doRunEditing()) {
                        InfoBox.BOX
                                .alert(frame,
                                        "Could not find images in the folder, or problem has happened");
                        isProblem = true;
                        mainArea.getLblInfo().setText("");
                    }
                } catch (Exception e){
                    InfoBox.BOX
                            .alert(frame,
                                    e.getMessage());
                    isProblem = true;
                    mainArea.getLblInfo().setText("");
                }

                return null;

			}

			@Override
			protected void done() {
				mainArea.getProgressBar().setVisible(false);
				mainArea.getBtnRun().setEnabled(true);
				if (!isProblem)
					mainArea.getLblInfo().setText("Images edited successfully");
			}
		}
		new MyWorker().execute();
	}

	/**
	 * if thumbnail checked should input data
	 * 
	 * @return true if ok false is missed some data in fields
	 */
	private boolean checkThumbnail() {

		if (wrapper.getChckbThumbnail().isSelected() == true) {

			if (wrapper.getPnlThumbnail().getTxtHeight().getText().equals("")
					|| wrapper.getPnlThumbnail().getTxtWidth().getText()
							.equals("")) {
				return false;
			} else {
				return true;
			}
		}

		return true;
	}

	/**
	 * if two fields if filled
	 * 
	 * @return
	 */
	private boolean checkCorrectManualSize() {
		if (wrapper.getRdbtnManual().isSelected()
				&& wrapper.getPnlManual().getComboBox().getSelectedIndex() == 0) {
			if (wrapper.getPnlManual().getTxtHeight().getText().equals("")
					|| wrapper.getPnlManual().getTxtWidth().getText()
							.equals("")) {
				return false;
			}
		}
		return true;
	}

	private boolean checkCorrect() {

		if (wrapper.getTxtDPI().getText().equals("")) {
			wrapper.getTxtDPI().showError();// does not work? should check
			return false;
		}

		return true;
	}

	/**
	 * invoke in set path to image magic and set path to folder with images
	 * 
	 * @param textField
	 *            the field where we want to write path from JChooser component
	 */
	public void invokeJChooser(MetroTextView textField) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int variant = fileChooser.showOpenDialog(null);

		if (variant == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getPath();
			textField.setText(path);
		}

	}

	/**
	 * Collect all data in the input fields and hold in the
	 * {@link com.kma.ImageTool.DTO.ImageParametrs} class
	 * 
	 * @return
	 */
	private boolean holdData() {
		boolean flag = true;

		Strategy str = new HoldDataStrategy();
		str.execute(wrapper);

		return flag;
	}

	// ////////////////////////////////

	// /////// INIT PANELS PART //////////////

	// //////////////////////////////

	private void invokeMain() {
		editor.setVisible(false);
		frame.setVisible(true);
		frame.setEnabled(true);
	}

	/**
	 * Will control what panel needs to apear depends on chosen button Will
	 * switching panels
	 * 
	 * @param source
	 */
	private void manageFace(Object source) {

		// deploy manual size panel
		if (source == wrapper.getRdbtnManual()) {

			wrapper.showManual();
			return;
		}
		// deploy extended panel
		if (source == wrapper.getRdbtnExtended()) {

			wrapper.showExtended();
			return;
		}

		if (source == wrapper.getChckbThumbnail()) {
			wrapper.showThumbnail();
			return;
		}

		if (source == wrapper.getRdbtnMono()) {
			wrapper.hideColorModel();
			return;
		}
		if (source == wrapper.getRdbtnColor()) {
			wrapper.showColorModel();
			return;
		}

        if (source == wrapper.getRenameFiles() ||
                source == wrapper.getDontRenameFiles()) {
            wrapper.showRenamingField();
            return;
        }

	}

	private void initEditor() {
		if (editor == null) {
			editor = new XmlEditor();
			if (wrapper == null) {
				wrapper = new XmlWrapper();
				wrapper.addListener(new WrapperListener());
			}

		}
		editor.showPane(wrapper);
		editor.setVisible(true);
	}

	/**
	 * 
	 * @return true if xmlfile exit and fill all fields right
	 */
	private boolean initDataInEditor() {
		if (Model.GET.isExistsXML()) {
			try {
				wrapper.putInfoToFieldsFromXML(Model.GET
						.getImageFetch(Model.GET.getXmlFile()));
				return true;
			} catch (NotExistingXMLError e) {
				System.out.println("Didnt find XML file");
				return false;
			}

		}
		return false;
	}

	private void initMainArea() {
		if (mainArea == null) {
			mainArea = new MainArea();
			mainArea.addListener(new MainAreaListener());
		}
	}

	private void initImageMagicPanel() {
		if (imageMagicPanel == null) {
			imageMagicPanel = new MainImageMagic();
			imageMagicPanel.addListener(new InstallImageMagicListener());
		}

	}

	private void openDirectory() {
		try {
			Desktop.getDesktop().open(
					new File(Model.GET.getPathToFolderWorkingWith()));
		} catch (Exception e) {
			try {
				Desktop.getDesktop().open(
						new File(mainArea.getTextField().getText()));
			} catch (Exception ee) {
				InfoBox.BOX.info(mainArea, "Please choose path to folder");
			}
		}
	}

	private boolean checkPath(String path) {
		if (path.equals("")) {
			return false;

		}
		return true;
	}
}
