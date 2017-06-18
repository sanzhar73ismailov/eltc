package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public class VendorAgreementDownload extends Download{
 public VendorAgreementDownload(Object bean, String typeOfFile) {
        super(bean, typeOfFile);
    }

    @Override
    public String getFileName() throws EltcException {
        domain.VendorAgreement  beanUsed = (domain.VendorAgreement) bean;
        if (typeOfFile.equalsIgnoreCase("pdf")) {
            return beanUsed.getPdfFile();
        } else {
            throw new EltcException("Unknown type of file: " + typeOfFile);
        }
    }
}
