package eltc.web.showBean;

import domain.Course;

public class CourseBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Course bean = (Course) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("vendor"), getAsString(bean.getVendor()));
        map.put(rb.getString("codeOwn"), getAsString(bean.getCodeOwn()));
        map.put(rb.getString("nameOriginal"), getAsString(bean.getNameOriginal()));
        map.put(rb.getString("nameRu"), getAsString(bean.getNameRu()));
        map.put(rb.getString("discriptionEn"), getAsString(bean.getDiscriptionEn()));
        map.put(rb.getString("discriptionRu"), getAsString(bean.getDiscriptionRu()));
        map.put(rb.getString("category"), getAsString(bean.getCategory()));
        map.put(rb.getString("durationDays"), getAsString(bean.getDurationDays()));
        map.put(rb.getString("durationHours"), getAsString(bean.getDurationHours()));
        map.put(rb.getString("additionalInfo"), getAsString(bean.getAdditionalInfo()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}