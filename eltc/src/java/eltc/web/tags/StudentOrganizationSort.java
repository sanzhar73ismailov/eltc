package eltc.web.tags;

import domain.StudentOrganization;
import domainComparators.StudentOrganizationComparatorByDateAsc;
import eltc.web.ServletUtilMethods;
import java.util.List;
import java.util.Set;

public final class StudentOrganizationSort {
public static List<StudentOrganization> sortByDate(Set studentOrganizationSet) {
        return ServletUtilMethods.getSortedListFromSet(studentOrganizationSet, new StudentOrganizationComparatorByDateAsc());
    }
}
