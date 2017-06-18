package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public class ManagerDownload extends Download {

    public ManagerDownload(Object bean, String typeOfFile) {
        super(bean, typeOfFile);
    }

    @Override
    public String getFileName() throws EltcException {
        domain.Manager beanUsed = (domain.Manager) bean;
        if (typeOfFile.equalsIgnoreCase("cvDoc")) {
            return beanUsed.getCvDocFile();
        } else if (typeOfFile.equalsIgnoreCase("photo")) {
            return beanUsed.getPhotoFile();
        } else {
            throw new EltcException("Unknown type of file: " + typeOfFile);
        }
    }
}
