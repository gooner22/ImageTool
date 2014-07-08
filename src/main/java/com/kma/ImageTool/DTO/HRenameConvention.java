package com.kma.ImageTool.DTO;

import com.kma.ImageTool.View.XmlWrapper;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 05.07.14.
 */
public class HRenameConvention implements Handler{
    @Override
    public void execute(XmlWrapper wr, ImageParametrs ip) {
        ip.setShouldRenameFile(wr.getRenameFiles().isSelected());
        ip.setRenamingFormat(wr.getRenamingFormatTxt().getText());
        ip.setThumbnailRenamingFormat(wr.getRenamingThumbnailFormatTxt().getText());
        ip.setTemplateName(wr.getTxtName().getText());
    }
}
