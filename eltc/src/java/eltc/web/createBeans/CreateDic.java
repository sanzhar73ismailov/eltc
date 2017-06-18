/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Vendor;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.web.DictionaryInterface;
import eltc.web.pageNavig.EntityEnum;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateDic extends AbstractCreateBean {

    EntityEnum entity;

    public CreateDic(EntityEnum entity, HttpServletRequest request) {
        super(request);
        this.entity = entity;
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Object obj = entity.getEntityObject();
        DictionaryInterface bean = null;
        if (obj instanceof DictionaryInterface) {
            bean = (DictionaryInterface) obj;
            if (!request.getParameter("id").isEmpty()) {
                bean.setId(Integer.valueOf(request.getParameter("id")));
            }
            bean.setName(getNullifEmpty(request.getParameter("name")));
            bean.setUser(getCurrentUserLogin(request));
            bean.setInsertDatetime(new Date());
        }
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        DictionaryInterface bean = new Vendor();
        long num = getCount();
        String ext = "_" + num;
        bean.setId(null);
        bean.setName("Наименование" + ext);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
