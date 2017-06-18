package eltc.test;

import eltc.model.*;
import domain.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanzhar.ismailov Тестовый класс для создания нового потока для
 * тестирования и отладки Hibernate
 */
public class MyThreadClass implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(MyThreadClass.class.getName());

    public MyThreadClass() {
        
    }


    
    public void run() {
        eltc.model.Model model = ModelImpl.getInstance();
        try {
            
            LOGGER.info("Thread with id: " + Thread.currentThread().getId() + " runned");
            
            final Object object = model.getObject(1478, Student.class);
            System.out.println("object = " + object);

        } catch (EltcException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

}
