package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * class that will hold all info about color model flattening, compression and
 * type of image
 * 
 * @author yaroslav
 * 
 */

public class HColorModel implements Handler {

	@Override
	public void execute(XmlWrapper wr, ImageParametrs ip) {

		// flattening
		if (wr.getChckbxFlattening().isSelected()) {
			ip.setFlatteningImage(true);
		}

		// color model
		if (wr.getRdbtnColor().isSelected()) {
			ip.setChangeToMono(false);
			ip.setChangeColorModel(wr.getComboBoxColorModel().getSelectedItem()
					.toString());
		} else {// instead of null
			ip.setChangeColorModel("");
		}

		// if mono selected
		if (wr.getRdbtnMono().isSelected()) {
			ip.setChangeToMono(true);
		}

		// format
		ip.setFormat(wr.getComboBoxFormat().getSelectedItem().toString());

		// compresion
		if (wr.getComboBoxFormat().getSelectedItem().equals("tiff")
				|| wr.getComboBoxFormat().getSelectedItem().equals("tif")
				|| wr.getComboBoxFormat().getSelectedItem().equals("jpeg")
				|| wr.getComboBoxFormat().getSelectedItem().equals("jpg")) {

			ip.setQualityCompressionForJPEGImages(wr.getTxtCompression()
					.getText());

		} else {
			ip.setQualityCompressionForJPEGImages("");
		}

	}

}
