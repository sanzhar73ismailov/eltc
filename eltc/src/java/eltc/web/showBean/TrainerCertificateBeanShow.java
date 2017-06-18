package eltc.web.showBean;

import domain.TrainerCertificate;

public class TrainerCertificateBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        TrainerCertificate bean = (TrainerCertificate) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("certificate"), getAsString(bean.getCertificate()));
        map.put(rb.getString("trainer"), getAsString(bean.getTrainer()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
