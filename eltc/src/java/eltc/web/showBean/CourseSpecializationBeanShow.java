package eltc.web.showBean;

import domain.CourseSpecialization;

public class CourseSpecializationBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        CourseSpecialization bean = (CourseSpecialization) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("course"), getAsString(bean.getCourse()));
        map.put(rb.getString("specialization"), getAsString(bean.getSpecialization()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
