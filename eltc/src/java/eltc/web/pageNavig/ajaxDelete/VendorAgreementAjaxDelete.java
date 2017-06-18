package eltc.web.pageNavig.ajaxDelete;

import domain.VendorAgreement;
import eltc.model.EltcException;

public class VendorAgreementAjaxDelete extends AjaxDelete {

    VendorAgreement bean = new VendorAgreement();

    public VendorAgreementAjaxDelete(int id, String typeOfFile) throws EltcException {
        super(id, typeOfFile);
        createBean();
    }

    @Override
    public String getFileName() throws EltcException {
        if (typeOfFile.equalsIgnoreCase("pdf")) {
            return bean.getPdfFile();
        } else {
            throw new EltcException("Unknown type of file");
        }
    }

    @Override
    public void modifyObject() throws EltcException {

        if (typeOfFile.equalsIgnoreCase("pdf")) {
            bean.setPdfFile(null);
        } else {
            throw new EltcException("Unknown type of file");
        }
    }

    @Override
    public void createBean() throws EltcException {
        bean = model.getObject(id, bean.getClass());
    }
}
