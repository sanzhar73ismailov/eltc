package eltc.web.showBean;

import domain.Email;
import domain.Student;
import domain.StudentOrganization;
import domain.TimetableStudent;
import domainComparators.EmailComparator;
import domainComparators.StudentOrganizationComparatorByDateAsc;
import domainComparators.StudentTimeTableComparatorByLastNameAsc;
import java.util.List;

public class StudentBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Student bean = (Student) entity;
        String key;
        StringBuffer valueStrBuffer = new StringBuffer();
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("sex"), getAsString(bean.getSex()));
        
        valueStrBuffer.delete(0, valueStrBuffer.length());
        
        key = rb.getString("LFP");
        valueStrBuffer.append(getAsString(bean.getLastNameRu()) + " ");
        valueStrBuffer.append(getAsString(bean.getFirstNameRu()) + " ");
        valueStrBuffer.append(getAsString(bean.getPatronicNameRu()));
        map.put(key, valueStrBuffer.toString());
        
        valueStrBuffer.delete(0, valueStrBuffer.length());
        
        key = rb.getString("LFP") + "на англ.";
        valueStrBuffer.append(getAsString(bean.getLastNameEn()) + " ");
        valueStrBuffer.append(getAsString(bean.getFirstNameEn()) + " ");
        valueStrBuffer.append(getAsString(bean.getPatronicNameEn()));
        map.put(key, valueStrBuffer.toString());
        
        
        map.put(rb.getString("dateOfBirth"), getAsString(bean.getDateOfBirth()));
        map.put(rb.getString("phoneHome"), getAsString(bean.getPhoneHome()));
        map.put(rb.getString("phoneMobile1"), getAsString(bean.getPhoneMobile1()));
        map.put(rb.getString("phoneMobile2"), getAsString(bean.getPhoneMobile2()));
        map.put(rb.getString("phoneOffice"), getAsString(bean.getPhoneOffice()));
        map.put(rb.getString("skype"), getAsString(bean.getSkype()));
        map.put(rb.getString("icq"), getAsString(bean.getIcq()));
        map.put(rb.getString("mailruAgent"), getAsString(bean.getMailruAgent()));
        map.put(rb.getString("comments"), getAsString(bean.getComments()));
        map.put(rb.getString("photo"), getAsString(bean.getPhoto()));
        map.put(rb.getString("personVueIdent"), getAsString(bean.getPersonVueIdent()));
        map.put(rb.getString("prometricIdent"), getAsString(bean.getPrometricIdent()));
        map.put(rb.getString("oracleLogin"), getAsString(bean.getOracleLogin()));
        map.put(rb.getString("microsoftLogin"), getAsString(bean.getMicrosoftLogin()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));

        valueStrBuffer.delete(0, valueStrBuffer.length());
        
        List<Email> emailList = getSortedListFromSet(bean.getEmails(), new EmailComparator());
        key = rb.getString("emails");
        valueStrBuffer.append("<div class='emailsOf'>");
        for (int i = 0; i < emailList.size(); i++) {
            valueStrBuffer.append((i + 1) + ". " + getAsString(emailList.get(i)));
        }
        valueStrBuffer.append("</div>");
        map.put(key, valueStrBuffer.toString());
        
        valueStrBuffer.delete(0, valueStrBuffer.length());
        
        List<StudentOrganization> studentOrgList =
                getSortedListFromSet(bean.getStudentOrganizations(), new StudentOrganizationComparatorByDateAsc());
        key = rb.getString("organizations");
        valueStrBuffer.append("<div class='organizationsOf'>");
        for (int i = 0; i < studentOrgList.size(); i++) {
            StudentOrganization element = studentOrgList.get(i);
            valueStrBuffer.append((i + 1) + ". " + getAsString(element.getOrganization())
                    + String.format("(%s \"%s\", %s)",
                    rb.getString("department"),
                    getAsString(element.getDepartment()),
                    getAsString(element.getDate()))
                    + "<br/>");
        }
        valueStrBuffer.append("</div>");
        map.put(key, valueStrBuffer.toString());

        valueStrBuffer.delete(0, valueStrBuffer.length());
        
        List<TimetableStudent> studentTimeTableList =
                getSortedListFromSet(bean.getTimetableStudents(), new StudentTimeTableComparatorByLastNameAsc());
        key = rb.getString("coursesFinished");
        valueStrBuffer.append("<div class='coursesOf'>");
        for (int i = 0; i < studentTimeTableList.size(); i++) {
            TimetableStudent element = studentTimeTableList.get(i);
            domain.Timetable timeTable = element.getTimetable();
            valueStrBuffer.append((i + 1) + ". ");
            valueStrBuffer.append(getAsString(timeTable)
                    + " " + getAsViewHref(timeTable.getId(), timeTable)
                    + "<br/>");
        }
        valueStrBuffer.append("</div>");
        map.put(key, valueStrBuffer.toString());


        return fromMapToWebString(map);
    }
}
