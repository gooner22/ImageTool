package com.kma.ImageTool.Model.settings;

import java.io.*;

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
            System.out.println("WorkingDirectoryPath saved into: " + TMP_WORKING_DIR_PATH_SER);
        }catch(IOException i)
        {
            i.printStackTrace();
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
            System.out.println("Settings file doesn't exist: " + TMP_WORKING_DIR_PATH_SER);
        }catch(ClassNotFoundException c)
        {
            System.out.println("WorkingDirectoryPath class not found");
            c.printStackTrace();
        }
        return e;
    }
}
