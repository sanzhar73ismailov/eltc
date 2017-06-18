package eltc.web.createBeans;

import domain.Organization;
import domain.Student;
import domain.StudentOrganization;
import eltc.model.EltcException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class CreateStudentOrganization extends AbstractCreateBean {

    public CreateStudentOrganization(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        StudentOrganization bean = new StudentOrganization();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Student student = getObjectIfIdIsNumber(Student.class, request, "student");
        bean.setStudent(student);
        Organization organization = getObjectIfIdIsNumber(Organization.class, request, "organization");;
        bean.setOrganization(organization);

        bean.setDepartment(getNullifEmpty(request.getParameter("department")));
        bean.setStatus(getNullifEmpty(request.getParameter("status")));

        Date date = getDateFromString(request.getParameter("date"));
        bean.setDate(date);

        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        StudentOrganization bean = new StudentOrganization();
        String ext = "_" + getCount();
        bean.setId(null);
        Student st = new Student();
        st.setId(getRandomMaxLimit(3));
        bean.setStudent(st);
        Organization org = new Organization();
        org.setId(getRandomMaxLimit(3));
        bean.setOrganization(org);
        bean.setDepartment("dep" + ext);
        bean.setStatus("status" + ext);
        bean.setDate(getRandomDate());
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
