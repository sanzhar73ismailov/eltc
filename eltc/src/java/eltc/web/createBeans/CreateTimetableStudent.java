/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Contract;
import domain.CourseOfficial;
import domain.Manager;
import domain.Student;
import domain.Timetable;
import domain.TimetableStudent;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTimetableStudent extends AbstractCreateBean {

    public CreateTimetableStudent(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        TimetableStudent bean = new TimetableStudent();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Manager manager = getObjectIfIdIsNumber(Manager.class, request, "manager");
        bean.setManager(manager);


        CourseOfficial courseOfficial = getObjectIfIdIsNumber(CourseOfficial.class, request, "courseOfficial");
        bean.setCourseOfficial(courseOfficial);


        Student student = getObjectIfIdIsNumber(Student.class, request, "student");
        bean.setStudent(student);


        Timetable timetable = getObjectIfIdIsNumber(Timetable.class, request, "timetable");
        bean.setTimetable(timetable);


        Contract contract = getObjectIfIdIsNumber(Contract.class, request, "contract");
        bean.setContract(contract);

        bean.setPriceFact(getFloatifEmpty(request.getParameter("priceFact")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        TimetableStudent bean = new TimetableStudent();
        String ext = "_" + getCount();
        bean.setId(null);

        Manager manager = new Manager();
        manager.setId(getRandomMaxLimit(3));
        bean.setManager(manager);


        CourseOfficial courseOfficial = new CourseOfficial();
        courseOfficial.setId(getRandomMaxLimit(20));
        bean.setCourseOfficial(courseOfficial);


        Student student = new Student();
        student.setId(getRandomMaxLimit(300));
        bean.setStudent(student);


        Timetable timetable = new Timetable();
        timetable.setId(getRandomMaxLimit(3));
        bean.setTimetable(timetable);


        Contract contract = new Contract();
        contract.setId(getRandomMaxLimit(3));
        bean.setContract(contract);

        bean.setPriceFact((float) getRandomMaxLimit(100));
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}