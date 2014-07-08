package com.kma.ImageTool.Log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 07.07.14.
 */
public class LoggerUtils {

    private static Logger mainLogger = null;

    public static Logger getLogger(){
        if (mainLogger == null) {
            Logger logger = Logger.getLogger("Logger");
            FileHandler fh;

            try {

                // This block configure the logger with handler and formatter
                fh = new FileHandler("log.txt");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);

                // the following statement is used to log any messages
                logger.info("Logger started");

            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mainLogger = logger;
        }

        return mainLogger;
    }
}
