package eltc.web.pageNavig;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.model.Model;
import eltc.model.ModelImpl;
import eltc.util.Configurator;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import org.apache.commons.fileupload.FileItem;

public abstract class AbstractPageNavigator {

    protected String pageTo = "";
    protected String pageTitlePattern = "%s";
    protected String pageTitle = "no name";
    protected EntityEnum entity;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Model model;
    protected boolean toBeForwarded = true;

    public AbstractPageNavigator(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        this.entity = entity;

        this.request = request;
        this.response = response;
        model = ModelImpl.getInstance();
        setPageTitlePattern();
        doSomething();
        request.setAttribute("pageTitle", pageTitle);
        request.setAttribute("entity", entity.getSingleForm());
        if (pageTo == null) {
            pageTo = "errorpage.jsp";
            throw new EltcException("Необходимо задать pageTo");
        } else if (pageTo.startsWith("root")) {
            pageTo = pageTo.substring(4);
        } else {
            pageTo = Configurator.PATH_TO_VIEW_FOLDER + this.pageTo;
        }
    }

    public AbstractPageNavigator(HttpServletRequest request, String pageTo, String pageTitle) {
        this.pageTo = Configurator.PATH_TO_VIEW_FOLDER + pageTo;
        this.pageTitle = pageTitle;
        request.setAttribute("pageTitle", pageTitle);

    }

    public String getPageTo() throws EltcException {
        return pageTo;
    }

    abstract void doSomething() throws EltcException;

    abstract void setPageTitlePattern() throws EltcException;

    public void forward(RequestDispatcher rd, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (toBeForwarded) {
            rd.forward(request, response);
        }
    }

    @Deprecated
    private void setCharacterEncoding() throws EltcException {
        try {
            if (request != null) {
                request.setCharacterEncoding("UTF-8");
                //System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
            }

            if (response != null) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                System.out.println("response.getCharacterEncoding() = " + response.getCharacterEncoding());
            }
            // response.setContentType("text/html; charset=UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new EltcException(ex.getMessage(), ex);
        }
    }
}
