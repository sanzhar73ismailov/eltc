package eltc.web.showBean.stringObjects;

import domain.Certificate;

public class CertificateObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        Certificate bean = (Certificate) object;
        return bean.getCode() + " " + bean.getName();
    }
}
