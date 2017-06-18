package eltc.web.showBean;

import domain.HrManager;

public class HrManagerBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        HrManager bean = (HrManager) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("sex"), getAsString(bean.getSex()));
        map.put(rb.getString("lastNameRu"), getAsString(bean.getLastNameRu()));
        map.put(rb.getString("firstNameRu"), getAsString(bean.getFirstNameRu()));
        map.put(rb.getString("patronicNameRu"), getAsString(bean.getPatronicNameRu()));
        map.put(rb.getString("lastNameEn"), getAsString(bean.getLastNameEn()));
        map.put(rb.getString("firstNameEn"), getAsString(bean.getFirstNameEn()));
        map.put(rb.getString("patronicNameEn"), getAsString(bean.getPatronicNameEn()));
        map.put(rb.getString("emailOffice"), getAsString(bean.getEmailOffice()));
        map.put(rb.getString("emailHome"), getAsString(bean.getEmailHome()));
        map.put(rb.getString("emailAdd"), getAsString(bean.getEmailAdd()));
        map.put(rb.getString("phoneHome"), getAsString(bean.getPhoneHome()));
        map.put(rb.getString("phoneMobile1"), getAsString(bean.getPhoneMobile1()));
        map.put(rb.getString("phoneMobile2"), getAsString(bean.getPhoneMobile2()));
        map.put(rb.getString("phoneOffice"), getAsString(bean.getPhoneOffice()));
        map.put(rb.getString("skype"), getAsString(bean.getSkype()));
        map.put(rb.getString("icq"), getAsString(bean.getIcq()));
        map.put(rb.getString("mailruAgent"), getAsString(bean.getMailruAgent()));
        
        map.put(rb.getString("cvDocFile"), bean.getCvDocFile()!= null ? getAsDownloadHref(bean.getId(), bean, "cvDoc") : "отсутствует");
        map.put(rb.getString("photoFile"), bean.getPhotoFile()!= null ? getAsDownloadHref(bean.getId(), bean, "photo") : "отсутствует");
        
        
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        return fromMapToWebString(map);
    }
}
