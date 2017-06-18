package eltc.web.showBean;

import domain.StudentOrganization;

public class StudentOrganizationBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        StudentOrganization bean = (StudentOrganization) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("student"), String.format("<a href='edit?entity=student&id=%s'>%s</a>", bean.getStudent().getId(), getAsString(bean.getStudent())));
        map.put(rb.getString("organization"), String.format("<a href='edit?entity=organization&id=%s'>%s</a>", bean.getOrganization().getId(), getAsString(bean.getOrganization())));
        map.put(rb.getString("department"), getAsString(bean.getDepartment()));
        map.put(rb.getString("status"), getAsString(bean.getStatus()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
