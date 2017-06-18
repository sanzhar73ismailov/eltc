/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.TypeOwnership;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTypeOwnership extends AbstractCreateBean {

    public CreateTypeOwnership(HttpServletRequest request) {
        super(request);
    }

    
    @Override
    public Object createBeanFromJSP() throws EltcException {
        TypeOwnership bean = new TypeOwnership();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        bean.setName(getNullifEmpty(request.getParameter("name")));
        bean.setNameFull(getNullifEmpty(request.getParameter("nameFull")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        TypeOwnership bean = new TypeOwnership();
        String ext = "_" + getCount();
        bean.setId(null);
        bean.setName("Наименование" + ext);
        bean.setNameFull("Полное Наименование" + ext);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}