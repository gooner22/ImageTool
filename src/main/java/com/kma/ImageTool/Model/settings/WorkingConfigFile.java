package com.kma.ImageTool.Model.settings;

import java.io.File;
import java.io.Serializable;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 09.07.14.
 */
public class WorkingConfigFile implements Serializable {
    public static final String PATH = TmpFileUtils.TMP_WORKING_DIR_PATH + File.separator + "workingConfigFile.ser";

    final String templateName;

    public WorkingConfigFile(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void serialize(){
        TmpFileUtils.serializeObjectAtPath(PATH, this);
    }

    public static WorkingConfigFile getFromTmp()
    {
        return (WorkingConfigFile) TmpFileUtils.deserObjectAtPath(PATH);
    }

}
