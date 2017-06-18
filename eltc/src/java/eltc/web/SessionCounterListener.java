/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author sanzhar.ismailov
 */
public class SessionCounterListener implements HttpSessionListener {

    private static int activeSessions;

    public static int getActiveSessions() {
        return activeSessions;
    }
    
    

    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions--;
    }
}
