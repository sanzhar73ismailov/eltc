package eltc.web.pageNavig;

import domain.User;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.FabricaBeanCreate;
import eltc.web.FormChecker;
import eltc.web.Registration;
import eltc.web.ServletUtilMethods;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageRegister extends AbstractPageNavigator {

    Registration registration = new Registration();
    FormChecker formChecker;
    final String REQUIRED = "required";
    String messageForException;
    User user;

    public PageRegister(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        try {
            pageTo = "root/index";
            //pageTitle = ServletUtilMethods.getTranString("main_page");
            registration = (Registration) FabricaBeanCreate.createBean(entity, request);
            formChecker = new FormChecker(request.getParameter(REQUIRED), request);
            request.setAttribute("messageMap", formChecker.getMessageMap());
            request.setAttribute("bean", registration);
            toFillMessageForException();
            if (formChecker.isHasErrorMessage() || !messageForException.isEmpty()) {
                throw new EltcException(messageForException);
            }
            User user = new User();
            user.setLogin(registration.getLogin());
            user.setName(registration.getName());
            user.setEmail(registration.getEmail1());
            user.setPassword(ServletUtilMethods.getHash(registration.getPassword1()));
            user.setInsertDatetime(new Date());
            model.addObject(user);
            user = model.getUserByLogin(registration.getLogin());
            request.getSession().setAttribute("userSession", user);
            request.setAttribute(Configurator.INFO_MESSAGE, "Добро пожаловать " + user.getName() + "!<br/> Регистрация прошла успешно.");
        } catch (Exception ex) {
            pageTitle = ServletUtilMethods.getTranString("registration");
            pageTo = "registration.jsp";
            request.setAttribute("message", ex.getMessage());
        }
    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }

    private void toFillMessageForException() throws EltcException {
        messageForException = "";
        if ((registration.getPassword1() != null && registration.getPassword2() != null)
                && !registration.getPassword1().equals(registration.getPassword2())) {
            messageForException += "Пароль 1 и Пароль 2 не совпадают";
        }

        if ((registration.getEmail1() != null && registration.getEmail2() != null)
                && !registration.getEmail1().equalsIgnoreCase(registration.getEmail2())) {
            if (!messageForException.isEmpty()) {
                messageForException += "<br/>\n";
            }
            messageForException += "Эл почта 1 и эл почта 2 не совпдают";
        }


        System.out.println("\n\n\nregistration.getPasswordGeneral()=" + registration.getPasswordGeneral());
        if ((registration.getPasswordGeneral() != null
                && !registration.getPasswordGeneral().equalsIgnoreCase(Configurator.PASS_GENERAL))) {
            if (!messageForException.isEmpty()) {
                messageForException += "<br/>\n";
            }
            messageForException += ServletUtilMethods.getTranString("password_general_is_wrong");
        }



        if (model.getUserByLogin(registration.getLogin()) != null) {
            if (!messageForException.isEmpty()) {
                messageForException += "<br/>\n";
            }
            messageForException += "Пользователь с таким логином уже существует";
        }

    }
}
