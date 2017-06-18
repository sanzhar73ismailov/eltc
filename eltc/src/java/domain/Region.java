/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sanzhar.ismailov
 */
public class Region implements java.io.Serializable, eltc.web.DictionaryInterface {


     private Integer id;
     private String name;
     private String user;
     private Date insertDatetime;
     private Set organizations = new HashSet(0);

    public Region() {
    }

	
    public Region(String name, Date insertDatetime) {
        this.name = name;
        this.insertDatetime = insertDatetime;
    }
    public Region(String name, String user, Date insertDatetime, Set organizations) {
       this.name = name;
       this.user = user;
       this.insertDatetime = insertDatetime;
       this.organizations = organizations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getInsertDatetime() {
        return insertDatetime;
    }

    public void setInsertDatetime(Date insertDatetime) {
        this.insertDatetime = insertDatetime;
    }

    public Set getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set organizations) {
        this.organizations = organizations;
    }
    
    
}
