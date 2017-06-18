package eltc.web.pageNavig.download;

import eltc.model.EltcException;

public class TrainerDownload  extends Download {

    public TrainerDownload(Object bean, String typeOfFile) {
        super(bean, typeOfFile);
    }

    @Override
    public String getFileName() throws EltcException {
        domain.Trainer beanUsed = (domain.Trainer) bean;
        if (typeOfFile.equalsIgnoreCase("cvDoc")) {
            return beanUsed.getCvDocFile();
        } else if (typeOfFile.equalsIgnoreCase("photo")) {
            return beanUsed.getPhotoFile();
        } else {
            throw new EltcException("Unknown type of file: " + typeOfFile);
        }
    }
}
