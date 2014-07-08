package com.kma.ImageTool.Model.settings;

import com.kma.ImageTool.Log.LoggerUtils;

import java.io.*;
import java.util.logging.Level;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 05.07.14.
 */
public class WorkingDirectoryPath implements Serializable {
    public static final String TMP_WORKING_DIR_PATH_SER = "/tmp/workingDirPath.ser";

    final String path;

    public String getPath() {
        return path;
    }

    public WorkingDirectoryPath(String path) {
        this.path = path;
    }

    public void serializa(){
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(TMP_WORKING_DIR_PATH_SER);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            LoggerUtils.getLogger().info("WorkingDirectoryPath saved into: " + TMP_WORKING_DIR_PATH_SER);
        }catch(IOException i)
        {
            LoggerUtils.getLogger().log(Level.SEVERE, "error", i);
        }
    }

    public static WorkingDirectoryPath getFromTmp()
    {
        WorkingDirectoryPath e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(TMP_WORKING_DIR_PATH_SER);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (WorkingDirectoryPath) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            LoggerUtils.getLogger().severe("Settings file doesn't exist: " + TMP_WORKING_DIR_PATH_SER);
        }catch(ClassNotFoundException c)
        {
            LoggerUtils.getLogger().log(Level.SEVERE, "WorkingDirectoryPath class not found", c);
            LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
        }
        return e;
    }
}
