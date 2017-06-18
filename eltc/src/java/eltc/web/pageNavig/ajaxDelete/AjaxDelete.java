package eltc.web.pageNavig.ajaxDelete;

import eltc.model.EltcException;
import eltc.model.Model;
import eltc.model.ModelImpl;
import eltc.web.pageNavig.EntityEnum;

public abstract class AjaxDelete <T> {

    protected int id;
    protected Model model = ModelImpl.getInstance();
        protected String typeOfFile;

    public AjaxDelete(int id, String typeOfFilel) throws EltcException {
        this.id = id;
        this.typeOfFile = typeOfFilel;
        
    }

    public abstract String getFileName() throws EltcException;

    public abstract void modifyObject() throws EltcException;

    public abstract void createBean() throws EltcException;
}
