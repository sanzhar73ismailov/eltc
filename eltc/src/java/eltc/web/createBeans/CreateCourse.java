/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Category;
import domain.Course;
import domain.Vendor;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getRandomMaxLimit;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateCourse extends AbstractCreateBean {

    public CreateCourse(HttpServletRequest request) {
        super(request);
    }

    @Override
   public Object createBeanFromJSP() throws EltcException {
        Course bean = new Course();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Vendor vendor = getObjectIfIdIsNumber(Vendor.class, request, "vendor");
        bean.setVendor(vendor);

        bean.setCodeOwn(getNullifEmpty(request.getParameter("codeOwn")));
        bean.setNameOriginal(getNullifEmpty(request.getParameter("nameOriginal")));
        bean.setNameRu(getNullifEmpty(request.getParameter("nameRu")));
        bean.setDiscriptionEn(getNullifEmpty(request.getParameter("discriptionEn")));
        bean.setDiscriptionRu(getNullifEmpty(request.getParameter("discriptionRu")));

        Category category = getObjectIfIdIsNumber(Category.class, request, "category");
        bean.setCategory(category);

        bean.setDurationDays(getZeroifEmpty(request.getParameter("durationDays")));
        bean.setDurationHours(getZeroifEmpty(request.getParameter("durationHours")));
        bean.setAdditionalInfo(getNullifEmpty(request.getParameter("additionalInfo")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());

        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Course bean = new Course();
        String ext = "_" + getCount();

        bean.setId(null);

        Vendor ven = new Vendor();
        ven.setId(getRandomMaxLimit(5));
        bean.setVendor(ven);

        bean.setCodeOwn("код_курса" + ext);
        bean.setNameOriginal("nameOriginal" + ext);
        bean.setNameRu("nameRu" + ext);
        bean.setDiscriptionEn("discriptionEn" + ext);
        bean.setDiscriptionRu("discriptionRu" + ext);

        Category category = new Category();
        category.setId(getRandomMaxLimit(25));
        bean.setCategory(category);

        bean.setDurationDays((byte) getRandomMaxLimit(10));
        bean.setDurationHours((byte) getRandomMaxLimit(40));
        bean.setAdditionalInfo("additionalInfo" + ext);
        bean.setUser("user");
        bean.setInsertDatetime(new Date());

        return bean;

    }
}
