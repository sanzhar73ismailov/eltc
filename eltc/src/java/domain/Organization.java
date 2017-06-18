package domain;
// Generated Jul 10, 2013 10:55:17 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Organization generated by hbm2java
 */
public class Organization implements java.io.Serializable, eltc.web.DeletableInterface {

    

     private Integer id;
     private Industry industry;
     private TypeOwnership typeOwnership;
     private Vendor vendor;
     private Region region;
     private City cityByCityOfficialId;
     private City cityByCityFactId;
     private String name;
     private String nameEn;
     private String locality;
     private String streetHouseOfficial;
     private String postalCodeOfficial;
     private String streetHouseFact;
     private String postalCodeFact;
     private String phone;
     private String fax;
     private String internetSite;
     private String email;
     private String rnn;
     private String bin;
     private String kbe;
     private String bankName;
     private String bankAddress;
     private String bic;
     private String accountTg;
     private String accountDollar;
     private String accountRuble;
     private String accountEuro;
     private boolean deleted;
     private String user;
     private Date insertDatetime;
     private Set<Contract> contracts = new HashSet<Contract>(0);
     private Set<OrganizationHrManager> organizationHrManagers = new HashSet<OrganizationHrManager>(0);
     private Set<StudentOrganization> studentOrganizations = new HashSet<StudentOrganization>(0);

    public Organization() {
    }

	
    public Organization(Industry industry, TypeOwnership typeOwnership, String name, String nameEn, boolean deleted, Date insertDatetime) {
        this.industry = industry;
        this.typeOwnership = typeOwnership;
        this.name = name;
        this.nameEn = nameEn;
        this.deleted = deleted;
        this.insertDatetime = insertDatetime;
    }
    public Organization(Industry industry, TypeOwnership typeOwnership, Vendor vendor, Region region, City cityByCityOfficialId, City cityByCityFactId, String name, String nameEn, String locality, String streetHouseOfficial, String postalCodeOfficial, String streetHouseFact, String postalCodeFact, String phone, String fax, String internetSite, String email, String rnn, String bin, String kbe, String bankName, String bankAddress, String bic, String accountTg, String accountDollar, String accountRuble, String accountEuro, boolean deleted, String user, Date insertDatetime, Set<Contract> contracts, Set<OrganizationHrManager> organizationHrManagers, Set<StudentOrganization> studentOrganizations) {
       this.industry = industry;
       this.typeOwnership = typeOwnership;
       this.vendor = vendor;
       this.region = region;
       this.cityByCityOfficialId = cityByCityOfficialId;
       this.cityByCityFactId = cityByCityFactId;
       this.name = name;
       this.nameEn = nameEn;
       this.locality = locality;
       this.streetHouseOfficial = streetHouseOfficial;
       this.postalCodeOfficial = postalCodeOfficial;
       this.streetHouseFact = streetHouseFact;
       this.postalCodeFact = postalCodeFact;
       this.phone = phone;
       this.fax = fax;
       this.internetSite = internetSite;
       this.email = email;
       this.rnn = rnn;
       this.bin = bin;
       this.kbe = kbe;
       this.bankName = bankName;
       this.bankAddress = bankAddress;
       this.bic = bic;
       this.accountTg = accountTg;
       this.accountDollar = accountDollar;
       this.accountRuble = accountRuble;
       this.accountEuro = accountEuro;
       this.deleted = deleted;
       this.user = user;
       this.insertDatetime = insertDatetime;
       this.contracts = contracts;
       this.organizationHrManagers = organizationHrManagers;
       this.studentOrganizations = studentOrganizations;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Industry getIndustry() {
        return this.industry;
    }
    
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
    public TypeOwnership getTypeOwnership() {
        return this.typeOwnership;
    }
    
    public void setTypeOwnership(TypeOwnership typeOwnership) {
        this.typeOwnership = typeOwnership;
    }
    public Vendor getVendor() {
        return this.vendor;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    public Region getRegion() {
        return this.region;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }
    public City getCityByCityOfficialId() {
        return this.cityByCityOfficialId;
    }
    
    public void setCityByCityOfficialId(City cityByCityOfficialId) {
        this.cityByCityOfficialId = cityByCityOfficialId;
    }
    public City getCityByCityFactId() {
        return this.cityByCityFactId;
    }
    
    public void setCityByCityFactId(City cityByCityFactId) {
        this.cityByCityFactId = cityByCityFactId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getNameEn() {
        return this.nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getLocality() {
        return this.locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getStreetHouseOfficial() {
        return this.streetHouseOfficial;
    }
    
    public void setStreetHouseOfficial(String streetHouseOfficial) {
        this.streetHouseOfficial = streetHouseOfficial;
    }
    public String getPostalCodeOfficial() {
        return this.postalCodeOfficial;
    }
    
    public void setPostalCodeOfficial(String postalCodeOfficial) {
        this.postalCodeOfficial = postalCodeOfficial;
    }
    public String getStreetHouseFact() {
        return this.streetHouseFact;
    }
    
    public void setStreetHouseFact(String streetHouseFact) {
        this.streetHouseFact = streetHouseFact;
    }
    public String getPostalCodeFact() {
        return this.postalCodeFact;
    }
    
    public void setPostalCodeFact(String postalCodeFact) {
        this.postalCodeFact = postalCodeFact;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getInternetSite() {
        return this.internetSite;
    }
    
    public void setInternetSite(String internetSite) {
        this.internetSite = internetSite;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRnn() {
        return this.rnn;
    }
    
    public void setRnn(String rnn) {
        this.rnn = rnn;
    }
    public String getBin() {
        return this.bin;
    }
    
    public void setBin(String bin) {
        this.bin = bin;
    }
    public String getKbe() {
        return this.kbe;
    }
    
    public void setKbe(String kbe) {
        this.kbe = kbe;
    }
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAddress() {
        return this.bankAddress;
    }
    
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    public String getBic() {
        return this.bic;
    }
    
    public void setBic(String bic) {
        this.bic = bic;
    }
    public String getAccountTg() {
        return this.accountTg;
    }
    
    public void setAccountTg(String accountTg) {
        this.accountTg = accountTg;
    }
    public String getAccountDollar() {
        return this.accountDollar;
    }
    
    public void setAccountDollar(String accountDollar) {
        this.accountDollar = accountDollar;
    }
    public String getAccountRuble() {
        return this.accountRuble;
    }
    
    public void setAccountRuble(String accountRuble) {
        this.accountRuble = accountRuble;
    }
    public String getAccountEuro() {
        return this.accountEuro;
    }
    
    public void setAccountEuro(String accountEuro) {
        this.accountEuro = accountEuro;
    }
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
    public Set<Contract> getContracts() {
        return this.contracts;
    }
    
    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
    public Set<OrganizationHrManager> getOrganizationHrManagers() {
        return this.organizationHrManagers;
    }
    
    public void setOrganizationHrManagers(Set<OrganizationHrManager> organizationHrManagers) {
        this.organizationHrManagers = organizationHrManagers;
    }
    public Set<StudentOrganization> getStudentOrganizations() {
        return this.studentOrganizations;
    }
    
    public void setStudentOrganizations(Set<StudentOrganization> studentOrganizations) {
        this.studentOrganizations = studentOrganizations;
    }

}
