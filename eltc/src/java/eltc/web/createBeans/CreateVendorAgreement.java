/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Vendor;
import domain.VendorAgreement;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateVendorAgreement extends AbstractCreateBean {

    public CreateVendorAgreement(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        VendorAgreement bean = new VendorAgreement();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Vendor vendor = null;
        int vendorId = Integer.valueOf(request.getParameter("vendor"));
        vendor = model.getObject(vendorId, Vendor.class);
        bean.setVendor(vendor);

        bean.setNumber(getNullifEmpty(request.getParameter("number")));
        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setDescription(getNullifEmpty(request.getParameter("description")));
       
        
        String addString = "_" + bean.getNumber() + "_" + ServletUtilMethods.getStringFromDateNoSeparation(bean.getDate()) + "_";
        bean.setPdfFile(writeFileAndGetItName("pdfFile", addString));
        
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        VendorAgreement bean = new VendorAgreement();
        String ext = "_" + getCount();
        bean.setId(null);

        Vendor vendor = new Vendor();
        vendor.setId(getRandomMaxLimit(10));
        bean.setVendor(vendor);

        bean.setNumber("number" + ext);
        bean.setDate(getRandomDate());
        bean.setDescription("description" + ext);
        //bean.setPdfFile("pdfFile" + ext);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}