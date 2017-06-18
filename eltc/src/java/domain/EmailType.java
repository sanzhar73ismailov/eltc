package domain;
// Generated Dec 25, 2013 9:36:04 AM by Hibernate Tools 3.2.1.GA

import eltc.web.DictionaryInterface;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * EmailType generated by hbm2java
 */
public class EmailType implements java.io.Serializable, DictionaryInterface {

    private Integer id;
    private String name;
    private Set emails = new HashSet(0);

    public EmailType() {
    }

    public EmailType(String name) {
        this.name = name;
    }

    public EmailType(String name, Set emails) {
        this.name = name;
        this.emails = emails;
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

    public Set getEmails() {
        return this.emails;
    }

    public void setEmails(Set emails) {
        this.emails = emails;
    }

    public String getUser() {
        return null;
    }

    public void setUser(String user) {
    }

    public Date getInsertDatetime() {
        return null;
    }

    public void setInsertDatetime(Date insertDatetime) {
    }
}