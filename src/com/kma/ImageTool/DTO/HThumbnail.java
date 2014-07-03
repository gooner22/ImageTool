package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * class holds data about thumbnail parameters if checkBox checked
 * 
 * @author yaroslav
 * 
 */
public class HThumbnail implements Handler {

	@Override
	public void execute(XmlWrapper wr, ImageParametrs ip) {
		if (wr.getChckbThumbnail().isSelected()) {
			ip.setThumbnailHeight(wr.getPnlThumbnail().getTxtHeight().getText());
			ip.setThumbnailWidth(wr.getPnlThumbnail().getTxtWidth().getText());
		}

	}

}
