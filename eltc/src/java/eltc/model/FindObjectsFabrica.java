package eltc.model;

import domain.Organization;
import domain.Student;

public class FindObjectsFabrica {

    public static FindQuery createFindQueryObject(Object objectToFind) throws EltcException {
        if (objectToFind instanceof Student) {
            return new FindStudentQuery(objectToFind);
        } else if (objectToFind instanceof Organization) {
            return new FindOrganizationQuery(objectToFind);
        }else{
            throw new EltcException("поиск такого объекта: "+ objectToFind.getClass() +" не предусмотрен");
        }
    }
}
