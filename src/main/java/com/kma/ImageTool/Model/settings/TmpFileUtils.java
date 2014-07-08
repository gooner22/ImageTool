package com.kma.ImageTool.Model.settings;

import com.kma.ImageTool.Log.LoggerUtils;

import java.io.*;
import java.util.logging.Level;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 09.07.14.
 */
public class TmpFileUtils {
    // TODO: replace with relative path
    public static final String TMP_WORKING_DIR_PATH = "/tmp/";

    public static void serializeObjectAtPath(String path, Serializable obj) {
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            LoggerUtils.getLogger().info("WorkingDirectoryPath saved into: " + path);
        }catch(IOException i)
        {
            LoggerUtils.getLogger().log(Level.SEVERE, "error", i);
        }
    }

    public static Serializable deserObjectAtPath(String path) {
        Serializable e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Serializable) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            LoggerUtils.getLogger().severe("Settings file doesn't exist: " + path);
        }catch(ClassNotFoundException c)
        {
            LoggerUtils.getLogger().log(Level.SEVERE, "WorkingDirectoryPath class not found", c);
            LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
        }
        return e;
    }

}
