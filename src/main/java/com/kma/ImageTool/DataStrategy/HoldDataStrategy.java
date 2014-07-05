package com.kma.ImageTool.DataStrategy;

import com.kma.ImageTool.DTO.*;
import com.kma.ImageTool.View.XmlWrapper;

/**
 * Save data to {@link ImageParametrs} object strategy and write into xml file
 * 
 */
public class HoldDataStrategy extends Strategy {

	@Override
	public void execute(XmlWrapper wr) {
		HandleManager manager = new HandleManager();

		// register elements of chain
		manager.registerHandler(new HColorModel());
		manager.registerHandler(new HExtended());
		manager.registerHandler(new HManualSize());
		manager.registerHandler(new HNameDpi());
		manager.registerHandler(new HThumbnail());
		manager.registerHandler(new HRenameConvention());


		super.setImage(manager.getImageParamets(wr));

		com.kma.ImageTool.Model.Model.GET.doSaveXmlFile(super.getImage());

	}// END execute

}
