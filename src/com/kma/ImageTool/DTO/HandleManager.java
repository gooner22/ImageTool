package com.kma.ImageTool.DTO;

import java.util.ArrayList;

import com.kma.ImageTool.View.XmlWrapper;

public class HandleManager {

	private ImageParametrs image;
	private ArrayList<Handler> handlers;

	public HandleManager() {
		handlers = new ArrayList<Handler>();
		image = new ImageParametrs();
	}

	/**
	 * Start chain of responsibility to hold data from
	 * 
	 * @param xml
	 *            that we get
	 * @return completed {@link ImageParametrs}
	 */
	public ImageParametrs getImageParamets(XmlWrapper xml) {

		// iterate for our Handler collection
		// and hold info from XmlWarapper
		for (Handler h : handlers) {
			h.execute(xml, image);
		}

		return image;
	}

	/**
	 * To add new handler to chain
	 * 
	 * @param h
	 *            handler {@link Handler} that we want to use
	 */
	public void registerHandler(Handler h) {
		handlers.add(h);
	}

}
