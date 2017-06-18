package eltc.web.showBean.stringObjects;

import domain.Timetable;

public class TimetableObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        Timetable bean = (Timetable) object;
        return bean.getCourse().getCodeOwn() + " " + bean.getCourse().getNameRu() + bean.getDate();
    }
}
