/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.Certificate;
import domain.Trainer;
import domain.TrainerCertificate;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateTrainerCertificate extends AbstractCreateBean {

    public CreateTrainerCertificate(HttpServletRequest request) {
        super(request);
    }

    
    @Override
    public Object createBeanFromJSP() throws EltcException {
        TrainerCertificate bean = new TrainerCertificate();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Certificate certificate = getObjectIfIdIsNumber(Certificate.class, request, "certificate");
        bean.setCertificate(certificate);


        Trainer trainer = getObjectIfIdIsNumber(Trainer.class, request, "trainer");
        bean.setTrainer(trainer);

        bean.setDate(getDateFromString(request.getParameter("date")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        TrainerCertificate bean = new TrainerCertificate();
        String ext = "_" + getCount();
        bean.setId(null);

        Certificate certificate = new Certificate();
        certificate.setId(getRandomMaxLimit(30));
        bean.setCertificate(certificate);

        Trainer trainer = new Trainer();
        trainer.setId(getRandomMaxLimit(30));
        bean.setTrainer(trainer);

        bean.setDate(getRandomDate());
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}