package eltc.web.showBean;

import domain.City;
import eltc.web.DictionaryInterface;

public class DictionaryShowBean extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        DictionaryInterface student = (DictionaryInterface) entity;
        map.put(rb.getString("id"), getAsString(student.getId()));
        map.put(rb.getString("name"), getAsString(student.getName()));
        map.put(rb.getString("insertDatetime"), getAsString(student.getInsertDatetime()));
        map.put(rb.getString("user"), getAsString(student.getUser()));
        return fromMapToWebString(map);
    }
}
