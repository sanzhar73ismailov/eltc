package domainComparators;

import domain.Email;
import java.util.Comparator;

public class EmailComparator implements Comparator<Email> {

    public int compare(Email o1, Email o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
