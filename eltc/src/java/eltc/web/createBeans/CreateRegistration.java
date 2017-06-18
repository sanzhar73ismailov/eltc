package eltc.web.createBeans;

import domain.Contract;
import domain.Organization;
import eltc.model.EltcException;
import eltc.web.Registration;
import static eltc.web.createBeans.AbstractCreateBean.getCurrentUserLogin;
import static eltc.web.createBeans.AbstractCreateBean.getDateFromString;
import static eltc.web.createBeans.AbstractCreateBean.getRandomDate;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class CreateRegistration extends AbstractCreateBean {

    public CreateRegistration(HttpServletRequest request) {
        super(request);
    }

    public Object createBeanFromJSP() throws EltcException {
        Registration bean = new Registration();
        bean.setName(getNullifEmpty(request.getParameter("name")));
        bean.setLogin(getNullifEmpty(request.getParameter("login")));
        bean.setEmail1(getNullifEmpty(request.getParameter("email1")));
        bean.setEmail2(getNullifEmpty(request.getParameter("email2")));
        bean.setPassword1(getNullifEmpty(request.getParameter("password1")));
        bean.setPassword2(getNullifEmpty(request.getParameter("password2")));
        bean.setPasswordGeneral(getNullifEmpty(request.getParameter("passwordGeneral")));
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
         Registration bean = new Registration();
        String ext = "_" + getCount();
        bean.setName("name" + ext);
        bean.setLogin(("login") + ext);
        bean.setEmail1("email1" + ext);
        bean.setEmail2("email2" + ext);
        bean.setPassword1("password123" + ext);
        bean.setPassword2("password123" + ext);
        bean.setPasswordGeneral("elsieltc" + ext);
        return bean;
    }
}
