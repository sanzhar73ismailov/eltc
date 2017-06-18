package eltc.web.showBean;

import domain.City;
import eltc.web.showBean.stringObjects.AbstractObject;

class CityObject extends AbstractObject {

    public CityObject() {
    }

    @Override
    public String getStringFromObject(Object object) {
         City bean = (City) object;
        return bean.getName();
    }

}
