/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Course;
import domain.CourseOfficial;
import domain.CourseType;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getRandomMaxLimit;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateCourseOfficial extends AbstractCreateBean {

    public CreateCourseOfficial(HttpServletRequest request) {
        super(request);
    }

    @Override
public Object createBeanFromJSP() throws EltcException {
        CourseOfficial bean = new CourseOfficial();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Course course =  getObjectIfIdIsNumber(Course.class,request,  "course");
        bean.setCourse(course);

        CourseType courseType =  getObjectIfIdIsNumber(CourseType.class, request, "courseType");
        bean.setCourseType(courseType);

        bean.setCode(getNullifEmpty(request.getParameter("code")));
        bean.setAdditionalInfo(getNullifEmpty(request.getParameter("additionalInfo")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;

    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        CourseOfficial bean = new CourseOfficial();
        String ext = "_" + getCount();
        bean.setId(null);

        Course course = new Course();
        course.setId(getRandomMaxLimit(10));
        bean.setCourse(course);

        CourseType courseType = new CourseType();
        courseType.setId(getRandomMaxLimit(2));
        bean.setCourseType(courseType);
        bean.setCode("code" + ext);
        bean.setAdditionalInfo("additionalInfo" + ext);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}