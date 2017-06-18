package eltc.web.pageNavig;

import domain.*;
import eltc.web.Registration;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author sanzhar.ismailov
 */
public enum EntityEnum {

    NO_ACTION_Entity(null, null, null),
    STUDENT(new Student(), "student", "list_student"),
    MANAGER(new Manager(), "manager", "list_manager"),
    TRAINER(new Trainer(), "trainer", "list_trainer"),
    AUDITORY(new Auditory(), "auditory", "list_auditory"),
    CATEGORY(new Category(), "category", "list_category"),
    COUNTRY(new Country(), "country", "list_country"),
    COURSE_TYPE(new CourseType(), "course_type", "list_course_type"),
    CURRENCY(new Currency(), "currency", "list_currencie"),
    INDUSTRY(new Industry(), "industry", "list_industrie"),
    SPECIALIZATION(new Specialization(), "specialization", "list_specialization"),
    VENDOR(new Vendor(), "vendor", "list_vendor"),
    TYPE_OWNERSHIP(new TypeOwnership(), "type_ownership", "list_type_ownership"),
    CITY(new City(), "city", "list_city"),
    CONTRACT(new Contract(), "contract", ""),
    COURSE(new Course(), "course", ""),
    COURSE_OFFICIAL(new CourseOfficial(), "course_official", ""),
    COURSE_OFFICIAL_PRICE(new CourseOfficialPrice(), "course_official_price", ""),
    COURSE_SPECIALIZATION(new CourseSpecialization(), "course_specialization", ""),
    HR_MANAGER(new HrManager(), "hr_manager", ""),
    ORGANIZATION(new Organization(), "organization", ""),
    ORGANIZATION_HR_MANAGER(new OrganizationHrManager(), "organization_hr_manager", ""),
    CERTIFICATE(new Certificate(), "certificate", ""),
    TIMETABLE(new Timetable(), "timetable", ""),
    TIMETABLE_STUDENT(new TimetableStudent(), "timetable_student", ""),
    TRAINER_CERTIFICATE(new TrainerCertificate(), "trainer_certificate", ""),
    TRAINER_PASSED_COURSE(new TrainerPassedCourse(), "trainer_passed_course", ""),
    TRAINER_SPECIALIZATION(new TrainerSpecialization(), "trainer_specialization", ""),
    VENDOR_AGREEMENT(new VendorAgreement(), "vendor_agreement", ""),
    EMAIL(new Email(), "email", ""),
    EMAIL_TYPE(new EmailType(), "emailType", ""),
    STUDENT_ORGANIZATION(new StudentOrganization(), "student_organization", ""),
    REGISTRATION(new Registration(), "registration", ""),
    REGION(new Region(), "region", "list_region");
    private Object entityObject;
    private String singleForm;
    private String pluralFormListOf;

    private EntityEnum(Object entityObject, String singleForm, String pluralFormListOf) {
        this.entityObject = entityObject;
        this.singleForm = singleForm;
        this.pluralFormListOf = pluralFormListOf;
    }

    public Object getEntityObject() {
        return entityObject;
    }

    public Class getClassOfElements() {
//        if (entityObject.getClass().isArray()) {
//            return entityObject.getClass().getComponentType();
//        }
        return entityObject.getClass();
    }

    public String getSingleForm() {
        return singleForm;
    }

    public String getPluralFormListOf() {
        return pluralFormListOf;
    }

    public String getTranslateFormListOf() {
        return ServletUtilMethods.getTranString("list_" + singleForm);
    }

    public String getEnumAsStringLawerCase(EntityEnum en) {
        return en.toString().toLowerCase();
    }
}
