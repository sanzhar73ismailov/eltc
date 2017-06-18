/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import eltc.logger.MyLogger;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author sanzhar.ismailov
 */
public class AppListener implements ServletContextListener {

    private final static Logger LOGGER = Logger.getLogger(AppListener.class.getName());

    public void contextInitialized(ServletContextEvent sce) {
        try {
            // удалил настройку логирования, из-за проблем при clean и build проекта
            //MyLogger.setup(sce.getServletContext().getRealPath("log")); удалил
            
            if (1 == 0) {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
