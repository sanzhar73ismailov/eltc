package eltc.web.showBean;

import domain.OrganizationHrManager;

public class OrganizationHrManagerBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        OrganizationHrManager bean = (OrganizationHrManager) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("organization"), getAsString(bean.getOrganization()));
        map.put(rb.getString("hrManager"), getAsString(bean.getHrManager()));
        map.put(rb.getString("isActual"), getAsString(bean.getIsActual()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
