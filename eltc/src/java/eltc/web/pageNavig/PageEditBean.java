package eltc.web.pageNavig;

import domain.TimetableStudent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.DictionaryInterface;
import eltc.web.FabricaBeanCreate;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageEditBean extends AbstractPageNavigator {

    private String objName = "no obj name";
    private boolean isNewObject;

    public PageEditBean(EntityEnum entity, HttpServletRequest request, HttpServletResponse response, boolean isNewObject) throws EltcException {
        super(entity, request, response);
        this.isNewObject = isNewObject;
        doSomethingIfEdit();
    }

    @Override
    void doSomething() throws EltcException {
        if (entity.getEntityObject() instanceof DictionaryInterface) {
            pageTo = "dicEdit.jsp";
        } else {
            pageTo = entity.getSingleForm() + "Edit.jsp";
        }
    }

    final void doSomethingIfEdit() throws EltcException {
        objName = ServletUtilMethods.getTranString(entity);
        if (isNewObject) {
            pageTitlePattern = "Создание объекта '%s'";
            if (request.getParameter("change") != null) {
                if (entity.getEntityObject() instanceof TimetableStudent) {
                    TimetableStudent bean = model.getObject(Integer.valueOf(request.getParameter("id")), entity.getClassOfElements());
                    bean.setId(null);
                    bean.setStudent(null);
                    request.setAttribute("bean", bean);
//                     model.removeObjectFromSession(bean);
                }
            } else {
                setTestObjectForCreate();
            }
        } else {
            pageTitlePattern = "Редактирование объекта '%s'";
            Object bean = null;
            bean = model.getObject(Integer.valueOf(request.getParameter("id")), entity.getClassOfElements());
            request.setAttribute("bean", bean);
            // model.removeObjectFromSession(bean);
        }
        FabricaBeanCreate.setListAttibutes(entity, request, model);
        pageTitle = String.format(pageTitlePattern, objName);
        request.setAttribute("pageTitle", pageTitle);
    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }

    private void setTestObjectForCreate() throws EltcException {
        if (Configurator.isTestMode()) {
            request.setAttribute("bean", FabricaBeanCreate.createTestBean(entity, request));
        }

    }
}