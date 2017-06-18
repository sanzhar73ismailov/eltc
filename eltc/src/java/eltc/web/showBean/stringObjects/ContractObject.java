package eltc.web.showBean.stringObjects;

import domain.Contract;

public class ContractObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        Contract bean = (Contract) object;
        return bean.getNumber()
                + " (внутр. ном.: " + bean.getNumberInternal() + ") "
                + getAsString(bean.getDate()) + " "
                + bean.getOrganization().getName();
    }
}
