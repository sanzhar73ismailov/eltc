/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Manager;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateManager extends AbstractCreateBean {

    public CreateManager(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Manager bean = new Manager();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }
        bean.setLastNameRu(getNameWithBigFirstLetter(request.getParameter("lastNameRu")));
        bean.setFirstNameRu(getNameWithBigFirstLetter(request.getParameter("firstNameRu")));

        bean.setPatronicNameRu(getNameWithBigFirstLetter(request.getParameter("patronicNameRu")));
        bean.setLastNameEn(getNameWithBigFirstLetter(request.getParameter("lastNameEn")));
        bean.setFirstNameEn(getNameWithBigFirstLetter(request.getParameter("firstNameEn")));
        bean.setPatronicNameEn(getNameWithBigFirstLetter(request.getParameter("patronicNameEn")));

        bean.setEmailOffice(getNullifEmpty(request.getParameter("emailOffice")));
        bean.setEmailHome(getNullifEmpty(request.getParameter("emailHome")));
        bean.setEmailAdd(getNullifEmpty(request.getParameter("emailAdd")));
        bean.setPhoneHome(getNullifEmpty(request.getParameter("phoneHome")));
        bean.setPhoneMobile1(getNullifEmpty(request.getParameter("phoneMobile1")));
        bean.setPhoneMobile2(getNullifEmpty(request.getParameter("phoneMobile2")));
        bean.setPhoneOffice(getNullifEmpty(request.getParameter("phoneOffice")));
        bean.setSkype(getNullifEmpty(request.getParameter("skype")));
        bean.setIcq(getNullifEmpty(request.getParameter("icq")));
        bean.setMailruAgent(getNullifEmpty(request.getParameter("mailruAgent")));

        String addString = "_" + bean.getEmailOffice() + "_";
        bean.setCvDocFile(writeFileAndGetItName("cvDocFile", addString));
        bean.setPhotoFile(writeFileAndGetItName("photoFile", addString));
        boolean isAct = request.getParameter("isActual") != null ? true : false;
        bean.setIsActual(isAct);
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Manager bean = new Manager();
        long num = getCount();
        String ext = "_" + num;

        bean.setId(null);


        bean.setLastNameRu("Фамилия" + ext);
        bean.setFirstNameRu("firstNameRu" + ext);

        bean.setPatronicNameRu("patronicNameRu" + ext);
        bean.setLastNameEn("lastNameEn" + ext);
        bean.setFirstNameEn("firstNameEn" + ext);
        bean.setPatronicNameEn("patronicNameEn" + ext);


        bean.setEmailOffice("emailOffice" + ext + "@dd.com");
        bean.setEmailHome("emailHome" + ext + "@dd.com");
        bean.setEmailAdd("emailAdd" + ext + "@dd.com");
        bean.setPhoneHome("phoneHome" + ext);
        bean.setPhoneMobile1("phoneMobile1" + ext);
        bean.setPhoneMobile2("phoneMobile2" + ext);
        bean.setPhoneOffice("phoneOffice" + ext);
        bean.setSkype("skype" + ext);
        bean.setIcq("icq" + ext);
        bean.setMailruAgent("mailruAgent" + ext);
        //bean.setCvDocFile("CvDocFile" + ext);
        //bean.setPhotoFile("photoFile" + ext);
        bean.setIsActual((num % 2) == 0 ? true : false);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
