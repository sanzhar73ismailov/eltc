/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageViewBean extends AbstractPageNavigator {

    public PageViewBean(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        pageTo = "beanInfo.jsp";
        Object bean = null;
        try {
            bean = model.getObject(Integer.parseInt(request.getParameter("id")), entity.getClassOfElements());
            request.setAttribute("bean", bean);
            pageTitle = String.format(pageTitlePattern, ServletUtilMethods.getTranString(entity));


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new EltcException(ex.getMessage(), ex);
        }
    }

    @Override
    void setPageTitlePattern() throws EltcException {
        pageTitlePattern = "Информация по объекту (%s)";
    }
}
