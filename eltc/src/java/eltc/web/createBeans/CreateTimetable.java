/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Auditory;
import domain.Course;
import domain.Timetable;
import domain.Trainer;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTimetable extends AbstractCreateBean {

    public CreateTimetable(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Timetable bean = new Timetable();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Course course = getObjectIfIdIsNumber(Course.class, request, "course");
        bean.setCourse(course);

        Trainer trainerByTrainerOfficialId = getObjectIfIdIsNumber(Trainer.class, request, "trainerByTrainerOfficialId");
        bean.setTrainerByTrainerOfficialId(trainerByTrainerOfficialId);

        Trainer trainerByTrainerFactId = getObjectIfIdIsNumber(Trainer.class, request, "trainerByTrainerFactId");
        bean.setTrainerByTrainerFactId(trainerByTrainerFactId);

        Auditory auditory = getObjectIfIdIsNumber(Auditory.class, request, "auditory");
        bean.setAuditory(auditory);

        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Timetable bean = new Timetable();
        String ext = "_" + getCount();
        bean.setId(null);

        Course course = new Course();
        course.setId(getRandomMaxLimit(3));
        bean.setCourse(course);


        Trainer trainerByTrainerOfficialId = new Trainer();
        trainerByTrainerOfficialId.setId(getRandomMaxLimit(3));
        bean.setTrainerByTrainerOfficialId(trainerByTrainerOfficialId);


        Trainer trainerByTrainerFactId = new Trainer();
        trainerByTrainerFactId.setId(getRandomMaxLimit(3));
        bean.setTrainerByTrainerFactId(trainerByTrainerFactId);


        Auditory auditory = new Auditory();
        auditory.setId(getRandomMaxLimit(3));
        bean.setAuditory(auditory);

        bean.setDate(getRandomDate());
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}