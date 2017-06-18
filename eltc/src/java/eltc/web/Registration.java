/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

/**
 *
 * @author sanzhar.ismailov
 */
public class Registration {

    private String name;
    private String login;
    private String email1;
    private String email2;
    private String password1;
    private String password2;
    private String passwordGeneral;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPasswordGeneral() {
        return passwordGeneral;
    }

    public void setPasswordGeneral(String passwordGeneral) {
        this.passwordGeneral = passwordGeneral;
    }

    @Override
    public String toString() {
        return "Registration{" + "name=" + name + ", login=" + login + ", email1=" + email1 + ", email2=" + email2 + ", password1=" + password1 + ", password2=" + password2 + ", passwordGeneral=" + passwordGeneral + '}';
    }
    
    

    
    
    
    
}
