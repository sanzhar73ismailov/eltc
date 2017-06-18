package eltc.web.createBeans;

import domain.City;
import domain.Country;
import domain.Email;
import domain.EmailType;
import domain.Student;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getCurrentUserLogin;
import static eltc.web.createBeans.AbstractCreateBean.getNameWithBigFirstLetter;
import static eltc.web.createBeans.AbstractCreateBean.getRandomMaxLimit;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class CreateEmail extends AbstractCreateBean {

    public CreateEmail(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Email bean = new Email();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        EmailType emailType = getObjectIfIdIsNumber(EmailType.class, request, "emailType");
        Student student = getObjectIfIdIsNumber(Student.class, request, "student");
//        if (request.getParameter("country") != null && !request.getParameter("country").isEmpty()) {
//            int countryId = Integer.parseInt(request.getParameter("country"));
//            country = model.getObject(countryId, Country.class);
//        }
        bean.setStudent(student);
        bean.setEmailType(emailType);

        bean.setEmail(request.getParameter("email").trim().toLowerCase());
        boolean isAct = request.getParameter("isActual") != null ? true : false;
        bean.setIsActual(isAct);
        boolean subs = request.getParameter("subscribe") != null ? true : false;
        bean.setSubscribe(subs);
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;

    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Email bean = new Email();
        String ext = "_" + getCount();
        bean.setId(null);
        EmailType emailType = new EmailType();
        emailType.setId(getRandomMaxLimit(3));
        bean.setEmailType(emailType);
        Student st = new Student();
        st.setId(getRandomMaxLimit(3));
        bean.setStudent(st);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
