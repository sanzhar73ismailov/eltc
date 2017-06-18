package eltc.web.showBean.stringObjects;

import domain.CourseOfficial;

public class CourseOfficialObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        CourseOfficial bean = (CourseOfficial) object;
        return bean.getCode() + " " + bean.getCourse().getNameRu() + " " + bean.getCourseType().getName();
    }
}
