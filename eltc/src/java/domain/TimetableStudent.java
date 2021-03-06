package domain;
// Generated Jul 10, 2013 10:55:17 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TimetableStudent generated by hbm2java
 */
public class TimetableStudent  implements java.io.Serializable, eltc.web.DeletableInterface {


     private Integer id;
     private Manager manager;
     private CourseOfficial courseOfficial;
     private Student student;
     private Timetable timetable;
     private Contract contract;
     private Float priceFact;
     private boolean deleted;
     private String user;
     private Date insertDatetime;

    public TimetableStudent() {
    }

	
    public TimetableStudent(Manager manager, CourseOfficial courseOfficial, Student student, Timetable timetable, Contract contract, Date insertDatetime) {
        this.manager = manager;
        this.courseOfficial = courseOfficial;
        this.student = student;
        this.timetable = timetable;
        this.contract = contract;
        this.insertDatetime = insertDatetime;
    }
    public TimetableStudent(Manager manager, CourseOfficial courseOfficial, Student student, Timetable timetable, Contract contract, Float priceFact, String user, Date insertDatetime) {
       this.manager = manager;
       this.courseOfficial = courseOfficial;
       this.student = student;
       this.timetable = timetable;
       this.contract = contract;
       this.priceFact = priceFact;
       this.user = user;
       this.insertDatetime = insertDatetime;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Manager getManager() {
        return this.manager;
    }
    
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public CourseOfficial getCourseOfficial() {
        return this.courseOfficial;
    }
    
    public void setCourseOfficial(CourseOfficial courseOfficial) {
        this.courseOfficial = courseOfficial;
    }
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    public Timetable getTimetable() {
        return this.timetable;
    }
    
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }
    public Contract getContract() {
        return this.contract;
    }
    
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public Float getPriceFact() {
        return this.priceFact;
    }
    
    public void setPriceFact(Float priceFact) {
        this.priceFact = priceFact;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    public Date getInsertDatetime() {
        return this.insertDatetime;
    }
    
    public void setInsertDatetime(Date insertDatetime) {
        this.insertDatetime = insertDatetime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }




}


