/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Course;
import domain.Trainer;
import domain.TrainerPassedCourse;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTrainerPassedCourse extends AbstractCreateBean {

    public CreateTrainerPassedCourse(HttpServletRequest request) {
        super(request);
    }

    
    @Override
    public Object createBeanFromJSP() throws EltcException {
        TrainerPassedCourse bean = new TrainerPassedCourse();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Course course = getObjectIfIdIsNumber(Course.class, request, "course");
        bean.setCourse(course);

        Trainer trainer = getObjectIfIdIsNumber(Trainer.class, request, "trainer");
        bean.setTrainer(trainer);

        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        TrainerPassedCourse bean = new TrainerPassedCourse();
        String ext = "_" + getCount();
        bean.setId(null);

        Course course = new Course();
        course.setId(getRandomMaxLimit(100));
        bean.setCourse(course);


        Trainer trainer = new Trainer();
        trainer.setId(getRandomMaxLimit(100));
        bean.setTrainer(trainer);

        bean.setDate(getRandomDate());
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}