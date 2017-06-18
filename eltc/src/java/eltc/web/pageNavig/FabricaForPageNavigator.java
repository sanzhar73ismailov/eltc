package eltc.web.pageNavig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.ServletUtilMethods;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;

public class FabricaForPageNavigator {

    public static AbstractPageNavigator createPageNavigator(String userPath, HttpServletRequest requestPrimary, HttpServletResponse response) throws EltcException {
        HttpServletRequest request = FabricaRequestMethod.getRequest(requestPrimary);
        AbstractPageNavigator pageNavigator = new PageGeneral(request, "404.jsp",
                ServletUtilMethods.getTranString("noSuchPage") + userPath);
        // List<FileItem> multiparts = getMultiparts(request);

        //String entityAsString = getEntityAsString(multiparts, request);
        String entityAsString = request.getParameter("entity");


        request.setAttribute("userPath", userPath);
        System.out.print("{{{{{{{{{{{{{{{{{{{{ ");
        System.out.print("userPath=" + userPath);
        System.out.println(" }}}}}}}}}}}}}}}}}}");

        if (request.getSession().getAttribute(Configurator.USER_SESSION) == null
                && !userPath.equals("/registration")
                && !userPath.equals("/toLogin")
                && !userPath.equals("/toRegistry")) {
            return new PageGeneral(request, "login.jsp", ServletUtilMethods.getTranString("login_page"));
        }


        try {
            if (userPath.equals("/login")) {
                pageNavigator = new PageGeneral(request, "login.jsp",
                        ServletUtilMethods.getTranString("login_page"));
            } else if (userPath.equals("/toLogin")) {
                pageNavigator = new PageLogin(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/logout")) {
                pageNavigator = new PageLogout(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/registration")) {
                pageNavigator = new PageGeneral(request, "registration.jsp",
                        ServletUtilMethods.getTranString("registration"));
            } else if (userPath.equals("/toRegistry")) {
                pageNavigator = new PageRegister(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/show")) {
                pageNavigator = new PageShowBeans(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/create")) {
                //pageNavigator = new PageCreateBean(getEntity(entityAsString), request, response);
                pageNavigator = new PageEditBean(getEntity(entityAsString),
                        request, response, true);
            } else if (userPath.equals("/edit")) {
                pageNavigator = new PageEditBean(getEntity(entityAsString),
                        request, response, false);
            } else if (userPath.equals("/save")) {
                pageNavigator = new PageSaveBean(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/delete")) {
                pageNavigator = new PageDeleteBean(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/view")) {
                pageNavigator = new PageViewBean(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/asyncSearch")) {
                pageNavigator = new PageAjaxWork(getEntity(entityAsString),
                        request, response);
            } else if (userPath.equals("/test_mode")) {
                pageNavigator = new PageTestModeChange(getEntity(null), request, response);
            } else if (userPath.equals("/emailListCreate")) {
                pageNavigator = new PageEmailListCreate(getEntity(null), request, response);
            } else if (userPath.equals("/download")) {
                pageNavigator = new PageDownloadFile(getEntity(entityAsString), request, response);
            } else if (userPath.equals("/deleteFile")) {
                pageNavigator = new PageAjaxDeleteFile(getEntity(entityAsString), request, response);
            } else if (userPath.equals("/index")) {
                pageNavigator = new PageGeneral(EntityEnum.NO_ACTION_Entity, request, response);
            }

        } catch (Exception ex) {
            pageNavigator = new PageError(getEntity(entityAsString), request, ex);
        }

        return pageNavigator;
    }

    private static EntityEnum getEntity(String value) {
        if (value == null || value.isEmpty()) {
            return EntityEnum.NO_ACTION_Entity;
        }
        return EntityEnum.valueOf(value.toUpperCase());
    }
}
