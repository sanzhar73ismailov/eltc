package eltc.model;

import domain.Sex;
import domain.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Database instance;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void printAllStudents(Database me) {
        for (Student st : me.getStudents()) {
            System.out.println("" + st);
        }
    }
    private List<Student> students;

    private Database() {
        try {
            students = fullFillStudents();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(Student student) throws Exception {
        if (student.getId() == 0) {
            throw new Exception("student without id");
        }
        int index = getStudentDbIndex(student.getId());
        students.set(index, student);
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }

        }
        return null;
    }

    public int getStudentDbIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }

        }
        return 0;
    }

    public boolean removeStudent(int id) {
        int index = -1;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                index = i;
                students.remove(index);
                break;
            }
        }
        return index != -1;
    }

    public List<Student> fullFillStudentsNew() {
        List<Student> students = new ArrayList<Student>();
        String[] fNames = {"Iсмет",
            "Абай",
            "Абзал",
            "Абыз",
            "Абылай",
            "Агзам",
            "Адия",
            "Ажар",
            "Азамат",
            "Азат",
            "Аида",
            "Айбала",
            "Айбар",
            "Айбарша",
            "Айбике",
            "Айганша",
            "Айгул",
            "Айдана",
            "Айдар",
            "Айжамал"};
        Student st = null;
        for (int i = 0; i < fNames.length; i++) {
            long l = 1000 * 60 * 60 * 24 * 360 * 50;

//            st = new StudentOld(fNames[i], "Фамил_" + (i + 1), "email_" + (i + 1), new Date(l));
            st = new Student(new Sex("sex"),
                    "Фамил_" + (i + 1),
                    fNames[i],
                    "Отч_" + (i + 1),
                    "1", "2",
                    new Date());
            students.add(st);
        }
        return students;
    }

    public List<Student> fullFillStudents() throws EltcException {
        students = new ArrayList<Student>();
        String[] fNames = {"Iсмет",
            "Абай",
            "Абзал",
            "Абыз",
            "Абылай",
            "Агзам",
            "Адия",
            "Ажар",
            "Азамат",
            "Азат",
            "Аида",
            "Айбала",
            "Айбар",
            "Айбарша",
            "Айбике",
            "Айганша",
            "Айгул",
            "Айдана",
            "Айдар",
            "Айжамал"};
        Student st = null;
        for (int i = 0; i < fNames.length; i++) {
            long l = 1000 * 60 * 60 * 24 * 360 * 50;
//            Model model = new ModelImpl();
            //st = new Student(fNames[i], "Фамил_" + (i + 1), "email_" + (i + 1), new Date(l));
//            Sex maleSex = (Sex) model.getObject(1, Sex.class);
            Sex maleSex = new Sex("муж");
            maleSex.setId(1);
            st = new Student(maleSex, "Фамил_" + (i + 1), fNames[i], "pN", "lNE", "fNe", new Date());
            st.setDateOfBirth(new Date(l));
            st.setId(i+1);
            students.add(st);
        }
        return students;
    }

    public static void main(String[] args) {
        Database me = new Database();
        printAllStudents(me);

//        me.addStudent(new Student());
//        printAllStudents(me);
//        System.out.println(me.removeStudent(19));
//        printAllStudents(me);
//        System.out.println(me.removeStudent(19));
//        printAllStudents(me);
    }
}
