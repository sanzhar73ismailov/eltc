/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageError extends AbstractPageNavigator {

    public PageError(EntityEnum entity, HttpServletRequest request, Exception ex) throws EltcException {
        super(entity, request, null);
        request.setAttribute("except", ex);
    }
    
    

    @Override
    void doSomething() throws EltcException {
        pageTo = "errorpage.jsp";
        pageTitle = "Страница ошибок";
    }

    @Override
    void setPageTitlePattern() throws EltcException {
        pageTitlePattern = "";
    }
}