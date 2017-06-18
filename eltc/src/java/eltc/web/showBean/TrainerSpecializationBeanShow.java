package eltc.web.showBean;

import domain.TrainerSpecialization;

public class TrainerSpecializationBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        TrainerSpecialization bean = (TrainerSpecialization) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("specialization"), getAsString(bean.getSpecialization()));
        map.put(rb.getString("trainer"), getAsString(bean.getTrainer()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
