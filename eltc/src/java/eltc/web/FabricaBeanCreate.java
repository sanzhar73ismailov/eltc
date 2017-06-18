/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import eltc.web.createBeans.*;
import domain.*;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.model.Model;
import eltc.web.pageNavig.EntityEnum;
import static eltc.web.pageNavig.EntityEnum.*;

/**
 *
 * @author user
 */
public class FabricaBeanCreate {

    public static Object createBean(EntityEnum entity, HttpServletRequest request) throws EltcException {
        AbstractCreateBean createBean = null;

        switch (entity) {
            case STUDENT:
                createBean = new CreateStudent(request);
                break;
            case MANAGER:
                createBean = new CreateManager(request);
                break;
            case TRAINER:
                createBean = new CreateTrainer(request);
                break;
            case CITY:
                createBean = new CreateCity(request);
                break;
            case TYPE_OWNERSHIP:
                createBean = new CreateTypeOwnership(request);
                break;
            case CONTRACT:
                createBean = new CreateContract(request);
                break;
            case COURSE:
                createBean = new CreateCourse(request);
                break;
            case COURSE_OFFICIAL:
                createBean = new CreateCourseOfficial(request);
                break;
            case COURSE_OFFICIAL_PRICE:
                createBean = new CreateCourseOfficialPrice(request);
                break;
            case COURSE_SPECIALIZATION:
                createBean = new CreateCourseSpecialization(request);
                break;
            case HR_MANAGER:
                createBean = new CreateHrManager(request);
                break;
            case ORGANIZATION:
                createBean = new CreateOrganization(request);
                break;
            case ORGANIZATION_HR_MANAGER:
                createBean = new CreateOrganizationHrManager(request);
                break;
            case CERTIFICATE:
                createBean = new CreateSertificate(request);
                break;
            case TIMETABLE:
                createBean = new CreateTimetable(request);
                break;
            case TIMETABLE_STUDENT:
                createBean = new CreateTimetableStudent(request);
                break;
            case TRAINER_CERTIFICATE:
                createBean = new CreateTrainerCertificate(request);
                break;
            case TRAINER_PASSED_COURSE:
                createBean = new CreateTrainerPassedCourse(request);
                break;
            case TRAINER_SPECIALIZATION:
                createBean = new CreateTrainerSpecialization(request);
                break;
            case VENDOR_AGREEMENT:
                createBean = new CreateVendorAgreement(request);
                break;
            case EMAIL:
                createBean = new CreateEmail(request);
                break;
            case STUDENT_ORGANIZATION:
                createBean = new CreateStudentOrganization(request);
                break;
            case REGISTRATION:
                createBean = new CreateRegistration(request);
                break;
            case REGION:
            case VENDOR:
            case AUDITORY:
            case CATEGORY:
            case COUNTRY:
            case COURSE_TYPE:
            case CURRENCY:
            case INDUSTRY:
            case SPECIALIZATION:
                createBean = new CreateDic(entity, request);
                break;
            default:
                throw new EltcException("Unknown entity in FabricaBeanCreate.createBean: " + entity);
        }


        return createBean.createBeanFromJSP();
    }

    public static Object createTestBean(EntityEnum entity, HttpServletRequest request) throws EltcException {
        AbstractCreateBean createBean = null;

        switch (entity) {
            case STUDENT:
                createBean = new CreateStudent(request);
                break;
            case MANAGER:
                createBean = new CreateManager(request);
                break;
            case TRAINER:
                createBean = new CreateTrainer(request);
                break;
            case CITY:
                createBean = new CreateCity(request);
                break;
            case TYPE_OWNERSHIP:
                createBean = new CreateTypeOwnership(request);
                break;
            case CONTRACT:
                createBean = new CreateContract(request);
                break;
            case COURSE:
                createBean = new CreateCourse(request);
                break;
            case COURSE_OFFICIAL:
                createBean = new CreateCourseOfficial(request);
                break;
            case COURSE_OFFICIAL_PRICE:
                createBean = new CreateCourseOfficialPrice(request);
                break;
            case COURSE_SPECIALIZATION:
                createBean = new CreateCourseSpecialization(request);
                break;
            case HR_MANAGER:
                createBean = new CreateHrManager(request);
                break;
            case ORGANIZATION:
                createBean = new CreateOrganization(request);
                break;
            case ORGANIZATION_HR_MANAGER:
                createBean = new CreateOrganizationHrManager(request);
                break;
            case CERTIFICATE:
                createBean = new CreateSertificate(request);
                break;
            case TIMETABLE:
                createBean = new CreateTimetable(request);
                break;
            case TIMETABLE_STUDENT:
                createBean = new CreateTimetableStudent(request);
                break;
            case TRAINER_CERTIFICATE:
                createBean = new CreateTrainerCertificate(request);
                break;
            case TRAINER_PASSED_COURSE:
                createBean = new CreateTrainerPassedCourse(request);
                break;
            case TRAINER_SPECIALIZATION:
                createBean = new CreateTrainerSpecialization(request);
                break;
            case VENDOR_AGREEMENT:
                createBean = new CreateVendorAgreement(request);
                break;
            case EMAIL:
                createBean = new CreateEmail(request);
                break;
            case STUDENT_ORGANIZATION:
                createBean = new CreateStudentOrganization(request);
                break;


            default:
                if (entity.getEntityObject() instanceof DictionaryInterface) {
                    createBean = new CreateDic(entity, request);
                } else {
                    throw new EltcException("Unknown entity in FabricaBeanCreate.createTestBean: " + entity);
                }
        }


        return createBean.createTestBeanForJSP();
    }

    public static void setListAttibutes(EntityEnum entity, HttpServletRequest request, Model model) throws EltcException {
        int studentId = 0;
        switch (entity) {
//             case STUDENT:
//                request.setAttribute("countries", model.getObjectsSafelyDeleted(new Country()));
//                break;
            case CITY:
                request.setAttribute("countries", model.getObjectsSafelyDeleted(new Country()));
                break;
            case CONTRACT:
                request.setAttribute("organizations", model.getObjectsSafelyDeleted(new Organization()));
                break;
            case COURSE:
                request.setAttribute("vendors", model.getObjectsSafelyDeleted(new Vendor()));
                request.setAttribute("сategories", model.getObjectsSafelyDeleted(new Category()));
                break;
            case COURSE_OFFICIAL:
                request.setAttribute("courseTypes", model.getObjectsSafelyDeleted(new CourseType()));
                request.setAttribute("courses", model.getObjectsSafelyDeleted(new Course()));
                break;
            case COURSE_OFFICIAL_PRICE:
                request.setAttribute("courseOfficials", model.getObjectsSafelyDeleted(new CourseOfficial()));
                request.setAttribute("currencies", model.getObjectsSafelyDeleted(new Currency()));
                break;
            case COURSE_SPECIALIZATION:
                request.setAttribute("courses", model.getObjectsSafelyDeleted(new Course()));
                request.setAttribute("specializations", model.getObjectsSafelyDeleted(new Specialization()));
                break;
            case ORGANIZATION:
                request.setAttribute("regions", model.getObjectsSafelyDeleted(new Region()));
                request.setAttribute("vendors", model.getObjectsSafelyDeleted(new Vendor()));
                request.setAttribute("industries", model.getObjectsSafelyDeleted(new Industry()));
                request.setAttribute("typeOwnerships", model.getObjectsSafelyDeleted(new TypeOwnership()));
                request.setAttribute("cities", model.getObjectsSafelyDeleted(new City()));
                break;
            case ORGANIZATION_HR_MANAGER:
                request.setAttribute("organizations", model.getObjectsSafelyDeleted(new Organization()));
                request.setAttribute("hrManagers", model.getObjectsSafelyDeleted(new HrManager()));
                break;
            case CERTIFICATE:
                request.setAttribute("vendors", model.getObjectsSafelyDeleted(new Vendor()));
                break;
            case TIMETABLE:
                request.setAttribute("vendors", model.getObjectsSafelyDeleted(new Vendor()));
                request.setAttribute("categories", model.getObjectsSafelyDeleted(new Category()));
                request.setAttribute("courses", model.getObjectsSafelyDeleted(new Course()));
                request.setAttribute("trainers", model.getObjectsSafelyDeleted(new Trainer()));
                request.setAttribute("auditories", model.getObjectsSafelyDeleted(new Auditory()));
                break;
            case TIMETABLE_STUDENT:
                request.setAttribute("timetables", model.getObjectsSafelyDeleted(new Timetable()));
                request.setAttribute("students", model.getObjectsSafelyDeleted(new Student()));
                request.setAttribute("contracts", model.getObjectsSafelyDeleted(new Contract()));
                request.setAttribute("courseOfficials", model.getObjectsSafelyDeleted(new CourseOfficial()));
                request.setAttribute("managers", model.getObjectsSafelyDeleted(new Manager()));
                break;
            case TRAINER_CERTIFICATE:
                request.setAttribute("trainers", model.getObjectsSafelyDeleted(new Trainer()));
                request.setAttribute("certificates", model.getObjectsSafelyDeleted(new Certificate()));
                break;
            case TRAINER_PASSED_COURSE:
                request.setAttribute("trainers", model.getObjectsSafelyDeleted(new Trainer()));
                request.setAttribute("courses", model.getObjectsSafelyDeleted(new Course()));
                break;
            case TRAINER_SPECIALIZATION:
                request.setAttribute("trainers", model.getObjectsSafelyDeleted(new Trainer()));
                request.setAttribute("specializations", model.getObjectsSafelyDeleted(new Specialization()));
                break;
            case VENDOR_AGREEMENT:
                request.setAttribute("vendors", model.getObjectsSafelyDeleted(new Vendor()));
                break;
            case EMAIL:
                studentId = 0;
                if (request.getParameter("student") != null) {
                    studentId = Integer.parseInt(request.getParameter("student"));
                    request.setAttribute("student", model.getObject(studentId, Student.class));
                } else {
                    request.setAttribute("students", model.getObjectsSafelyDeleted(new Student()));
                }
                request.setAttribute("emailTypes", model.getObjectsSafelyDeleted(new EmailType()));
                break;
            case STUDENT_ORGANIZATION:
                studentId = 0;
                if (request.getParameter("student") != null) {
                    studentId = Integer.parseInt(request.getParameter("student"));
                    request.setAttribute("student", model.getObject(studentId, Student.class));
                } else {
                    request.setAttribute("students", model.getObjectsSafelyDeleted(new Student()));
                }
                request.setAttribute("organizations", model.getObjectsSafelyDeleted(new Organization()));
                break;
            default:
        }
    }
}
