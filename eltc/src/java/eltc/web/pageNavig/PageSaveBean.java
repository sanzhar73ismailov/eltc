/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.Country;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.EltcException;
import eltc.logger.ErroLogging;
import eltc.web.DictionaryInterface;
import eltc.web.FabricaBeanCreate;
import eltc.web.FormChecker;
import eltc.web.ServletUtilMethods;
import static eltc.web.pageNavig.EntityEnum.MANAGER;
import static eltc.web.pageNavig.EntityEnum.STUDENT;
import static eltc.web.pageNavig.EntityEnum.TRAINER;
import static eltc.web.pageNavig.EntityEnum.VENDOR;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageSaveBean extends AbstractPageNavigator {

    FormChecker formChecker;
    boolean isNewObject;
    final String REQUIRED = "required";
    private String objName = "no obj name";

    public PageSaveBean(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        Object bean = null;
        try {
            definePageTo();
            defineNewObject();

            bean = FabricaBeanCreate.createBean(entity, request);
            formChecker = new FormChecker(request.getParameter(REQUIRED), request);

            if (formChecker.isHasErrorMessage()) {
                request.setAttribute("messageMap", formChecker.getMessageMap());
                throw new EltcException("Проверьте обязательные поля для ввода!");
            }

            request.setAttribute("bean", bean);
            pageTitle = String.format(pageTitlePattern, ServletUtilMethods.getTranString(entity));

            if (isNewObject) {
                model.addObject(bean);
                // System.out.println("student = " + student);
            } else {
                //int id = Integer.parseInt(request.getParameter("id"));
                //student.setId(id);
                model.modifyObject(bean);
                // db.editStudent(student);
            }



        } catch (Exception ex) {
            definePageBack();
            try {
                FabricaBeanCreate.setListAttibutes(entity, request, model);
            } catch (EltcException elx) {
                throw new EltcException(ex.getMessage());
            }

//            switch (entity) {
//                case CITY:
//                    List <Country> countryList = model.getObjects(Country.class);
//                    request.setAttribute("countries", countryList);
//            }
            System.out.println("ex = " + ex);
            ex.printStackTrace();
            ErroLogging.prinStackMessage(ex);
            pageTitle = request.getParameter("pageTitle");
            request.setAttribute("bean", bean);
            request.setAttribute("message", ex.getMessage());


        }
    }

    private void defineNewObject() throws EltcException {
        if (request.getParameter("id") == null) {
            throw new EltcException("Id of object is null");
        } else if (request.getParameter("id").isEmpty()) {
            // means to create object
            isNewObject = true;
        } else {
            // means to edit not create
            isNewObject = false;
        }
    }

    private void definePageTo() throws EltcException {
        if (1 == 1 //                entity instanceof Student || 
                //                entity instanceof Manager ||
                //                entity instanceof Trainer
                ) {
            pageTo = "beanInfo.jsp";
        } else {
            throw new EltcException("Unknown entity (in definePageTo of PageSaveBean): " + entity);
        }
    }

    private void definePageBack() throws EltcException {

        if (entity.getEntityObject() instanceof DictionaryInterface) {
            pageTo = "dicEdit.jsp";
        } else {
            pageTo = "" + entity.getEnumAsStringLawerCase(entity) + "Edit.jsp";
        }
    }

    @Override
    void setPageTitlePattern() throws EltcException {
        pageTitlePattern = "Информация по объекту (%s)";
    }
}
