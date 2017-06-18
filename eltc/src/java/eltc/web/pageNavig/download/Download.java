package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public abstract class Download {

    Object bean;
    String typeOfFile;

    public Download(Object bean, String typeOfFile) {
        this.bean = bean;
        this.typeOfFile = typeOfFile;
    }

    
    
    
    
    public abstract String getFileName() throws EltcException;
    
    
}
