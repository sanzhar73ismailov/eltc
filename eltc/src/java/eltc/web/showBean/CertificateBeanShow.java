package eltc.web.showBean;

import domain.Certificate;

public class CertificateBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Certificate bean = (Certificate) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("vendor"), getAsString(bean.getVendor()));
        map.put(rb.getString("code"), getAsString(bean.getCode()));
        map.put(rb.getString("name"), getAsString(bean.getName()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
