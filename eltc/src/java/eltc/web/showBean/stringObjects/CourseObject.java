package eltc.web.showBean.stringObjects;

import domain.Course;

public class CourseObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        Course bean = (Course) object;
        return bean.getCodeOwn() + " " + bean.getNameRu();
    }
}
