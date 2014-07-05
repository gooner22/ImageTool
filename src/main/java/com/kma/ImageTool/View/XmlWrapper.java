package com.kma.ImageTool.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kma.ImageTool.Factories.ButtonFactory;
import com.kma.ImageTool.Factories.ComponentFactory;
import com.kma.ImageTool.Factories.Decorator;
import com.kma.ImageTool.Model.ImageParameterFetch;
import com.kma.ImageTool.Panels.ExtendedPanel;
import com.kma.ImageTool.Panels.ManualPanel;
import com.kma.ImageTool.Panels.Thumbnails;
import com.kma.ImageTool.ViewComponents.MetroPanel;
import com.kma.ImageTool.ViewComponents.MetroTextView;
import com.kma.ImageTool.ViewComponents.MyButton;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class XmlWrapper extends MetroPanel implements ActionListener,
		DocumentListener {
	private MyButton btnCancel;
	private MyButton btnOk;
	private MetroTextView txtDPI;
	private JRadioButton rdbtnManual;
	private JRadioButton rdbtnExtended;
	private ExtendedPanel pnlExtended;
	private Thumbnails pnlThumbnail;
	private JCheckBox chckbxFlattening;
	private JRadioButton rdbtnMono;
	private JRadioButton rdbtnColor;
	private JComboBox comboBoxColorModel;
	private JComboBox comboBoxFormat;
	private JCheckBox chckbThumbnail;
	private JComboBox comboBoxRenameFiles;
	private ManualPanel pnlManual;
	private JTextField txtCompression;
	private Component label;
	private Component lblCompression;
    private JRadioButton renameFiles;
    private JRadioButton dontRenameFiles;
    private HintTextField renamingFormatTxt;
    private HintTextField renamingThumbnailFormatTxt;
    private JLabel renamingFormatTxtHelp;
    private JLabel renamingThumnailFormatTxtHelp;
    private JLabel imageInfoLbl;
    private JLabel imageThumbnailInfoLbl;

    public XmlWrapper() {
		setSize(Config.WIDTH_EDITOR, Config.HEIGHT_EDITOR);

		btnOk = ButtonFactory.getNormalButton("Ok");
		btnOk.setLocation(529, 467);
		add(btnOk);

		btnCancel = ButtonFactory.getNormalButton("Cancel");
		btnCancel.setLocation(430, 467);
		add(btnCancel);

		JLabel lblDpi = new JLabel("Resolution");
		lblDpi.setBounds(10, 10, 100, 14);
		Decorator.decorateNormal(lblDpi);
		add(lblDpi);

		txtDPI = ComponentFactory.GET.getMetroTextSmall();
		txtDPI.setLocation(150, 10);
		add(txtDPI);
		// to restrict changing size if this field is not empty
		txtDPI.getDocument().addDocumentListener(this);

		JLabel lblDPI = new JLabel("dpi");
		lblDPI.setBounds(210, 10, 35, 16);
		add(lblDPI);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 29, 628, 2);
		add(separator);

		JLabel lblResize = new JLabel("Resize");
		Decorator.decorateNormal(lblResize);
		lblResize.setBounds(10, 35, 46, 14);
		add(lblResize);

		rdbtnManual = ComponentFactory.GET.getRadioBtn("manual");
		rdbtnManual.setSelected(true);
		rdbtnManual.setBounds(67, 30, 100, 23);
		add(rdbtnManual);

		rdbtnExtended = ComponentFactory.GET.getRadioBtn("extended");
		rdbtnExtended.setBounds(138, 30, 100, 23);
		add(rdbtnExtended);

		ButtonGroup m = new ButtonGroup();
		m.add(rdbtnExtended);
		m.add(rdbtnManual);

		pnlExtended = ComponentFactory.GET.getExtendedPanel();
		pnlExtended.setLocation(0, 60);
		pnlExtended.setVisible(false);
		add(pnlExtended);

		pnlManual = ComponentFactory.GET.getManualPanel();
		pnlManual.setLocation(0, 60);
		add(pnlManual);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 320, 628, 2);
		add(separator_1);

		JLabel lblColorMode = new JLabel("Color mode");
		Decorator.decorateNormal(lblColorMode);
		lblColorMode.setBounds(10, 330, 94, 14);
		add(lblColorMode);

		chckbxFlattening = ComponentFactory.GET.getCheckBox("flattening");
		chckbxFlattening.setBounds(54, 440, 81, 23);
		add(chckbxFlattening);

		rdbtnMono = ComponentFactory.GET.getRadioBtn("mono");
		rdbtnMono.setBounds(54, 365, 76, 23);
		add(rdbtnMono);

		rdbtnColor = ComponentFactory.GET.getRadioBtn("color");
		rdbtnColor.setSelected(true);
		rdbtnColor.setBounds(54, 410, 76, 23);
		add(rdbtnColor);

		ButtonGroup gr = new ButtonGroup();
		gr.add(rdbtnMono);
		gr.add(rdbtnColor);

		comboBoxColorModel = new JComboBox();
		comboBoxColorModel.setModel(new DefaultComboBoxModel(new String[] {
				"sRGB", "RGB" }));
		comboBoxColorModel.setBounds(183, 410, 59, 20);
		add(comboBoxColorModel);

		/**
		 * panel which deploys thumbnail param
		 */
		pnlThumbnail = new Thumbnails();
		pnlThumbnail.setBounds(358, 370, 260, 30);
		pnlThumbnail.setVisible(false);
		add(pnlThumbnail);

		JLabel lblThumbnail = new JLabel("Thumbnail");
		Decorator.decorateNormal(lblThumbnail);
		lblThumbnail.setBounds(344, 340, 89, 14);
		add(lblThumbnail);

		comboBoxFormat = new JComboBox();
		comboBoxFormat.setModel(new DefaultComboBoxModel(new String[] { "gif",
				"png", "tiff", "tif", "jpg", "jpeg" }));
		comboBoxFormat.setBounds(183, 440, 59, 20);
		comboBoxFormat.addActionListener(this);
		add(comboBoxFormat);

		chckbThumbnail = ComponentFactory.GET.getCheckBox("");
		chckbThumbnail.setBounds(430, 330, 26, 23);
		chckbThumbnail.setSelected(false);
		add(chckbThumbnail);

		txtCompression = ComponentFactory.GET.getMetroTextSmall();
		txtCompression.setLocation(183, 470);
		txtCompression.setVisible(false);
		add(txtCompression);

		label = new JLabel("%");
		Decorator.decorateInfo(label);
		label.setBounds(250, 475, 18, 14);
		label.setVisible(false);
		add(label);

		lblCompression = new JLabel("compression");
		Decorator.decorateInfo(lblCompression);
		lblCompression.setBounds(114, 475, 76, 14);
		lblCompression.setVisible(false);
		add(lblCompression);

        addNamingItems();
	}

    private void addNamingItems() {
        final String kRename = "Rename";
        final String KNRenameFiles = "Don't rename files";
        final String kRenameFiles = "Rename with format";

        final int xOffset = 10;
        final int yOffset = 180;

        JLabel renameLbl = new JLabel(kRename);
        Decorator.decorateNormal(renameLbl);
        renameLbl.setBounds(xOffset, yOffset, 100, fontHeight());
        add(renameLbl);

        dontRenameFiles = new JRadioButton(KNRenameFiles);
        Decorator.decorateNormal(dontRenameFiles);
        dontRenameFiles.setSelected(true);
        dontRenameFiles.setBounds(renameLbl.getX() + 44, renameLbl.getY() + renameLbl.getHeight() + 5, 200, fontHeight());

        renameFiles = new JRadioButton(kRenameFiles);
        Decorator.decorateNormal(renameFiles);
            renameFiles.setBounds(dontRenameFiles.getX(), dontRenameFiles.getY() + dontRenameFiles.getHeight() + 10, 250, fontHeight());

        add(dontRenameFiles);
        add(renameFiles);

        ButtonGroup gr = new ButtonGroup();
        gr.add(dontRenameFiles);
        gr.add(renameFiles);

        imageInfoLbl = new JLabel("image");
        Decorator.decorateInfo(imageInfoLbl);
        imageInfoLbl.setBounds(renameFiles.getX() + 10, renameFiles.getY() + renameFiles.getHeight() + 10, 50, fontHeight());
        imageInfoLbl.setVisible(false);
        add(imageInfoLbl);

        renamingFormatTxt = new HintTextField("e.g: outputName.f-%03d");
        renamingFormatTxt.setBounds(imageInfoLbl.getX() + imageInfoLbl.getWidth() + 10, renameFiles.getY() + renameFiles.getHeight() + 10, 200, fontHeight()+5);
        renamingFormatTxt.setVisible(false);
        add(renamingFormatTxt);

        renamingFormatTxtHelp = new JLabel("leave blank for intelligent renaming");
        Decorator.decorateInfo(renamingFormatTxtHelp);
        renamingFormatTxtHelp.setBounds(renamingFormatTxt.getX() + renamingFormatTxt.getWidth() + 10, renamingFormatTxt.getY(), 300, renamingFormatTxt.getHeight());
        renamingFormatTxtHelp.setVisible(false);
        add(renamingFormatTxtHelp);

        imageThumbnailInfoLbl = new JLabel("thumbnail");
        Decorator.decorateInfo(imageThumbnailInfoLbl);
        imageThumbnailInfoLbl.setVisible(false);
        imageThumbnailInfoLbl.setBounds(imageInfoLbl.getX(), imageInfoLbl.getY() + imageInfoLbl.getHeight() + 10, imageInfoLbl.getWidth(), fontHeight());
        add(imageThumbnailInfoLbl);

        renamingThumbnailFormatTxt = new HintTextField("e.g: outputName.f-%03d.th");
        renamingThumbnailFormatTxt.setBounds(renamingFormatTxt.getX(), renamingFormatTxt.getY() + renamingFormatTxt.getHeight() + 10, renamingFormatTxt.getWidth(), fontHeight()+5);
        renamingThumbnailFormatTxt.setVisible(false);
        add(renamingThumbnailFormatTxt);

        renamingThumnailFormatTxtHelp = new JLabel("leave blank for intelligent renaming");
        Decorator.decorateInfo(renamingThumnailFormatTxtHelp);
        renamingThumnailFormatTxtHelp.setBounds(renamingFormatTxtHelp.getX(), renamingFormatTxtHelp.getY() + renamingFormatTxtHelp.getHeight() + 10, renamingFormatTxtHelp.getWidth(), renamingFormatTxtHelp.getHeight());
        renamingThumnailFormatTxtHelp.setVisible(false);
        add(renamingThumnailFormatTxtHelp);

    }


    private int fontHeight() {
        return getFontMetrics(Decorator.getFont()).getHeight();
    }

    /**
	 * 
	 * to clean all fields
	 */
	public void clean() {

		txtDPI.setText("");

		pnlExtended.clean();

		pnlThumbnail.clean();

		pnlManual.clean();

	}

	/**
	 * Listening only comboBoxFormat to know how to init depends models when
	 * show compression
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Class: " + e.getClass().getSimpleName());

		// jpg, jpeg, tiff, tif
		if (comboBoxFormat.getSelectedItem().equals("jpg")
				|| comboBoxFormat.getSelectedItem().equals("jpeg")
				|| comboBoxFormat.getSelectedItem().equals("tiff")
				|| comboBoxFormat.getSelectedItem().equals("tif")) {
			showCompression();
		} else {
			hideCompression();
		}

		// png gif ico cant have CMYK MY
		if (comboBoxFormat.getSelectedItem().equals("png")
				|| comboBoxFormat.getSelectedItem().equals("gif")
				|| comboBoxFormat.getSelectedItem().equals("ico")) {
			comboBoxColorModel.setModel(new DefaultComboBoxModel(new String[] {
					"sRGB", "RGB", }));
		} else {
			comboBoxColorModel.setModel(new DefaultComboBoxModel(new String[] {
					"sRGB", "RGB", "CMYK", "CMY" }));
		}
	} // end comboBox type of images

	/**
	 * hide compression field for particular type
	 */
	private void hideCompression() {
		txtCompression.setVisible(false);
		label.setVisible(false);
		lblCompression.setVisible(false);

	}

	/**
	 * show compression field for particular type
	 */
	private void showCompression() {
		txtCompression.setVisible(true);
		label.setVisible(true);
		lblCompression.setVisible(true);

	}

	/**
	 * to delegate all listener to controller as one
	 * 
	 * @param l
	 */
	public void addListener(ActionListener l) {
		// buttons
		btnOk.addActionListener(l);
		btnCancel.addActionListener(l);

		// Radio Buttons
		rdbtnExtended.addActionListener(l);
		rdbtnManual.addActionListener(l);
		rdbtnColor.addActionListener(l);
		rdbtnMono.addActionListener(l);

		// check buttons
		chckbxFlattening.addActionListener(l);
		chckbThumbnail.addActionListener(l);

        renameFiles.addActionListener(l);
        dontRenameFiles.addActionListener(l);

	}

	/**
	 * Switch Extended panel to ManualPanel
	 * 
	 * @return
	 */

	public void showManual() {
		pnlManual.setVisible(true);
		pnlExtended.setVisible(false);
	}

	/**
	 * wise versa
	 */
	public void showExtended() {
		pnlManual.setVisible(false);
		pnlExtended.setVisible(true);
	}

	/**
	 * Switching thumbnail panel
	 */
	public void showThumbnail() {
		if (chckbThumbnail.isSelected()) {
			pnlThumbnail.setVisible(true);
		} else {
			pnlThumbnail.setVisible(false);
		}
	}

	/**
	 * hide combobox with color model param
	 * 
	 */
	public void hideColorModel() {
		comboBoxColorModel.setVisible(false);
	}

	/**
	 * show color model
	 */
	public void showColorModel() {
		comboBoxColorModel.setVisible(true);

	}

    /**
     * change visibility of helper text fields
     */
    public void showRenamingField() {
        boolean visible = getRenameFiles().isSelected();
        getRenamingFormatTxt().setVisible(visible);
        getRenamingFormatTxtHelp().setVisible(visible);
        getRenamingThumbnailFormatTxt().setVisible(visible);
        getRenamingThumnailFormatTxtHelp().setVisible(visible);
        getImageInfoLbl().setVisible(visible);
        getImageThumbnailInfoLbl().setVisible(visible);
    }

	// /////////////////////////// GETTERS SETTERS PART
	// ///////////////////////////////

	public MyButton getBtnCancel() {
		return btnCancel;
	}

	public MyButton getBtnOk() {
		return btnOk;
	}

	public MetroTextView getTxtDPI() {
		return txtDPI;
	}

	public JRadioButton getRdbtnManual() {
		return rdbtnManual;
	}

	public JRadioButton getRdbtnExtended() {
		return rdbtnExtended;
	}

	public ExtendedPanel getPnlExtended() {
		return pnlExtended;
	}

	public Thumbnails getPnlThumbnail() {
		return pnlThumbnail;
	}

	public JCheckBox getChckbxFlattening() {
		return chckbxFlattening;
	}

	public JRadioButton getRdbtnMono() {
		return rdbtnMono;
	}

	public JRadioButton getRdbtnColor() {
		return rdbtnColor;
	}

	public JComboBox getComboBoxColorModel() {
		return comboBoxColorModel;
	}

	public JComboBox getComboBoxFormat() {
		return comboBoxFormat;
	}

	public JCheckBox getChckbThumbnail() {
		return chckbThumbnail;
	}

	public ManualPanel getPnlManual() {
		return pnlManual;
	}

	public JTextField getTxtCompression() {
		return txtCompression;
	}

    public JTextField getRenamingFormatTxt() {
        return renamingFormatTxt;
    }

    public JLabel getRenamingFormatTxtHelp() {
        return renamingFormatTxtHelp;
    }

    public void setTxtCompression(JTextField txtCompression) {
		this.txtCompression = txtCompression;
	}


    public JRadioButton getRenameFiles() {
        return renameFiles;
    }

    public JRadioButton getDontRenameFiles() {
        return dontRenameFiles;
    }

    public JTextField getRenamingThumbnailFormatTxt() {
        return renamingThumbnailFormatTxt;
    }

    public void setRenamingThumbnailFormatTxt(HintTextField renamingThumbnailFormatTxt) {
        this.renamingThumbnailFormatTxt = renamingThumbnailFormatTxt;
    }

    public JLabel getRenamingThumnailFormatTxtHelp() {
        return renamingThumnailFormatTxtHelp;
    }

    public JLabel getImageInfoLbl() {
        return imageInfoLbl;
    }

    public JLabel getImageThumbnailInfoLbl() {
        return imageThumbnailInfoLbl;
    }

    /**
	 * Place all values from xml file to this form
	 * 
	 * A lot of ifs goes here
	 * 
	 */

	public void putInfoToFieldsFromXML(ImageParameterFetch imageWorkingWith) {

		if (imageWorkingWith.getResolutionDPI() > 0) {
			txtDPI.setText(Integer.toString(imageWorkingWith.getResolutionDPI()));
		}

		if (imageWorkingWith.isFlatteningImage()) {
			chckbxFlattening.setSelected(imageWorkingWith.isFlatteningImage());
		}
		if (imageWorkingWith.isChangeToMono()) {
			this.rdbtnMono.setSelected(imageWorkingWith.isChangeToMono());
			this.rdbtnColor.setSelected(false);
			comboBoxColorModel.setVisible(false);
		}
		if (!imageWorkingWith.getFormat().equals("")) {
			comboBoxFormat.setSelectedItem(imageWorkingWith.getFormat());
		}
		if (!imageWorkingWith.getChangeColorModel().equals("")) {
			this.rdbtnColor.setSelected(true);
			this.rdbtnMono.setSelected(false);
			comboBoxColorModel.setVisible(true);
			comboBoxColorModel.setSelectedItem(imageWorkingWith
					.getChangeColorModel());
		}
		if (imageWorkingWith.getQualityCompressionForJPEGImages() > 0
				&& imageWorkingWith.getQualityCompressionForJPEGImages() <= 100) {
			Double c = imageWorkingWith.getQualityCompressionForJPEGImages();
			txtCompression.setText(c.toString());
		}
		// thumbnails
		if (imageWorkingWith.getThumbnailWidth() > 0
				&& imageWorkingWith.getThumbnailWidth() <= 256) {
			chckbThumbnail.setSelected(true);
			pnlThumbnail.setVisible(true);
			Integer w = (Integer) imageWorkingWith.getThumbnailWidth();
			pnlThumbnail.getTxtWidth().setText(w.toString());
		}
		if (imageWorkingWith.getThumbnailHeight() > 0
				&& imageWorkingWith.getThumbnailHeight() <= 256) {
			chckbThumbnail.setSelected(true);
			pnlThumbnail.setVisible(true);
			Integer h = (Integer) imageWorkingWith.getThumbnailHeight();
			pnlThumbnail.getTxtHeight().setText(h.toString());
		}
		if (imageWorkingWith.getSizeHeight() > 0) {
			Integer sh = (Integer) imageWorkingWith.getSizeHeight();
			pnlManual.getTxtHeight().setText(sh.toString());
			pnlManual.getComboBox().setSelectedIndex(0);
			rdbtnManual.setSelected(true);
			rdbtnExtended.setSelected(false);

		}
		if (imageWorkingWith.getSizeWidth() > 0) {
			Integer hh = (Integer) imageWorkingWith.getSizeWidth();
			pnlManual.getTxtWidth().setText(hh.toString());
			pnlManual.getComboBox().setSelectedIndex(0);
			rdbtnManual.setSelected(true);
			rdbtnExtended.setSelected(false);

		}
		if (imageWorkingWith.getResizePercentage() > 0
				&& imageWorkingWith.getResizePercentage() <= 100) {
			Integer p = (Integer) imageWorkingWith.getResizePercentage();
			pnlManual.getTxtHeight().setText(p.toString());

			pnlManual.getComboBox().setSelectedIndex(1);
			this.rdbtnManual.setSelected(true);
			rdbtnExtended.setSelected(false);
		}
		if (imageWorkingWith.isParameterForResizeOfHeightIfBetween()
				|| imageWorkingWith.isParameterForResizeOfHeightIfMore()
				|| imageWorkingWith.isParameterForResizeOfHeightIfLess()
				|| imageWorkingWith.isParameterForResizeOfWidthIfBetween()
				|| imageWorkingWith.isParameterForResizeOfWidthIfMore()
				|| imageWorkingWith.isParameterForResizeOfWidthIfLess()) {
			this.rdbtnManual.setSelected(false);
			this.rdbtnExtended.setSelected(true);

			pnlExtended.setVisible(true);
			pnlManual.setVisible(false);

			if (imageWorkingWith.isParameterForResizeOfWidthIfLess()) {
				pnlExtended.getPnlWidth().rise();
				pnlExtended.getPnlHeight().freaze();

				pnlExtended.getPnlWidth().getChkbxLessHeight()
						.setSelected(true);
				if (imageWorkingWith.getSizeWidthToCheckIfLess() > 0) {
					Integer w = (Integer) imageWorkingWith
							.getSizeWidthToCheckIfLess();
					pnlExtended.getPnlWidth().getPanelLessHeight()
							.getThanSize().setText(w.toString());
					// set what state of chbox need to set
					setComboBoxMode(
							imageWorkingWith.getTypeOfLessWidthToCheck(),
							pnlExtended.getPnlWidth().getPanelLessHeight()
									.getComboBoxFirst());

				}
				if (imageWorkingWith.getSizeWidthIfLess() > 0) {
					Integer w = (Integer) imageWorkingWith.getSizeWidthIfLess();
					pnlExtended.getPnlWidth().getPanelLessHeight()
							.getResizeTo().setText(w.toString());
					// set combobox mode
					setComboBoxMode(
							imageWorkingWith.getTypeOfLessWidthToChange(),
							pnlExtended.getPnlWidth().getPanelLessHeight()
									.getComboBoxSecond());

				}
			}

			if (imageWorkingWith.isParameterForResizeOfWidthIfMore()) {
				pnlExtended.getPnlWidth().rise();
				pnlExtended.getPnlHeight().freaze();
				pnlExtended.getPnlWidth().getChkbxMoreHeight()
						.setSelected(true);

				if (imageWorkingWith.getSizeWidthToCheckIfMore() > 0) {
					Integer w = (Integer) imageWorkingWith
							.getSizeWidthToCheckIfMore();
					pnlExtended.getPnlWidth().getPanelMoreHeight()
							.getThanSize().setText(w.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfMoreWidthToCheck(),
							pnlExtended.getPnlWidth().getPanelMoreHeight()
									.getComboBoxFirst());
				}
				if (imageWorkingWith.getSizeWidthIfMore() > 0) {
					Integer w = (Integer) imageWorkingWith.getSizeWidthIfMore();
					pnlExtended.getPnlWidth().getPanelMoreHeight()
							.getResizeTo().setText(w.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfMoreWidthToChange(),
							pnlExtended.getPnlWidth().getPanelMoreHeight()
									.getComboBoxSecond());
				}
			}
			if (imageWorkingWith.isParameterForResizeOfWidthIfBetween()) {
				pnlExtended.getPnlWidth().rise();
				pnlExtended.getPnlHeight().freaze();
				pnlExtended.getPnlWidth().getChkbxBetweenHeight()
						.setSelected(true);
				if (imageWorkingWith.getSizeWidthToCheckIfBetweenFirst() > 0) {
					Integer w = (Integer) imageWorkingWith
							.getSizeWidthToCheckIfBetweenFirst();
					pnlExtended.getPnlWidth().getPanelBetweenHeight()
							.getTxtFirstSize().setText(w.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenWidthToCheck(),
							pnlExtended.getPnlWidth().getPanelBetweenHeight()
									.getComboBox());
				}
				if (imageWorkingWith.getSizeWidthToCheckIfBetweenSecond() > 0) {
					Integer w = (Integer) imageWorkingWith
							.getSizeWidthToCheckIfBetweenSecond();
					pnlExtended.getPnlWidth().getPanelBetweenHeight()
							.getTxtSecondSize().setText(w.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenWidthToCheck(),
							pnlExtended.getPnlWidth().getPanelBetweenHeight()
									.getComboBox_1());

				}
				if (imageWorkingWith.getSizeWidthIfBetween() > 0) {
					Integer w = (Integer) imageWorkingWith
							.getSizeWidthIfBetween();
					pnlExtended.getPnlWidth().getPanelBetweenHeight()
							.getTxtResizeTo().setText(w.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenWidthToChange(),
							pnlExtended.getPnlWidth().getPanelBetweenHeight()
									.getComboBox_2());
				}
			}
			if (imageWorkingWith.isParameterForResizeOfHeightIfLess()) {

				pnlExtended.getPnlWidth().freaze();
				pnlExtended.getPnlHeight().rise();

				pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
				pnlExtended.getPnlHeight().getChkbxLessHeight()
						.setSelected(true);
				if (imageWorkingWith.getSizeHeightToCheckIfLess() > 0) {
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightToCheckIfLess();
					pnlExtended.getPnlHeight().getPanelLessHeight()
							.getThanSize().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfLessHeightToCheck(),
							pnlExtended.getPnlHeight().getPanelLessHeight()
									.getComboBoxFirst());

				}
				if (imageWorkingWith.getSizeHeightIfLess() > 0) {
					pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightIfLess();
					pnlExtended.getPnlHeight().getPanelLessHeight()
							.getResizeTo().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfLessHeightToChange(),
							pnlExtended.getPnlHeight().getPanelLessHeight()
									.getComboBoxSecond());
				}
			}
			if (imageWorkingWith.isParameterForResizeOfHeightIfMore()) {

				pnlExtended.getPnlWidth().freaze();
				pnlExtended.getPnlHeight().rise();

				pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
				pnlExtended.getPnlHeight().getChkbxMoreHeight()
						.setSelected(true);
				if (imageWorkingWith.getSizeHeightToCheckIfMore() > 0) {
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightToCheckIfMore();
					pnlExtended.getPnlHeight().getPanelMoreHeight()
							.getThanSize().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfMoreHeightToCheck(),
							pnlExtended.getPnlHeight().getPanelMoreHeight()
									.getComboBoxFirst());
				}
				if (imageWorkingWith.getSizeHeightIfMore() > 0) {
					pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightIfMore();
					pnlExtended.getPnlHeight().getPanelMoreHeight()
							.getResizeTo().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfMoreHeightToChange(),
							pnlExtended.getPnlHeight().getPanelMoreHeight()
									.getComboBoxSecond());
				}
			}
			if (imageWorkingWith.isParameterForResizeOfHeightIfBetween()) {

				pnlExtended.getPnlWidth().freaze();
				pnlExtended.getPnlHeight().rise();

				pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
				pnlExtended.getPnlHeight().getChkbxBetweenHeight()
						.setSelected(true);
				if (imageWorkingWith.getSizeHeightToCheckIfBetweenFirst() > 0) {
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightToCheckIfBetweenFirst();
					pnlExtended.getPnlHeight().getPanelBetweenHeight()
							.getTxtFirstSize().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenHeightToCheck(),
							pnlExtended.getPnlHeight().getPanelBetweenHeight()
									.getComboBox());

				}
				if (imageWorkingWith.getSizeHeightToCheckIfBetweenSecond() > 0) {
					pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightToCheckIfBetweenSecond();
					pnlExtended.getPnlHeight().getPanelBetweenHeight()
							.getTxtSecondSize().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenHeightToCheck(),
							pnlExtended.getPnlHeight().getPanelBetweenHeight()
									.getComboBox_1());

				}
				if (imageWorkingWith.getSizeHeightIfBetween() > 0) {
					pnlExtended.getPnlHeight().getRdbtnMode().setSelected(true);
					Integer h = (Integer) imageWorkingWith
							.getSizeHeightIfBetween();
					pnlExtended.getPnlHeight().getPanelBetweenHeight()
							.getTxtResizeTo().setText(h.toString());

					setComboBoxMode(
							imageWorkingWith.getTypeOfBetweenHeightToChange(),
							pnlExtended.getPnlHeight().getPanelBetweenHeight()
									.getComboBox_2());
				}
			}
		}

        // naming settings
        renamingFormatTxt.setText(imageWorkingWith.getRenamingFormat());
        renamingThumbnailFormatTxt.setText(imageWorkingWith.getRenamingFormatThumbnail());
        // enable option
        renameFiles.setSelected(imageWorkingWith.shouldRenameFile());
        // update view
        showRenamingField();
	}

	/**
	 * Set selected combobox item
	 * 
	 * @param text
	 *            px or pt
	 * @param c
	 *            comboBox component
	 */
	private void setComboBoxMode(String text, JComboBox c) {
		if (text.equals("px")) {
			c.setSelectedIndex(0);
		} else if (text.equals("pt")) {
			c.setSelectedIndex(1);
		}

	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		dummy();

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		dummy();

	}

	private void dummy() {
		if ("".equals(txtDPI.getText())) {
			pnlManual.rise();
			pnlExtended.getPnlHeight().rise();
			pnlExtended.getPnlWidth().rise();
		} else {
			pnlManual.clean();
			pnlManual.freeze();
			pnlExtended.clean();
			pnlExtended.getPnlHeight().freaze();
			pnlExtended.getPnlWidth().freaze();

		}
	}

}
