package eltc.web.pageNavig.ajaxDelete;

import domain.Manager;
import eltc.model.EltcException;

public class ManagerAjaxDelete extends AjaxDelete{

    Manager bean = new Manager();

    public ManagerAjaxDelete(int id, String typeOfFile) throws EltcException {
        super(id, typeOfFile);
        createBean();
    }

   @Override
    public String getFileName() throws EltcException {
        if (typeOfFile.equalsIgnoreCase("cvDoc")) {
            return bean.getCvDocFile();
        } else if (typeOfFile.equalsIgnoreCase("photo")) {
            return bean.getPhotoFile();
        } else {
            throw new EltcException("Unknown type of file");
        }


    }

    @Override
    public void modifyObject() throws EltcException {


        if (typeOfFile.equalsIgnoreCase("cvDoc")) {
            bean.setCvDocFile(null);
        } else if (typeOfFile.equalsIgnoreCase("photo")) {
            bean.setPhotoFile(null);
        } else {
            throw new EltcException("Unknown type of file");
        }
    }

    @Override
    public void createBean() throws EltcException {
        bean = model.getObject(id, bean.getClass());
    }
}
