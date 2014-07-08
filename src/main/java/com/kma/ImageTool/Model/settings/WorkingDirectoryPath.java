package com.kma.ImageTool.Model.settings;

import java.io.*;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 05.07.14.
 */
public class WorkingDirectoryPath implements Serializable {
    public static final String PATH = TmpFileUtils.TMP_WORKING_DIR_PATH + File.separator + "workingDirPath.ser";

    final String path;

    public String getPath() {
        return path;
    }

    public WorkingDirectoryPath(String path) {
        this.path = path;
    }

    public void serialize(){
        TmpFileUtils.serializeObjectAtPath(PATH, this);
    }

    public static WorkingDirectoryPath getFromTmp()
    {
        return (WorkingDirectoryPath) TmpFileUtils.deserObjectAtPath(PATH);
    }


}
