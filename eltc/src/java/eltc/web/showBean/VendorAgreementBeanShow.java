package eltc.web.showBean;

import domain.VendorAgreement;

public class VendorAgreementBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        VendorAgreement bean = (VendorAgreement) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("vendor"), getAsString(bean.getVendor()));
        map.put(rb.getString("number"), getAsString(bean.getNumber()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("description"), getAsString(bean.getDescription()));
        
        map.put(rb.getString("pdfFile"), bean.getPdfFile() != null ? getAsDownloadHref(bean.getId(), bean, "pdf") : "отсутствует");
        
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
