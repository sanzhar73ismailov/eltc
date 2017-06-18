/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Contract;
import domain.Organization;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.util.Configurator;
import eltc.web.ServletUtilMethods;
import static eltc.web.createBeans.AbstractCreateBean.getCurrentUserLogin;
import eltc.web.pageNavig.PageHttpRequest;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateContract extends AbstractCreateBean {

    public CreateContract(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Contract bean = new Contract();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }


        Organization organization = getObjectIfIdIsNumber(Organization.class, request, "organization");;
        bean.setOrganization(organization);

        bean.setNumber(getNullifEmpty(request.getParameter("number")));
        bean.setNumberInternal(getNullifEmpty(request.getParameter("numberInternal")));
        Date date = getDateFromString(request.getParameter("date"));
        bean.setDate(date);
        bean.setDescription(getNullifEmpty(request.getParameter("description")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());


        String addString = "_" + bean.getNumber() + "_" + ServletUtilMethods.getStringFromDateNoSeparation(bean.getDate()) + "_";


        bean.setPdfFile(writeFileAndGetItName("pdfFile", addString));

        bean.setWordFile(writeFileAndGetItName("wordFile", addString));


        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Contract bean = new Contract();
        String ext = "_" + getCount();
        bean.setId(null);
        bean.setNumber("Номер" + ext);
        bean.setNumberInternal("Номер вн." + ext);

        Organization org = new Organization();
        org.setId((int) (Math.random() * 10) + 1);
        bean.setOrganization(org);

        bean.setDate(getRandomDate());
        bean.setDescription("Описание" + ext);
        //bean.setPdfFile("ПдфФайл" + ext);
        //bean.setWordFile("WordФайл" + ext);

        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
