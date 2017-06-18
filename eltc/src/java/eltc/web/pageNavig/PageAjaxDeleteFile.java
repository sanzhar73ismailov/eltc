package eltc.web.pageNavig;

import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.pageNavig.ajaxDelete.AjaxDelete;
import eltc.web.pageNavig.ajaxDelete.FabricaAjaxDelete;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageAjaxDeleteFile extends AbstractPageNavigator {

    private List beans;

    public PageAjaxDeleteFile(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        //String action = request.getParameter("action");
        pageTo = "";
        toBeForwarded = false;
        String typeOfFile = request.getParameter("type");
        int targetId = Integer.parseInt(request.getParameter("id"));
        String name = null;

        AjaxDelete ajaxDelete = FabricaAjaxDelete.createAjaxDelete(entity, targetId,typeOfFile);
        name = ajaxDelete.getFileName();
        name = Configurator.getUploadDir() + File.separator + name;
        boolean isDelete = new File(name).delete();
        try {
            if (isDelete) {
                ajaxDelete.modifyObject();
                response.getWriter().write("<deleted>" + 1 + "</deleted>");
            } else {
                response.getWriter().write("<deleted>" + 0 + "</deleted>");
            }
        } catch (IOException ex) {
            throw new EltcException(ex.getMessage());
        }


        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");


    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }
}
