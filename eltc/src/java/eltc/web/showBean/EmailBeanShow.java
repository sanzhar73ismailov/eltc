package eltc.web.showBean;

import domain.Email;

public class EmailBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Email bean = (Email) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("email"), getAsString(bean.getEmail()));
        map.put(rb.getString("student"), String.format("<a href='edit?entity=student&id=%s'>%s</a>", bean.getStudent().getId(), getAsString(bean.getStudent())));
        map.put(rb.getString("emailType"), getAsString(bean.getEmailType()));
        map.put(rb.getString("isActual"), getAsString(bean.isIsActual()));
        map.put(rb.getString("subscribe"), getAsString(bean.isSubscribe()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
