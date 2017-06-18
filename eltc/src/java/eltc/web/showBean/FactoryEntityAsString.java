package eltc.web.showBean;

import domain.*;
import eltc.web.DictionaryInterface;
import eltc.web.PersonInterface;
import eltc.web.showBean.stringObjects.*;
import java.util.Date;

public class FactoryEntityAsString {

    public static AbstractObject createObjectAsString(Object obj) {
        AbstractObject abstractObject = null;
        if (obj == null) {
            abstractObject = new NullObject();
        } else if (obj instanceof Sex) {
            abstractObject = new SexObject();
        } else if (obj instanceof Date) {
            abstractObject = new DateObject();
        } else if (obj instanceof DictionaryInterface) {
            abstractObject = new Dictionary();
        } else if (obj instanceof TypeOwnership) {
            abstractObject = new TypeOwnershipObject();
        } else if (obj instanceof Organization) {
            abstractObject = new OrganizationObject();
        } else if (obj instanceof Certificate) {
            abstractObject = new CertificateObject();
        } else if (obj instanceof Course) {
            abstractObject = new CourseObject();
        } else if (obj instanceof CourseOfficial) {
            abstractObject = new CourseOfficialObject();
        } else if (obj instanceof Timetable) {
            abstractObject = new TimetableObject();
        } else if (obj instanceof Contract) {
            abstractObject = new ContractObject();
        } else if (obj instanceof PersonInterface) {
            abstractObject = new PersonObject();
        } else if (obj instanceof Boolean) {
            abstractObject = new BooleanObject();
        } else if (obj instanceof Email) {
            abstractObject = new EmailObject();
        } else if (obj instanceof City) {
            abstractObject = new CityObject();
        } else {
            abstractObject = new StringObject();
        }
        return abstractObject;
    }
}
