package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * Interface for chain of responsibility every little part of {@link XmlWrapper}
 * will handled by ancestor of Handler in HandlerManager
 * 
 * @author yaroslav
 * 
 */
public interface Handler {

	public void execute(XmlWrapper wr, ImageParametrs ip);

}
