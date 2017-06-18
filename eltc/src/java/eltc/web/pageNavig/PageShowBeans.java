/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.Student;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageShowBeans extends AbstractPageNavigator {

    private String objName = "no obj name";

    public PageShowBeans(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        FabricaPageNumber fabricaPageNumber = new FabricaPageNumber(request, entity);
        /*
        if (entity.getEntityObject() instanceof Student) {
            pageTo = "studentList.jsp";
        } else {
            pageTo = "beanList.jsp";
        }
        */
        pageTo = "beanList.jsp";
        pageTitle = String.format(pageTitlePattern, entity.getTranslateFormListOf());
    }

    @Override
    void setPageTitlePattern() throws EltcException {
        pageTitlePattern = "%s";
    }
}
