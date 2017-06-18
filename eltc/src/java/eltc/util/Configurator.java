/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.util;

import eltc.model.Model;
import eltc.model.ModelImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import domain.Configuration;
import eltc.model.EltcException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanzhar.ismailov
 */
public class Configurator {

    public final static String USER_SESSION = "userSession";
    public final static String INFO_MESSAGE = "infoMessage";
    public final static String RESOURSE_MESS = "resources.messages";
    // public final static boolean IS_TEST_STAGE = true;
    public final static boolean PRINT_STACK_TRACE = true;
    public final static String PASS_GENERAL = "elsieltc";
    public final static String PATH_TO_VIEW_FOLDER = "/WEB-INF/view/";
    public final static String TEST_MODE_STRING = "test_mode";
    //public final static String UPLOAD_DIRECTORY =  "C:/temp/uploads";
    private  final static String UPLOAD_DIRECTORY =  "upload_dir";
    
    private static Model model = ModelImpl.getInstance();

    public void met() {
        //How to get password from hibernate configuration
        System.out.println("hibernate.connection.password: " + new AnnotationConfiguration().getProperty("hibernate.connection.password"));
    }

    public static boolean isTestMode() {
        return getConfig(TEST_MODE_STRING);

    }
    
    
    public static String getUploadDir() {
        try {
            Configuration conf = model.getConfiguration(UPLOAD_DIRECTORY);
            if(conf == null){
                throw new EltcException("No such key in DB: " + UPLOAD_DIRECTORY);
            }
            return conf.getValue();
        } catch (EltcException ex) {
            Logger.getLogger(Configurator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean getConfig(String key) {

        boolean result = false;
        try {
            Configuration conf = model.getConfiguration(key);
            if (conf.getValue().equals("1")) {
                result = true;
            }
        } catch (EltcException ex) {
            Logger.getLogger(Configurator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void changeTestMode(String key, String value) throws EltcException {
        Configuration configOn = new Configuration(key, value);
        model.modifyObject(configOn);
    }

    public static void turnOnTestMode() throws EltcException {
        changeTestMode(TEST_MODE_STRING, "1");
    }

    public static void turnOffTestMode() throws EltcException {
        changeTestMode(TEST_MODE_STRING, "0");
    }

    public static void main(String[] args) throws EltcException {
//        Model model = ModelImpl.getInstance();
//        Configuration conf = model.getConfiguration("test_mode");
//        System.out.println("conf = " + conf.getId());
//        System.out.println("conf = " + conf.getValue());
        turnOffTestMode();
        System.out.println("isTestMode()=" + isTestMode());
        turnOnTestMode();
        System.out.println("isTestMode()=" + isTestMode());

    }
}
