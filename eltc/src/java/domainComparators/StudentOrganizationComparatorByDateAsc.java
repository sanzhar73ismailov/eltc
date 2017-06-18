package domainComparators;

import domain.*;
import java.util.Comparator;

public class StudentOrganizationComparatorByDateAsc implements Comparator<StudentOrganization> {

    public int compare(StudentOrganization obj1, StudentOrganization obj2) {
        return obj1.getDate().compareTo(obj2.getDate());
    }
}
