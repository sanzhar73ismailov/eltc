/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Certificate;
import domain.Vendor;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateSertificate extends AbstractCreateBean {

    public CreateSertificate(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Certificate bean = new Certificate();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Vendor vendor = getObjectIfIdIsNumber(Vendor.class, request, "vendor");
        bean.setVendor(vendor);

        bean.setCode(getNullifEmpty(request.getParameter("code")));
        bean.setName(getNullifEmpty(request.getParameter("name")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Certificate bean = new Certificate();
        String ext = "_" + getCount();
        bean.setId(null);

        Vendor vendor = new Vendor();
        vendor.setId(getRandomMaxLimit(3));
        bean.setVendor(vendor);

        bean.setCode("code" + ext);
        bean.setName("name" + ext);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}