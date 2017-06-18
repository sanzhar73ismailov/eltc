/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author sanzhar.ismailov
 */
public class MyLogger {

    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    public static void setup(String path) throws IOException {

        // Get the global logger to configure it
        Logger logger = Logger.getLogger("");
        
        
        final ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(new ConsoleHandler());

        logger.setLevel(Level.ALL);
        fileTxt = new FileHandler(path + File.separator + "Logging.txt");
        fileHTML = new FileHandler(path + File.separator + "Logging.html");
        fileTxt.setLevel(Level.FINEST);
        fileHTML.setLevel(Level.FINEST);
        System.out.println("fileTxt=" + fileTxt.getLevel());
        System.out.println("fileHTML=" + fileHTML.getLevel());



        // Create txt Formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // Create HTML Formatter
        formatterHTML = new MyHtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);

//        Handler[] handlers =
//                logger.getHandlers();
//        for (int index = 0; index < handlers.length; index++) {
//            handlers[index].setLevel(Level.FINEST);
//        }

    }
}
