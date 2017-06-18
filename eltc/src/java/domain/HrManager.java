package domain;
// Generated Jul 10, 2013 10:55:17 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * HrManager generated by hbm2java
 */
public class HrManager  implements java.io.Serializable, eltc.web.DeletableInterface, eltc.web.PersonInterface {


     private Integer id;
     private Sex sex;
     private String lastNameRu;
     private String firstNameRu;
     private String patronicNameRu;
     private String lastNameEn;
     private String firstNameEn;
     private String patronicNameEn;
     private String emailOffice;
     private String emailHome;
     private String emailAdd;
     private String phoneHome;
     private String phoneMobile1;
     private String phoneMobile2;
     private String phoneOffice;
     private String skype;
     private String icq;
     private String mailruAgent;
     private String cvDocFile;
     private String photoFile;
     private boolean deleted;
     private String user;
     private Date insertDatetime;
     private Set organizationHrManagers = new HashSet(0);

    public HrManager() {
    }

	
    public HrManager(Sex sex, String lastNameRu, String firstNameRu, String patronicNameRu, String lastNameEn, String firstNameEn, String emailOffice, String emailHome, String phoneMobile1, Date insertDatetime) {
        this.sex = sex;
        this.lastNameRu = lastNameRu;
        this.firstNameRu = firstNameRu;
        this.patronicNameRu = patronicNameRu;
        this.lastNameEn = lastNameEn;
        this.firstNameEn = firstNameEn;
        this.emailOffice = emailOffice;
        this.emailHome = emailHome;
        this.phoneMobile1 = phoneMobile1;
        this.insertDatetime = insertDatetime;
    }
    public HrManager(Sex sex, String lastNameRu, String firstNameRu, String patronicNameRu, String lastNameEn, String firstNameEn, String patronicNameEn, String emailOffice, String emailHome, String emailAdd, String phoneHome, String phoneMobile1, String phoneMobile2, String phoneOffice, String skype, String icq, String mailruAgent, String cvDocFile, String photoFile, String user, Date insertDatetime, Set organizationHrManagers) {
       this.sex = sex;
       this.lastNameRu = lastNameRu;
       this.firstNameRu = firstNameRu;
       this.patronicNameRu = patronicNameRu;
       this.lastNameEn = lastNameEn;
       this.firstNameEn = firstNameEn;
       this.patronicNameEn = patronicNameEn;
       this.emailOffice = emailOffice;
       this.emailHome = emailHome;
       this.emailAdd = emailAdd;
       this.phoneHome = phoneHome;
       this.phoneMobile1 = phoneMobile1;
       this.phoneMobile2 = phoneMobile2;
       this.phoneOffice = phoneOffice;
       this.skype = skype;
       this.icq = icq;
       this.mailruAgent = mailruAgent;
       this.cvDocFile = cvDocFile;
       this.photoFile = photoFile;
       this.user = user;
       this.insertDatetime = insertDatetime;
       this.organizationHrManagers = organizationHrManagers;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Sex getSex() {
        return this.sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public String getLastNameRu() {
        return this.lastNameRu;
    }
    
    public void setLastNameRu(String lastNameRu) {
        this.lastNameRu = lastNameRu;
    }
    public String getFirstNameRu() {
        return this.firstNameRu;
    }
    
    public void setFirstNameRu(String firstNameRu) {
        this.firstNameRu = firstNameRu;
    }
    public String getPatronicNameRu() {
        return this.patronicNameRu;
    }
    
    public void setPatronicNameRu(String patronicNameRu) {
        this.patronicNameRu = patronicNameRu;
    }
    public String getLastNameEn() {
        return this.lastNameEn;
    }
    
    public void setLastNameEn(String lastNameEn) {
        this.lastNameEn = lastNameEn;
    }
    public String getFirstNameEn() {
        return this.firstNameEn;
    }
    
    public void setFirstNameEn(String firstNameEn) {
        this.firstNameEn = firstNameEn;
    }
    public String getPatronicNameEn() {
        return this.patronicNameEn;
    }
    
    public void setPatronicNameEn(String patronicNameEn) {
        this.patronicNameEn = patronicNameEn;
    }
    public String getEmailOffice() {
        return this.emailOffice;
    }
    
    public void setEmailOffice(String emailOffice) {
        this.emailOffice = emailOffice;
    }
    public String getEmailHome() {
        return this.emailHome;
    }
    
    public void setEmailHome(String emailHome) {
        this.emailHome = emailHome;
    }
    public String getEmailAdd() {
        return this.emailAdd;
    }
    
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }
    public String getPhoneHome() {
        return this.phoneHome;
    }
    
    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }
    public String getPhoneMobile1() {
        return this.phoneMobile1;
    }
    
    public void setPhoneMobile1(String phoneMobile1) {
        this.phoneMobile1 = phoneMobile1;
    }
    public String getPhoneMobile2() {
        return this.phoneMobile2;
    }
    
    public void setPhoneMobile2(String phoneMobile2) {
        this.phoneMobile2 = phoneMobile2;
    }
    public String getPhoneOffice() {
        return this.phoneOffice;
    }
    
    public void setPhoneOffice(String phoneOffice) {
        this.phoneOffice = phoneOffice;
    }
    public String getSkype() {
        return this.skype;
    }
    
    public void setSkype(String skype) {
        this.skype = skype;
    }
    public String getIcq() {
        return this.icq;
    }
    
    public void setIcq(String icq) {
        this.icq = icq;
    }
    public String getMailruAgent() {
        return this.mailruAgent;
    }
    
    public void setMailruAgent(String mailruAgent) {
        this.mailruAgent = mailruAgent;
    }
    public String getCvDocFile() {
        return this.cvDocFile;
    }
    
    public void setCvDocFile(String cvDocFile) {
        this.cvDocFile = cvDocFile;
    }
    public String getPhotoFile() {
        return this.photoFile;
    }
    
    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
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
    public Set getOrganizationHrManagers() {
        return this.organizationHrManagers;
    }
    
    public void setOrganizationHrManagers(Set organizationHrManagers) {
        this.organizationHrManagers = organizationHrManagers;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateOfBirth() {
        return null;
    }

    public void setDateOfBirth(Date dateOfBirth) {
    }




}

