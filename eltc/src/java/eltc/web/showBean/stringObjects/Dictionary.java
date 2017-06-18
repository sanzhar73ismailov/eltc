package eltc.web.showBean.stringObjects;

import eltc.web.DictionaryInterface;

public class Dictionary extends AbstractObject {

    public String getStringFromObject(Object object) {
        return ((DictionaryInterface) object).getName();
    }

}
