package eltc.web.showBean;

import domain.CourseOfficialPrice;

public class CourseOfficialPriceBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        CourseOfficialPrice bean = (CourseOfficialPrice) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("currency"), getAsString(bean.getCurrency()));
        map.put(rb.getString("courseOfficial"), getAsString(bean.getCourseOfficial()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("price"), getAsString(bean.getPrice()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
