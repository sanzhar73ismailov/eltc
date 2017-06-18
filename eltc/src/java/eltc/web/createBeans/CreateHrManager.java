/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.HrManager;
import domain.Sex;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateHrManager extends AbstractCreateBean {

    public CreateHrManager(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        HrManager bean = new HrManager();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Sex sex = null;
        // System.out.println("request.getParameter(\"sex\")=" + request.getParameter("sex"));
        if (request.getParameter("sex") != null && request.getParameter("sex").equals("1")) {
            sex = model.getObject(1, Sex.class);
        } else if (request.getParameter("sex") != null && request.getParameter("sex").equals("2")) {
            sex = model.getObject(2, Sex.class);
        }
        bean.setSex(sex);

        bean.setLastNameRu(getNullifEmpty(request.getParameter("lastNameRu")));
        bean.setFirstNameRu(getNullifEmpty(request.getParameter("firstNameRu")));
        bean.setPatronicNameRu(getNullifEmpty(request.getParameter("patronicNameRu")));
        bean.setLastNameEn(getNullifEmpty(request.getParameter("lastNameEn")));
        bean.setFirstNameEn(getNullifEmpty(request.getParameter("firstNameEn")));
        bean.setPatronicNameEn(getNullifEmpty(request.getParameter("patronicNameEn")));
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

        bean.setCvDocFile(getNullifEmpty(request.getParameter("cvDocFile")));
        bean.setPhotoFile(getNullifEmpty(request.getParameter("photoFile")));

        String addString = "_" + bean.getEmailOffice() + "_";
        bean.setCvDocFile(writeFileAndGetItName("cvDocFile", addString));
        bean.setPhotoFile(writeFileAndGetItName("photoFile", addString));
        
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        HrManager bean = new HrManager();
        String ext = "_" + getCount();
        bean.setId(null);

        Sex sex = new Sex();
        sex.setId(getRandomMaxLimit(2));
        bean.setSex(sex);

        bean.setLastNameRu("lastNameRu" + ext);
        bean.setFirstNameRu("firstNameRu" + ext);
        bean.setPatronicNameRu("patronicNameRu" + ext);
        bean.setLastNameEn("lastNameEn" + ext);
        bean.setFirstNameEn("firstNameEn" + ext);
        bean.setPatronicNameEn("patronicNameEn" + ext);
        bean.setEmailOffice("emailOffice" + ext + "@dd.ru");
        bean.setEmailHome("emailHome" + ext + "@dd.ru");
        bean.setEmailAdd("emailAdd" + ext + "@dd.ru");
        bean.setPhoneHome("phoneHome" + ext + "@dd.ru");
        bean.setPhoneMobile1("phoneMobile1" + ext);
        bean.setPhoneMobile2("phoneMobile2" + ext);
        bean.setPhoneOffice("phoneOffice" + ext);
        bean.setSkype("skype" + ext);
        bean.setIcq("icq" + ext);
        bean.setMailruAgent("mailruAgent" + ext);
//        bean.setCvDocFile("cvDocFile" + ext);
//        bean.setPhotoFile("photoFile" + ext);



        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}