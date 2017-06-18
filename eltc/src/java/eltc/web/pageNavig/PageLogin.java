/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.User;
import domain.UserVisit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.FormChecker;
import eltc.web.ServletUtilMethods;
import java.util.Date;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageLogin extends AbstractPageNavigator {
final String REQUIRED = "required";

    public PageLogin(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() {
        pageTitle = ServletUtilMethods.getTranString("login_page");
        User user  = new User();
        try {
            //pageTo = "login.jsp";
            //pageTitle = ServletUtilMethods.getTranString("login_page");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (login != null) {
                login = login.trim();
            }
            if (password != null) {
                password = password.trim();
            }
            user.setLogin(login);
            request.setAttribute("bean", user);
            FormChecker formChecker = new FormChecker(request.getParameter(REQUIRED), request);
             if (formChecker.isHasErrorMessage()) {
                request.setAttribute("messageMap", formChecker.getMessageMap());
                throw new EltcException("Проверьте обязательные поля для ввода!");
            }
//                System.out.println("user = " + user);
//                System.out.println("password = " + ServletUtilMethods.getHash(password));
            User userTry = model.getUserByLogin(login);
            if (userTry != null && userTry.getPassword().equals(ServletUtilMethods.getHash(password))) {
                //  pageTo = Configurator.PATH_TO_VIEW_FOLDER + "/index.jsp";
                pageTo = "root/index";
                request.getSession().setAttribute(Configurator.USER_SESSION, userTry);
                UserVisit userVisit = new UserVisit(null, userTry, new Date());
                 model.addObject(userVisit);
            } else {
               throw new EltcException("Неверное имя пользователя или пароль. \n"
                        + "Проверьте правильность введенных данных.");
            }
            request.setAttribute(Configurator.INFO_MESSAGE, "Добро пожаловать " + userTry.getName() + "!");
        } catch (Exception ex) {
            pageTo = "login.jsp";
            request.setAttribute("message", ex.getMessage());
        }

    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }
}
