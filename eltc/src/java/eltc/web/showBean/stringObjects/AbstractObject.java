package eltc.web.showBean.stringObjects;

import eltc.web.ServletUtilMethods;
import eltc.web.showBean.FactoryEntityAsString;

public abstract class AbstractObject {

    public abstract String getStringFromObject(Object object);

    protected String getAsString(Object object) {
        AbstractObject abstractObject = FactoryEntityAsString.createObjectAsString(object);
        return abstractObject.getStringFromObject(object);
    }
    
    protected String getTranslateString(String value){
        return ServletUtilMethods.getTranString(value);
    }
}
