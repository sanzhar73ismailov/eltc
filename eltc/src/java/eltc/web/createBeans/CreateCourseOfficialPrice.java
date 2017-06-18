/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.CourseOfficial;
import domain.CourseOfficialPrice;
import domain.Currency;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateCourseOfficialPrice extends AbstractCreateBean {

    public CreateCourseOfficialPrice(HttpServletRequest request) {
        super(request);
    }

    @Override
public Object createBeanFromJSP() throws EltcException {
        CourseOfficialPrice bean = new CourseOfficialPrice();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Currency currency = getObjectIfIdIsNumber(Currency.class, request, "currency");
        bean.setCurrency(currency);

        CourseOfficial courseOfficial = getObjectIfIdIsNumber(CourseOfficial.class, request, "courseOfficial");
        bean.setCourseOfficial(courseOfficial);

        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setPrice(getFloatifEmpty(request.getParameter("price")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        CourseOfficialPrice bean = new CourseOfficialPrice();
        String ext = "_" + getCount();
        bean.setId(null);

        Currency currency = new Currency();
        currency.setId(getRandomMaxLimit(3));
        bean.setCurrency(currency);

        CourseOfficial courseOfficial = new CourseOfficial();
        courseOfficial.setId(getRandomMaxLimit(3));
        bean.setCourseOfficial(courseOfficial);

        bean.setDate(getRandomDate());
        bean.setPrice((float) getRandomMaxLimit(3));
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}