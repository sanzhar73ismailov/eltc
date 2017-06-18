package domain;

import java.util.Date;

public class UserVisit {

    private Integer id;
    private User user;
    private Date date;

    public UserVisit() {
    }

    public UserVisit(Integer id, User user, Date date) {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
