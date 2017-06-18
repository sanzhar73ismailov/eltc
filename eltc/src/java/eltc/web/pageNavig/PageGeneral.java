/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.Organization;
import domain.Student;
import domain.Timetable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.web.FabricaBeanCreate;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageGeneral extends AbstractPageNavigator {

    public PageGeneral(HttpServletRequest request, String pageTo, String pageTitle) throws EltcException {
        super(request, pageTo, pageTitle);
    }

    public PageGeneral(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }
    
    
    
    

    @Override
    void doSomething() throws EltcException {
        pageTo = "index.jsp";
        request.setAttribute("organizations", model.getObjectsSafelyDeletedFromTo(1, 10, new Organization(), "order by id desc"));
        request.setAttribute("students", model.getObjectsSafelyDeletedFromTo(1, 12, new Student(), "order by id desc"));
        request.setAttribute("timetables", model.getObjectsSafelyDeletedFromTo(1, 12, new Timetable(), "order by id desc"));
    }

    @Override
    void setPageTitlePattern() throws EltcException {
        pageTitle =  ServletUtilMethods.getTranString("main_page");
    }
}
