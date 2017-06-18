package eltc.web.showBean.stringObjects;

import domain.TypeOwnership;

public class TypeOwnershipObject extends AbstractObject {

    @Override
    public String getStringFromObject(Object object) {
        return ((TypeOwnership) object).getNameFull();
    }

}
