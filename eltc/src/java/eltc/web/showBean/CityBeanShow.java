package eltc.web.showBean;

import domain.City;

public class CityBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        City bean = (City) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("name"), getAsString(bean.getName()));
        map.put(rb.getString("country"), getAsString(bean.getCountry()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        return fromMapToWebString(map);
    }
}
