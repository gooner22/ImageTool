package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * class get info about size parameters in manual mode aspect ration included in
 * this model
 * 
 * @author yaroslav
 * 
 */
public class HManualSize implements Handler {

	@Override
	public void execute(XmlWrapper wr, ImageParametrs ip) {

	

		// Resize manually
		if (wr.getRdbtnManual().isSelected()) {
			ip.setSizeIsManual(true);
			// check if percent
			if (wr.getPnlManual().isPerCent()) {
				ip.setPerCent(true);
				ip.setResizePercentage(wr.getPnlManual().getTxtHeight()
						.getText());
			}// END percent
			else {// width in manually
				ip.setSizeWidth(wr.getPnlManual().getTxtWidth().getText());
				ip.setSizeHeight(wr.getPnlManual().getTxtHeight().getText());

			}
		}// end manually

	}

}
