package eltc.web.pageNavig;

import eltc.model.EltcException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageLogout extends AbstractPageNavigator{

    public PageLogout(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    
    @Override
    void doSomething() throws EltcException {
        request.getSession().invalidate();
        pageTo = "root/login";
    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }

}
