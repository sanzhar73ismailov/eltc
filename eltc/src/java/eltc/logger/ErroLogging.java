package eltc.logger;

import eltc.util.Configurator;

public class ErroLogging {

   public static  void prinStackMessage(Exception e) {
        if (Configurator.PRINT_STACK_TRACE) {
            e.printStackTrace();
        }
    }
}
