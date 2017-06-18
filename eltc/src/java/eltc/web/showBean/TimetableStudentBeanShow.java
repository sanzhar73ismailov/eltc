package eltc.web.showBean;

import domain.TimetableStudent;

public class TimetableStudentBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        TimetableStudent bean = (TimetableStudent) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("manager"), getAsString(bean.getManager()));
        map.put(rb.getString("courseOfficial"), getAsString(bean.getCourseOfficial()));
        map.put(rb.getString("student"), getAsString(bean.getStudent()));
        map.put(rb.getString("timetable"), getAsString(bean.getTimetable()));
        map.put(rb.getString("contract"), getAsString(bean.getContract()));
        map.put(rb.getString("priceFact"), getAsString(bean.getPriceFact()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
