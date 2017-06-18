/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Specialization;
import domain.Trainer;
import domain.TrainerSpecialization;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTrainerSpecialization extends AbstractCreateBean {

    public CreateTrainerSpecialization(HttpServletRequest request) {
        super(request);
    }

    
    @Override
    public Object createBeanFromJSP() throws EltcException {
        TrainerSpecialization bean = new TrainerSpecialization();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Specialization specialization = getObjectIfIdIsNumber(Specialization.class, request, "specialization");
        bean.setSpecialization(specialization);


        Trainer trainer = getObjectIfIdIsNumber(Trainer.class, request, "trainer");
        bean.setTrainer(trainer);

        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        TrainerSpecialization bean = new TrainerSpecialization();
        String ext = "_" + getCount();
        bean.setId(null);

        Specialization specialization = new Specialization();
        specialization.setId(getRandomMaxLimit(30));
        bean.setSpecialization(specialization);


        Trainer trainer = new Trainer();
        trainer.setId(getRandomMaxLimit(50));
        bean.setTrainer(trainer);

        bean.setDate(getRandomDate());
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}
