/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.test;

import domain.*;
import java.io.File;
import java.util.List;
import eltc.model.EltcException;
import eltc.model.Model;
import eltc.model.ModelImpl;
import static eltc.web.createBeans.AbstractCreateBean.getRandomDate;
import java.util.Date;

public class Test {

    public static void renameFiles() {
        // File folder = new File("C:\\temp\\NetBeansProjects\\eltc_s\\eltc\\web\\WEB-INF\\view\\oldList");
        File folder = new File("C:\\temp\\NetBeansProjects\\eltc_s\\eltc\\web\\WEB-INF\\listFragments");
        System.out.println("folder = " + folder.exists());
        System.out.println("folder = " + folder.isDirectory());
        String[] files = folder.list();
        for (String string : files) {
//            System.out.println("ren " + string + " " + string.substring(0, string.indexOf("List")) + ".jspf");
            System.out.println("ren " + string + " " + string.substring(0, string.length() - 1));
        }


    }

    public static void main(String[] args) throws EltcException {
        Model model = ModelImpl.getInstance();
        List<Student> list = model.getObjectsSafelyDeletedFromTo(1, 10, new Student(), "order by id desc");
        for (Student student : list) {
            System.out.println("student = " + student.getId());
        }
    }

    public static void testAddStudent(String[] args) throws EltcException, InterruptedException {
        ModelImpl model = ModelImpl.getInstance();
        Student student = new Student();
        student.setLastNameRu("");
        student.setFirstNameRu("");
        student.setComments("");
        String email = "zvon";
        student.getEmails().add(new Email(email, true, true, null));
        List<Student> list = model.findObjects(-100, 0, student);
        // List<Student> list2 = model.findObjects(1, 10, student);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + " - " + list.get(i).getEmails());
        }
//        int size = model.getSizeFindStudents(student, email);
//        System.out.println(list.size());
//        System.out.println("size = " + size);
    }

    public static Object createTestBean() {
        Student bean = new Student();
        String ext = "_" + (int) (Math.random() * 10000);

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
        bean.setPhoneHome("phoneHome" + ext);
        bean.setPhoneMobile1("phoneMobile1" + ext);
        bean.setPhoneMobile2("phoneMobile2" + ext);
        bean.setPhoneOffice("phoneOffice" + ext);
        bean.setSkype("skype" + ext);
        bean.setIcq("icq" + ext);
        bean.setMailruAgent("mailruAgent" + ext);
        bean.setComments("comments" + ext);
        bean.setPhoto("photo" + ext);
        bean.setPersonVueIdent("personVueIdent" + ext);
        bean.setPrometricIdent("prometricIdent" + ext);
        bean.setOracleLogin("oracleLogin" + ext);
        bean.setMicrosoftLogin("microsoftLogin" + ext);
        bean.setUser("user" + ext);
        bean.setInsertDatetime(new Date());
        return bean;
    }

 
    
    
}
