package eltc.web.showBean.stringObjects;

import eltc.web.PersonInterface;

public class PersonObject extends AbstractObject {

    @Override
    public String getStringFromObject(Object object) {
        PersonInterface bean = (PersonInterface) object;
        return getTranslateString("id")+ " "+ bean.getId()+ " " + bean.getLastNameRu() + " " + bean.getFirstNameRu()
                + " " + bean.getPatronicNameRu() + ", "
                + getAsString(bean.getDateOfBirth());
    }
}
