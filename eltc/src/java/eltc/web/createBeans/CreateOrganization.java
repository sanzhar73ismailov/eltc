/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.createBeans;

import domain.City;
import domain.Industry;
import domain.Organization;
import domain.Region;
import domain.TypeOwnership;
import domain.Vendor;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getRandomMaxLimit;

/**
 *
 * @author sanzhar.ismailov
 */
public class CreateOrganization extends AbstractCreateBean {

    public CreateOrganization(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object createBeanFromJSP() throws EltcException {
        Organization bean = new Organization();
        if (!request.getParameter("id").isEmpty()) {
            bean.setId(Integer.valueOf(request.getParameter("id")));
        }

        Region region = getObjectIfIdIsNumber(Region.class, request, "region");
        bean.setRegion(region);

        Industry industry = getObjectIfIdIsNumber(Industry.class, request, "industry");
        bean.setIndustry(industry);


        TypeOwnership typeOwnership = getObjectIfIdIsNumber(TypeOwnership.class, request, "typeOwnership");
        bean.setTypeOwnership(typeOwnership);


        Vendor vendor = getObjectIfIdIsNumber(Vendor.class, request, "vendor");
        bean.setVendor(vendor);


        City cityByCityOfficialId = getObjectIfIdIsNumber(City.class, request, "cityByCityOfficialId");
        bean.setCityByCityOfficialId(cityByCityOfficialId);


        City cityByCityFactId = getObjectIfIdIsNumber(City.class, request, "cityByCityFactId");
        bean.setCityByCityFactId(cityByCityFactId);

        bean.setName(getNullifEmpty(request.getParameter("name")));
        bean.setLocality(getNullifEmpty(request.getParameter("locality")));
        bean.setNameEn(getNullifEmpty(request.getParameter("nameEn")));
        bean.setStreetHouseFact(getNullifEmpty(request.getParameter("streetHouseFact")));
        bean.setPostalCodeOfficial(getNullifEmpty(request.getParameter("postalCodeOfficial")));
        bean.setStreetHouseFact(getNullifEmpty(request.getParameter("streetHouseFact")));
        bean.setPostalCodeFact(getNullifEmpty(request.getParameter("postalCodeFact")));
        bean.setFax(getNullifEmpty(request.getParameter("fax")));
        bean.setInternetSite(getNullifEmpty(request.getParameter("internetSite")));
        bean.setEmail(getNullifEmpty(request.getParameter("email")));
        bean.setRnn(getNullifEmpty(request.getParameter("rnn")));
        bean.setBin(getNullifEmpty(request.getParameter("bin")));
        bean.setKbe(getNullifEmpty(request.getParameter("kbe")));
        bean.setBankName(getNullifEmpty(request.getParameter("bankName")));
        bean.setBankAddress(getNullifEmpty(request.getParameter("bankAddress")));
        bean.setBic(getNullifEmpty(request.getParameter("bic")));
        bean.setAccountTg(getNullifEmpty(request.getParameter("accountTg")));
        bean.setAccountDollar(getNullifEmpty(request.getParameter("accountDollar")));
        bean.setAccountRuble(getNullifEmpty(request.getParameter("accountRuble")));
        bean.setAccountEuro(getNullifEmpty(request.getParameter("accountEuro")));
        bean.setUser(getCurrentUserLogin(request));
        bean.setInsertDatetime(new Date());
        return bean;
    }

    @Override
    public Object createTestBeanForJSP() throws EltcException {
        Organization bean = new Organization();
        String ext = "_" + getCount();
        bean.setId(null);

        Industry industry = new Industry();
        industry.setId(-1);
        bean.setIndustry(industry);


        TypeOwnership typeOwnership = new TypeOwnership();
        typeOwnership.setId(getRandomMaxLimit(3));
        bean.setTypeOwnership(typeOwnership);


        Vendor vendor = new Vendor();
        vendor.setId(getRandomMaxLimit(3));
        bean.setVendor(vendor);


        City cityByCityOfficialId = new City();
        cityByCityOfficialId.setId(getRandomMaxLimit(3));
        bean.setCityByCityOfficialId(cityByCityOfficialId);

        City cityByCityFactId = new City();
        cityByCityFactId.setId(getRandomMaxLimit(3));
        bean.setCityByCityFactId(cityByCityFactId);

        bean.setName(getRandomMaxLimit(1000) + "name" + ext);
        bean.setNameEn("nameEn" + ext);
        bean.setStreetHouseOfficial("streetHouseOfficial" + ext);
        bean.setPostalCodeOfficial("postalCOff" + ext);
        bean.setStreetHouseFact("streetHouseFact" + ext);
        bean.setPostalCodeFact("postCFact" + ext);
        bean.setFax("fax" + ext);
        bean.setInternetSite("internetSite" + ext);
        bean.setEmail("email" + ext + "@dd.ss");
        bean.setRnn("rnn" + ext);
        bean.setBin("bin" + ext);
        bean.setKbe("kbe" + ext);
        bean.setBankName("bankName" + ext);
        bean.setBankAddress("bankAddress" + ext);
        bean.setBic("bic" + ext);
        bean.setAccountTg("accountTg" + ext);
        bean.setAccountDollar("accountDollar" + ext);
        bean.setAccountRuble("accountRuble" + ext);
        bean.setAccountEuro("accountEuro" + ext);
        bean.setUser("test_user");
        bean.setInsertDatetime(new Date());
        return bean;
    }
}