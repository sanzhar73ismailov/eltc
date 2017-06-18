package eltc.web.showBean;

import domain.Email;
import domain.Organization;
import domain.StudentOrganization;
import domain.TimetableStudent;
import domainComparators.EmailComparator;
import domainComparators.StudentOrganizationComparatorByDateAsc;
import eltc.web.pageNavig.EntityEnum;
import java.util.List;

public class OrganizationBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Organization bean = (Organization) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("industry"), getAsString(bean.getIndustry()));
        map.put(rb.getString("region"), getAsString(bean.getRegion()));
        map.put(rb.getString("locality"), getAsString(bean.getLocality()));
        map.put(rb.getString("typeOwnership"), getAsString(bean.getTypeOwnership()));
        map.put(rb.getString("streetHouseFact"), getAsString(bean.getStreetHouseFact()));
        map.put(rb.getString("streetHouseOfficial"), getAsString(bean.getStreetHouseOfficial()));
        map.put(rb.getString("vendor"), getAsString(bean.getVendor()));
        map.put(rb.getString("cityByCityOfficialId"), getAsString(bean.getCityByCityOfficialId()));
        map.put(rb.getString("cityByCityFactId"), getAsString(bean.getCityByCityFactId()));
        map.put(rb.getString("name"), getAsString(bean.getName()));
        map.put(rb.getString("nameEn"), getAsString(bean.getNameEn()));
        map.put(rb.getString("postalCodeOfficial"), getAsString(bean.getPostalCodeOfficial()));
        map.put(rb.getString("postalCodeFact"), getAsString(bean.getPostalCodeFact()));
        map.put(rb.getString("fax"), getAsString(bean.getFax()));
        map.put(rb.getString("internetSite"), getAsString(bean.getInternetSite()));
        map.put(rb.getString("email"), getAsString(bean.getEmail()));
        map.put(rb.getString("rnn"), getAsString(bean.getRnn()));
        map.put(rb.getString("bin"), getAsString(bean.getBin()));
        map.put(rb.getString("kbe"), getAsString(bean.getKbe()));
        map.put(rb.getString("bankName"), getAsString(bean.getBankName()));
        map.put(rb.getString("bankAddress"), getAsString(bean.getBankAddress()));
        map.put(rb.getString("bic"), getAsString(bean.getBic()));
        map.put(rb.getString("accountTg"), getAsString(bean.getAccountTg()));
        map.put(rb.getString("accountDollar"), getAsString(bean.getAccountDollar()));
        map.put(rb.getString("accountRuble"), getAsString(bean.getAccountRuble()));
        map.put(rb.getString("accountEuro"), getAsString(bean.getAccountEuro()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));

        List<StudentOrganization> studentOrgList =
                getSortedListFromSet(bean.getStudentOrganizations(), new StudentOrganizationComparatorByDateAsc());
        String key = rb.getString("students");
        String value = "<div class='studentsOf'>";
        for (int i = 0; i < studentOrgList.size(); i++) {
            StudentOrganization element = studentOrgList.get(i);
            domain.Student student = element.getStudent();
            value += (i + 1) + ". ";
            value += getAsString(element.getStudent())
                    + " " + getAsViewHref(student.getId(), student) + " " + getAsEditHref(student.getId(), student)
                    + "<br/>";
        }
        value += "</div>";
        map.put(key, value);
        return fromMapToWebString(map);
    }

    public static void main(String[] args) {
//        EntityEnum enum1 = EntityEnum.STUDENT;
//        System.out.println(getAsEditHref(123, new domain.Student())); 
//        System.out.println(getAsViewHref(190, new domain.Student())); 
    }
}
