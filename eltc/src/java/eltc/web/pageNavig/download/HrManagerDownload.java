package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public class HrManagerDownload extends Download {

    public HrManagerDownload(Object bean, String typeOfFile) {
        super(bean, typeOfFile);
    }

    @Override
    public String getFileName() throws EltcException {
        domain.HrManager beanUsed = (domain.HrManager) bean;
        if (typeOfFile.equalsIgnoreCase("cvDoc")) {
            return beanUsed.getCvDocFile();
        } else if (typeOfFile.equalsIgnoreCase("photo")) {
            return beanUsed.getPhotoFile();
        } else {
            throw new EltcException("Unknown type of file: " + typeOfFile);
        }
    }
}
