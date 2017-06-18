/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import domain.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import eltc.web.showBean.*;

/**
 *
 * @author sanzhar.ismailov
 */
public class ShowBeanAsWeb {

    public static String getSetWebString(Object obj) {
        AbstractBeanShow beanShow = null;

        if (obj instanceof Student) {
            beanShow = new StudentBeanShow();
        } else if (obj instanceof Manager) {
            beanShow = new ManagerBeanShow();
        } else if (obj instanceof Trainer) {
            beanShow = new TrainerBeanShow();
        } else if (obj instanceof City) {
            beanShow = new CityBeanShow();
        } else if (obj instanceof Contract) {
            beanShow = new ContractBeanShow();
        } else if (obj instanceof Course) {
            beanShow = new CourseBeanShow();
        } else if (obj instanceof CourseOfficial) {
            beanShow = new CourseOfficialBeanShow();
        } else if (obj instanceof CourseOfficialPrice) {
            beanShow = new CourseOfficialPriceBeanShow();
        } else if (obj instanceof CourseSpecialization) {
            beanShow = new CourseSpecializationBeanShow();
        } else if (obj instanceof HrManager) {
            beanShow = new HrManagerBeanShow();
        } else if (obj instanceof Organization) {
            beanShow = new OrganizationBeanShow();
        } else if (obj instanceof OrganizationHrManager) {
            beanShow = new OrganizationHrManagerBeanShow();
        } else if (obj instanceof Certificate) {
            beanShow = new CertificateBeanShow();
        } else if (obj instanceof Timetable) {
            beanShow = new TimetableBeanShow();
        } else if (obj instanceof TimetableStudent) {
            beanShow = new TimetableStudentBeanShow();
        } else if (obj instanceof TrainerCertificate) {
            beanShow = new TrainerCertificateBeanShow();
        } else if (obj instanceof TrainerPassedCourse) {
            beanShow = new TrainerPassedCourseBeanShow();
        } else if (obj instanceof TrainerSpecialization) {
            beanShow = new TrainerSpecializationBeanShow();
        } else if (obj instanceof TypeOwnership) {
            beanShow = new TypeOwnershipBeanShow();
        } else if (obj instanceof VendorAgreement) {
            beanShow = new VendorAgreementBeanShow();
        } else if (obj instanceof Email) {
            beanShow = new EmailBeanShow();
        } else if (obj instanceof StudentOrganization) {
            beanShow = new StudentOrganizationBeanShow();
        } else if (obj instanceof DictionaryInterface) {
            beanShow = new DictionaryShowBean();
        } else {
            throw new RuntimeException("Unknow instance in ShowBeanAsWeb.getSetWebString() method");
        }
        beanShow.setEntity(obj);

        return beanShow.getAsWebString();
    }
   
}
