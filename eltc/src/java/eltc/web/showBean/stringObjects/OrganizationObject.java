package eltc.web.showBean.stringObjects;

import domain.Organization;

public class OrganizationObject extends AbstractObject {

    public String getStringFromObject(Object object) {
       return ((Organization) object).getName();
    }

}
