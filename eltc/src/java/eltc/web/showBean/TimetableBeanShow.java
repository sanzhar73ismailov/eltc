package eltc.web.showBean;

import domain.Timetable;
import domain.TimetableStudent;
import domainComparators.StudentTimeTableComparatorByLastNameAsc;
import java.util.List;

public class TimetableBeanShow extends AbstractBeanShow {

    @Override
    public String getAsWebString() {
        Timetable bean = (Timetable) entity;
        map.put(rb.getString("id"), getAsString(bean.getId()));
        map.put(rb.getString("course"), getAsString(bean.getCourse()));
        map.put(rb.getString("trainerByTrainerOfficialId"), getAsString(bean.getTrainerByTrainerOfficialId()));
        map.put(rb.getString("trainerByTrainerFactId"), getAsString(bean.getTrainerByTrainerFactId()));
        map.put(rb.getString("auditory"), getAsString(bean.getAuditory()));
        map.put(rb.getString("date"), getAsString(bean.getDate()));
        map.put(rb.getString("user"), getAsString(bean.getUser()));
        map.put(rb.getString("insertDatetime"), getAsString(bean.getInsertDatetime()));

        List<TimetableStudent> studentTimeTableList =
                getSortedListFromSet(bean.getTimetableStudents(), new StudentTimeTableComparatorByLastNameAsc());
        String key = rb.getString("students");
        String value = "<div class='studentsOf'>";
        for (int i = 0; i < studentTimeTableList.size(); i++) {
            TimetableStudent element = studentTimeTableList.get(i);
            domain.Student student = element.getStudent();
            value += (i + 1) + ". ";
            value += getAsString(element.getStudent())
                    + " " + getAsViewHref(student.getId(), student) + " " + getAsEditHref(student.getId(), student)
                    + "<br/>";
        }
        value += "</div>";
        map.put(key, value);

        return fromMapToWebString(map);
    }
}
