/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.HrManager;
import domain.Organization;
import domain.OrganizationHrManager;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;


/**
 *
 * @author sanzhar.ismailov
 */
public class CreateOrganizationHrManager extends AbstractCreateBean {

    public CreateOrganizationHrManager(HttpServletRequest request) {
        super(request);
    }

    
    @Override
    public Object createBeanFromJSP() throws EltcException {
        OrganizationHrManager bean = new OrganizationHrManager();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Organization organization = getObjectIfIdIsNumber(Organization.class, request, "organization");
        bean.setOrganization(organization);


        HrManager hrManager = getObjectIfIdIsNumber(HrManager.class, request, "hrManager");
        bean.setHrManager(hrManager);

        boolean isAct = request.getParameter("isActual") != null ? true : false;
        bean.setIsActual(isAct);
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        OrganizationHrManager bean = new OrganizationHrManager();
        long num = getCount();
        String ext = "_" + num;

        bean.setId(null);

        Organization organization = new Organization();
        organization.setId(getRandomMaxLimit(3));
        bean.setOrganization(organization);


        HrManager hrManager = new HrManager();
        hrManager.setId(getRandomMaxLimit(3));
        bean.setHrManager(hrManager);

        bean.setIsActual((num % 2) == 0 ? true : false);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
