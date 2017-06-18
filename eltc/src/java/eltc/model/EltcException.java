package eltc.model;

public class EltcException  extends Exception{

    public EltcException() {
        super("EltcException");
    }

    public EltcException(String message) {
        super(message);
    }

    public EltcException(String message, Throwable cause) {
        super(message, cause);
    }
 

}
