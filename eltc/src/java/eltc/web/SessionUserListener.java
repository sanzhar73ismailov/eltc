/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import eltc.util.Configurator;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author sanzhar.ismailov
 */
public class SessionUserListener implements HttpSessionAttributeListener {

    private static int activeUsers;

    public static int getActiveUsers() {
        return activeUsers;
    }


    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals(Configurator.USER_SESSION)) {
            activeUsers++;
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals(Configurator.USER_SESSION)) {
            activeUsers--;
        }

    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
