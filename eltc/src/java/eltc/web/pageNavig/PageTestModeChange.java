package eltc.web.pageNavig;

import eltc.model.EltcException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageTestModeChange extends AbstractPageNavigator {

    public PageTestModeChange(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    public PageTestModeChange(HttpServletRequest request, String pageTo, String pageTitle) {
        super(request, pageTo, pageTitle);
    }

   
    

    @Override
    void doSomething() throws EltcException {
        pageTo = "index.jsp";
        if (request.getParameter("test") != null) {
            if (request.getParameter("test").equals("1")) {
                model.turnOnTestMode();
            } else {
                model.turnOffTestMode();
            }
        } else {
            throw new EltcException("No test parameter");
        }

    }

    @Override
    void setPageTitlePattern() throws EltcException {
        
    }
}
