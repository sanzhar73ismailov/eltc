package domainComparators;

import domain.StudentOrganization;
import domain.TimetableStudent;
import java.util.Comparator;

public class StudentTimeTableComparatorByLastNameAsc implements Comparator<TimetableStudent> {

    public int compare(TimetableStudent obj1, TimetableStudent obj2) {
        return obj1.getStudent().getLastNameRu().compareTo(obj2.getStudent().getLastNameRu());
    }
}
