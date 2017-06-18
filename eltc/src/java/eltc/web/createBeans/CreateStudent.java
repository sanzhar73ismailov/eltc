/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Email;
import domain.EmailType;
import domain.Sex;
import domain.Student;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getCurrentUserLogin;
import java.util.Set;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateStudent extends AbstractCreateBean {

    public CreateStudent(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Student bean = new Student();
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
        bean.setLastNameRu(getNameWithBigFirstLetter(request.getParameter("lastNameRu")));
        bean.setFirstNameRu(getNameWithBigFirstLetter(request.getParameter("firstNameRu")));

        bean.setPatronicNameRu(getNameWithBigFirstLetter(request.getParameter("patronicNameRu")));
        bean.setLastNameEn(getNameWithBigFirstLetter(request.getParameter("lastNameEn")));
        bean.setFirstNameEn(getNameWithBigFirstLetter(request.getParameter("firstNameEn")));
        bean.setPatronicNameEn(getNameWithBigFirstLetter(request.getParameter("patronicNameEn")));

        Date dateOfBirth = getDateFromString(request.getParameter("dateOfBirth"));

        bean.setDateOfBirth(dateOfBirth);

        bean.setPhoneHome(getNullifEmpty(request.getParameter("phoneHome")));
        bean.setPhoneMobile1(getNullifEmpty(request.getParameter("phoneMobile1")));
        bean.setPhoneMobile2(getNullifEmpty(request.getParameter("phoneMobile2")));
        bean.setPhoneOffice(getNullifEmpty(request.getParameter("phoneOffice")));
        bean.setSkype(getNullifEmpty(request.getParameter("skype")));
        bean.setIcq(getNullifEmpty(request.getParameter("icq")));
        bean.setMailruAgent(getNullifEmpty(request.getParameter("mailruAgent")));
        bean.setComments(getNullifEmpty(request.getParameter("comments")));
        bean.setPhoto(getNullifEmpty(request.getParameter("photo")));
        bean.setPersonVueIdent(getNullifEmpty(request.getParameter("personVueIdent")));
        bean.setPrometricIdent(getNullifEmpty(request.getParameter("prometricIdent")));
        bean.setOracleLogin(getNullifEmpty(request.getParameter("oracleLogin")));
        bean.setMicrosoftLogin(getNullifEmpty(request.getParameter("microsoftLogin")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());

        // adding emails
        Set<Email> emailsOfBean = bean.getEmails();
        String[] emails = {"emailOffice", "emailHome", "emailAdd"};
        for (String emailTypeString : emails) {
            String[] emailsValues = request.getParameterValues(emailTypeString);

            for (int i = 0; emailsValues != null && i < emailsValues.length; i++) {
                int emailTypeId = 0;
                // если поле с почтой пустое, выходим, чтобы не сохранять
                if (emailsValues[i].trim().isEmpty()) {
                    continue;
                }
                Email email = new Email(emailsValues[i].trim(), true, true, new Date());
                if (emailTypeString.equals("emailOffice")) {
                    emailTypeId = 2;
                } else if (emailTypeString.equals("emailHome")) {
                    emailTypeId = 1;
                } else if (emailTypeString.equals("emailAdd")) {
                    emailTypeId = 3;
                } else {
                    throw new EltcException("Unknown email type: " + emailTypeString);
                }
                EmailType emailType = model.getObject(emailTypeId, EmailType.class);
                email.setEmailType(emailType);
                email.setStudent(bean);
                email.setUser(getCurrentUserLogin(request));
                email.setStudent(bean);
                emailsOfBean.add(email);
            }

        }
        bean.setEmails(emailsOfBean);
        /*
         String[] emailOffices = request.getParameterValues("emailOffice");
         String[] emailHomes = request.getParameterValues("emailHome");
         String[] emailAdds = request.getParameterValues("emailAdd");

         if (emailOffices != null) {
         for (int i = 0; i < emailOffices.length; i++) {
         Email email = new Email(emailOffices[i], false, false);
         EmailType emailType = model.getObject(2, EmailType.class);
         email.setEmailType(emailType);
         emailsOfBean.add(email);
         }
         }

         if (emailHomes != null) {
         for (int i = 0; i < emailHomes.length; i++) {
         Email email = new Email(emailHomes[i], false, false);
         EmailType emailType = model.getObject(1, EmailType.class);
         email.setEmailType(emailType);
         emailsOfBean.add(email);
         }
         }

         if (emailAdds != null) {
         for (int i = 0; i < emailAdds.length; i++) {
         Email email = new Email(emailAdds[i], false, false);
         EmailType emailType = model.getObject(3, EmailType.class);
         email.setEmailType(emailType);
         emailsOfBean.add(email);
         }
         }
         */
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Student bean = new Student();
        String ext = "_" + getCount();

        bean.setId(null);

        Sex sex = new Sex();
        sex.setId((int) (Math.random() * 2) + 1);
        bean.setSex(sex);

        bean.setLastNameRu("Фамилия" + ext);
        bean.setFirstNameRu("firstNameRu" + ext);

        bean.setPatronicNameRu("patronicNameRu" + ext);
        bean.setLastNameEn("lastNameEn" + ext);
        bean.setFirstNameEn("firstNameEn" + ext);
        bean.setPatronicNameEn("patronicNameEn" + ext);
        bean.setDateOfBirth(getRandomDate());
//        bean.setEmailOffice("emailOffice" + ext + "@dd.com");
//        bean.setEmailHome("emailHome" + ext + "@dd.com");
//        bean.setEmailAdd("emailAdd" + ext + "@dd.com");
        bean.setPhoneHome("phoneHome" + ext);
        bean.setPhoneMobile1("phoneMobile1" + ext);
        bean.setPhoneMobile2("phoneMobile2" + ext);
        bean.setPhoneOffice("phoneOffice" + ext);
        bean.setSkype("skype" + ext + "skype" + ext);
        bean.setIcq("icq" + ext + "icq" + ext);
        bean.setMailruAgent("mailruAgent" + ext + "mailruAgent" + ext);
        bean.setComments("comments" + ext);
        bean.setPhoto("photo" + ext);
        bean.setPersonVueIdent("personVueIdent" + ext);
        bean.setPrometricIdent("prometricIdent" + ext);
        bean.setOracleLogin("oracleLogin" + ext);
        bean.setMicrosoftLogin("microsoftLogin" + ext);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());


        // bean.setEmailOffice(getNullifEmpty(request.getParameter("emailOffice")));
//        bean.setEmailHome(getNullifEmpty(request.getParameter("emailHome")));
//        bean.setEmailAdd(getNullifEmpty(request.getParameter("emailAdd")));





        return bean;
    }
}
