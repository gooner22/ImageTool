package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * Get String parametrs template name and resolution
 * 
 * @author yaroslav
 * 
 */
public class HNameDpi implements Handler {

	@Override
	public void execute(XmlWrapper wr, ImageParametrs ip) {
		// if need to check if empty set "" or default
		ip.setResolutionDPI(wr.getTxtDPI().getText());
	}

}
