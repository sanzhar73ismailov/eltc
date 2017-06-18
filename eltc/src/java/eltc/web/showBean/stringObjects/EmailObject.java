package eltc.web.showBean.stringObjects;

import domain.Email;

public class EmailObject extends AbstractObject {

    @Override
    public String getStringFromObject(Object object) {
        Email bean = (Email) object;
        return bean.getEmail()
                + ", тип: " + bean.getEmailType().getName()
                + ", актуально: " + getAsString(bean.isIsActual())
                + ", подписано на рассылку: " + getAsString(bean.isSubscribe()
                );
    }
}
