package eltc.web.showBean.stringObjects;

import domain.Sex;

public class SexObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        Sex sex = (Sex) object;
        return sex.getName();
    }
}
