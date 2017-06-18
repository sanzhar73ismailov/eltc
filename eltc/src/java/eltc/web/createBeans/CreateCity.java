/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.City;
import domain.Country;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateCity extends AbstractCreateBean {

    public CreateCity(HttpServletRequest request) {
        super(request);
    }
    
    

    @Override
    public Object createBeanFromJSP() throws EltcException {
        City bean = new City();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Country country = getObjectIfIdIsNumber(Country.class, request, "country");

//        if (request.getParameter("country") != null && !request.getParameter("country").isEmpty()) {
//            int countryId = Integer.parseInt(request.getParameter("country"));
//            country = model.getObject(countryId, Country.class);
//        }
        bean.setCountry(country);

        bean.setName(getNameWithBigFirstLetter(request.getParameter("name")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        City bean = new City();
        String ext = "_" + getCount();
        bean.setId(null);
        Country country = new Country();
        country.setId(getRandomMaxLimit(10));
        bean.setCountry(country);
        bean.setName("Наименование" + ext);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
