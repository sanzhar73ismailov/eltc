package eltc.web.pageNavig.ajaxDelete;

import domain.Contract;
import eltc.model.EltcException;

public class ContractAjaxDelete extends AjaxDelete {

   Contract bean = new Contract();

    public ContractAjaxDelete(int id, String typeOfFile) throws EltcException {
        super(id, typeOfFile);
        createBean();
    }

    @Override
    public String getFileName() throws EltcException {
        if (typeOfFile.equalsIgnoreCase("pdf")) {
            return bean.getPdfFile();
        } else if (typeOfFile.equalsIgnoreCase("word")) {
            return bean.getWordFile();
        } else {
            throw new EltcException("Unknown type of file");
        }
    }

    @Override
    public void modifyObject() throws EltcException {
        if (typeOfFile.equalsIgnoreCase("pdf")) {
            bean.setPdfFile(null);
        } else if (typeOfFile.equalsIgnoreCase("word")) {
            bean.setWordFile(null);
        }else {
            throw new EltcException("Unknown type of file");
        }
    }

    @Override
    public void createBean() throws EltcException {
         bean = model.getObject(id, bean.getClass());
    }
}
