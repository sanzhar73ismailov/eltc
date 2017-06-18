/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Course;
import domain.CourseSpecialization;
import domain.Specialization;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateCourseSpecialization extends AbstractCreateBean {

    public CreateCourseSpecialization(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        CourseSpecialization bean = new CourseSpecialization();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Course course = getObjectIfIdIsNumber(Course.class,request,  "course");
        bean.setCourse(course);

        Specialization specialization = getObjectIfIdIsNumber(Specialization.class, request, "specialization");
        bean.setSpecialization(specialization);

        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        CourseSpecialization bean = new CourseSpecialization();
        String ext = "_" + getCount();
        bean.setId(null);

        Course course = new Course();
        course.setId(getRandomMaxLimit(3));
        bean.setCourse(course);


        Specialization specialization = new Specialization();
        specialization.setId(getRandomMaxLimit(3));
        bean.setSpecialization(specialization);

        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}