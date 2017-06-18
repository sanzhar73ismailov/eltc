package eltc.web.showBean;

import domain.CourseOfficial;

public class CourseOfficialBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        CourseOfficial bean = (CourseOfficial) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("course"), getAsString(bean.getCourse()));
        map.put(rb.getString("courseType"), getAsString(bean.getCourseType()));
        map.put(rb.getString("code"), getAsString(bean.getCode()));
        map.put(rb.getString("additionalInfo"), getAsString(bean.getAdditionalInfo()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}