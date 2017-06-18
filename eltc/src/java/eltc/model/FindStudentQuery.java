package eltc.model;

import domain.Email;
import domain.Student;
import eltc.web.ServletUtilMethods;
import java.util.List;

public class FindStudentQuery implements FindQuery {

    private Student studentToFind;
    private Email emailToFind;
    private static String QUERY_FIND_STUDENTS_BY_LOCAL =
            " from Student AS s "
            + " left join s.emails AS e \n"
            + " where 1=1 "
            + " %s \n"
            + " %s \n"
            + " %s \n"
            + " %s \n"
            + " AND  s.deleted = '0' "
            + " group by s.id "
            + " order by s.id  ";

    public FindStudentQuery(Object objectToFind) {
        this.studentToFind = (Student) objectToFind;
        this.emailToFind = getEmailOfStudent(studentToFind);
    }

    @Override
    public String createFindQuery() {
        return "select s " + createCommonQuery();
    }

    private Email getEmailOfStudent(Student st) {
        Email email = null;
        List<Email> listEmails = ServletUtilMethods.getListfromSet(st.getEmails());
        if (listEmails.size() > 0) {
            email = listEmails.get(0);
        }
        return email;
    }

    @Override
    public String createGetSizeQuery() {
        return "select count(*) " + createCommonQuery();
    }

    private String createCommonQuery() {
        String commonQuery =
                String.format(QUERY_FIND_STUDENTS_BY_LOCAL,
                studentToFind.getLastNameRu() == null || studentToFind.getLastNameRu().isEmpty()
                ? "" : String.format("and s.lastNameRu like '%%%s%%'", studentToFind.getLastNameRu()),
                studentToFind.getFirstNameRu() == null || studentToFind.getFirstNameRu().isEmpty()
                ? "" : String.format("and s.firstNameRu like '%%%s%%'", studentToFind.getFirstNameRu()),
                studentToFind.getComments() == null || studentToFind.getComments().isEmpty()
                ? "" : String.format("and s.comments like '%%%s%%'", studentToFind.getComments()),
                emailToFind == null || emailToFind.getEmail() == null || emailToFind.getEmail().isEmpty()
                ? "" : String.format("and e.email like '%%%s%%'", emailToFind.getEmail()));
        return commonQuery;
    }
}
