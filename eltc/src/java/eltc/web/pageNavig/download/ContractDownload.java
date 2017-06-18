package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public class ContractDownload extends Download {

    public ContractDownload(Object bean, String typeOfFile) {
        super(bean, typeOfFile);
    }

    @Override
    public String getFileName() throws EltcException {
        domain.Contract beanUsed = (domain.Contract) bean;
        if (typeOfFile.equalsIgnoreCase("pdf")) {
            return beanUsed.getPdfFile();
        } else if (typeOfFile.equalsIgnoreCase("word")) {
            return beanUsed.getWordFile();
        } else {
            throw new EltcException("Unknown type of file: " + typeOfFile);
        }
    }
}
