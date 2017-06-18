/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.Contract;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.DeletableInterface;
import eltc.web.DictionaryInterface;
import eltc.web.ServletUtilMethods;
import static eltc.web.pageNavig.EntityEnum.AUDITORY;
import static eltc.web.pageNavig.EntityEnum.CATEGORY;
import static eltc.web.pageNavig.EntityEnum.COUNTRY;
import static eltc.web.pageNavig.EntityEnum.COURSE_TYPE;
import static eltc.web.pageNavig.EntityEnum.CURRENCY;
import static eltc.web.pageNavig.EntityEnum.INDUSTRY;
import static eltc.web.pageNavig.EntityEnum.MANAGER;
import static eltc.web.pageNavig.EntityEnum.SPECIALIZATION;
import static eltc.web.pageNavig.EntityEnum.STUDENT;
import static eltc.web.pageNavig.EntityEnum.TRAINER;
import static eltc.web.pageNavig.EntityEnum.VENDOR;
import java.io.File;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageDeleteBean extends AbstractPageNavigator {

    private static final String BACK_PAGE = "backPage";

    public PageDeleteBean(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        int id = Integer.parseInt(request.getParameter("id"));


        try {
            Object deleteObj = model.getObject(id, entity.getClassOfElements());

            if (deleteObj instanceof Contract) {
                Contract beanConcrete = (Contract) deleteObj;
                File file = new File(Configurator.getUploadDir() + File.separator + beanConcrete.getPdfFile());
                file.delete();
            }
            if (entity.getEntityObject() instanceof eltc.web.DeletableInterface) {
                ((DeletableInterface) deleteObj).setDeleted(true);
                model.modifyObject(deleteObj);
            } else {
                model.removeObject(deleteObj);
            }
            FabricaPageNumber fabricaPageNumber = new FabricaPageNumber(request, entity);
            if (request.getParameter(BACK_PAGE) != null) {
                EntityEnum backPageEntity = EntityEnum.valueOf(request.getParameter(BACK_PAGE).toUpperCase());
                pageTo = backPageEntity.getSingleForm() + "Edit.jsp";
                pageTitlePattern = "Редактирование объекта '%s'";
                Object bean = null;
                bean = model.getObject(Integer.valueOf(request.getParameter("backEntityId")), backPageEntity.getClassOfElements());
                request.setAttribute("bean", bean);
                // model.removeObjectFromSession(bean);
                pageTitle = String.format(pageTitlePattern, ServletUtilMethods.getTranString(backPageEntity));
            } else {
                pageTo = "beanList.jsp";
                pageTitle = String.format(pageTitlePattern, entity.getTranslateFormListOf());
            }
        } catch (Exception ex) {
            request.setAttribute("exception", new EltcException("Удаление не произошло, объект используется в другой таблице", ex));
        }
    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }
}
