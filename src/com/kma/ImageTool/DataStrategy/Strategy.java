package com.kma.ImageTool.DataStrategy;

import com.kma.ImageTool.DTO.ImageParametrs;
import com.kma.ImageTool.View.XmlWrapper;

/**
 * An abstract class to make holding data from xmlEditor
 * 
 * @author yaroslav
 * 
 */

public abstract class Strategy {

	private ImageParametrs image;

	public abstract void execute(XmlWrapper wr);

	public ImageParametrs getImage() {
		return image;
	}

	public void setImage(ImageParametrs image) {
		this.image = image;
	}

}
