package eltc.web.showBean;

import domain.TrainerPassedCourse;

public class TrainerPassedCourseBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        TrainerPassedCourse bean = (TrainerPassedCourse) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("course"), getAsString(bean.getCourse()));
        map.put(rb.getString("trainer"), getAsString(bean.getTrainer()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
