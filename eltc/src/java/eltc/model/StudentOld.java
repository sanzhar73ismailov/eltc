package eltc.model;

import java.util.Date;
import eltc.web.ServletUtilMethods;

/**
 *
 * @author user
 */
public class StudentOld {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private static int count;

    public StudentOld(String firstName, String lastName, String email, Date dateOfBirth) {
        this.id = ++count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    
    
    

    public StudentOld() {
        this(null, null, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", dateOfBirth=" + dateOfBirth + '}';
    }

    public String toWebString() {
       String forDateOfBirth = dateOfBirth == null ? "нет данных" : String.format("%1$td.%1$tm.%1$tY", dateOfBirth);
        
        return String.format("<table>"
                + "<tr><td>Фамилия </td><td>%s</td></tr>"
                + "<tr><td>Имя </td><td>%s</td></tr>"
                + "<tr><td>email  </td><td>%s</td></tr>"
                + "<tr><td>Дата рождения </td><td> %s</td></tr>"
                + "</table>", lastName, firstName, email, forDateOfBirth);
    }
}
