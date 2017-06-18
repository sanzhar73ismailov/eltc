package domain;
// Generated Jul 10, 2013 10:55:17 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country  implements java.io.Serializable, eltc.web.DictionaryInterface {


     private Integer id;
     private String name;
     private String user;
     private Date insertDatetime;
     private Set cities = new HashSet(0);

    public Country() {
    }

	
    public Country(String name, Date insertDatetime) {
        this.name = name;
        this.insertDatetime = insertDatetime;
    }
    public Country(String name, String user, Date insertDatetime, Set cities) {
       this.name = name;
       this.user = user;
       this.insertDatetime = insertDatetime;
       this.cities = cities;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public Set getCities() {
        return this.cities;
    }
    
    public void setCities(Set cities) {
        this.cities = cities;
    }




}


