/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Country;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.model.Model;
import eltc.model.ModelImpl;
import eltc.util.Configurator;
import eltc.web.ServletUtilMethods;
import eltc.web.pageNavig.EntityEnum;
import eltc.web.pageNavig.PageHttpRequest;
import java.io.File;
import javax.swing.text.html.parser.Entity;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author sanzhar.ismailov
 */
public abstract class AbstractCreateBean {

    protected Model model = ModelImpl.getInstance();
    //protected ServletContext sContext = 
    protected HttpServletRequest request;
    protected EntityEnum entity;
   

    public AbstractCreateBean(HttpServletRequest request) {
        this.request = request;
        entity = EntityEnum.valueOf(request.getParameter("entity").toUpperCase());
    }

    public abstract Object createBeanFromJSP() throws EltcException;

    public abstract Object createTestBeanForJSP() throws EltcException;

    public String getNullifEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return ServletUtilMethods.escapeHtml(value.trim());
    }

    public int getZeroifEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public Float getFloatifEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Float.valueOf(value);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public <T> T getObjectIfIdIsNumber(Class cl, HttpServletRequest request, String parameterValue) throws EltcException {
        if (parameterValue != null && !parameterValue.trim().isEmpty()) {
            try {
                int id = Integer.parseInt(request.getParameter(parameterValue));
                return model.getObject(id, cl);
            } catch (NumberFormatException ex) {
                return null;
            }
        }
        return null;
    }

    public static String getNameWithBigFirstLetter(String value) {
        return ServletUtilMethods.escapeHtml(ServletUtilMethods.getNameWithBigFirstLetter(value));
    }

    public static Date getDateFromString(String dateInString) {
        return ServletUtilMethods.getDateFromString(dateInString);

    }

    public long getCount() {
        return ServletUtilMethods.getCount(request.getSession().getServletContext().getRealPath("resources/count.txt"));
    }

    public static Date getRandomDate() {
        return ServletUtilMethods.getRandomDate();
    }

    public static String getCurrentUserLogin(HttpServletRequest request) {
        return ServletUtilMethods.getCurrentUserLogin(request);
    }

    public static int getRandomMaxLimit(int upLimit) {
        return ServletUtilMethods.getRandomMaxLimit(upLimit);
    }

    protected String getFilenameExtension(String fileName) {
        return ServletUtilMethods.getFilenameExtension(fileName);
    }

    protected String writeFileAndGetItName(String fieldName, String additionalIdentificator) throws EltcException {
        FileItem fileItem = null;
        String name = null;

        if (request.getParameter(fieldName) != null) {
            return request.getParameter(fieldName);
        }


        try {
//            if(request.getParameter(fieldName) != null){
//                return request.getParameter(fieldName);
//            }
            PageHttpRequest pageHttpRequest = (PageHttpRequest) request;
            pageHttpRequest.getDelegatedRequest().setAttribute("entity", request.getParameter("entity"));
            //fileItem = pageHttpRequest.getPart(fieldName);
            if (!fileItem.getName().isEmpty()) {

//                if (fileItem.getSize() > (15 * 1024 * 1024)) {
//                    throw new EltcException("Размер файла не должен превышать 15Mb");
//                }

                String extension = getFilenameExtension(fileItem.getName());
                name = entity.getSingleForm() + "_" + additionalIdentificator + fieldName + extension;
                fileItem.write(new File(Configurator.getUploadDir() + File.separator + name));
            }

        } catch (Exception ex) {
            name = null;
            throw new EltcException(ex.getMessage(), ex);
        }
        return name;
    }
}
