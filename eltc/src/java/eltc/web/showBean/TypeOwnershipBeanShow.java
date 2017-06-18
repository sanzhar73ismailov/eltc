package eltc.web.showBean;

import domain.TypeOwnership;

public class TypeOwnershipBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        TypeOwnership bean = (TypeOwnership) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("name"), getAsString(bean.getName()));
        map.put(rb.getString("nameFull"), getAsString(bean.getNameFull()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
