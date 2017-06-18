package eltc.web.pageNavig;

import domain.City;
import domain.Industry;
import domain.Organization;
import domain.TypeOwnership;
import domain.Vendor;
import eltc.model.EltcException;
import static eltc.web.createBeans.AbstractCreateBean.getRandomMaxLimit;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageAjaxTimeTableFilter extends AbstractPageNavigator {

    private List beans;

    public PageAjaxTimeTableFilter(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        //String action = request.getParameter("action");
        pageTo = "";
        toBeForwarded = false;
        boolean namesAdded = false;

        String targetId = request.getParameter("findOrganization");
//        if(targetId == null || targetId.trim().isEmpty()){
//            return;
//        }
//        try {
//            targetId = URLDecoder.decode(targetId, "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            throw new EltcException(ex.getMessage());
//        }
        StringBuffer sb = new StringBuffer();

        if (targetId != null && !targetId.trim().isEmpty()) {
            targetId = targetId.trim().toLowerCase();
            beans = model.getObjectsSafelyDeleted(new Organization());
            //beans = getTestOrganizations();
            int howManySearches = 0;
            for (Object object : beans) {
                Organization organization = (Organization) object;
                if ((organization.getName() != null && organization.getName().toLowerCase().contains(targetId))
                        || (organization.getNameEn() != null && organization.getNameEn().toLowerCase().contains(targetId))
                        || (organization.getRnn() != null && organization.getRnn().toLowerCase().contains(targetId))) {
                    howManySearches++;
                    // System.out.println("organization contains " + targetId + ": " + organization.getName());
                    int id = organization.getId();
                    String name = organization.getName();
                    String rnn = organization.getRnn();
                    sb.append("<organization>");
                    sb.append("<id>").append(id).append("</id>");
                    sb.append("<name>").append(escapeXMLIfNullGetEmptyString(name)).append("</name>");
                    sb.append("<rnn>").append(escapeXMLIfNullGetEmptyString(rnn)).append("</rnn>");
                    sb.append("</organization>");
                    namesAdded = true;
                }
            }
            //System.out.println("howManySearches = " + howManySearches);
        }

        try {
            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<organizations>" + sb.toString() + "</organizations>");

            } else {
                //nothing to show
                //response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                response.getWriter().write("<organizations></organizations>");
            }
        } catch (IOException ex) {
            throw new EltcException(ex.getMessage());
        }

    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }

    static List<Organization> getTestOrganizations() {
        List<Organization> list = new ArrayList<Organization>();

        for (int i = 0; i < 1000; i++) {
            try {
                Organization org = createTestBeanForJSP(i);
                list.add(org);
            } catch (EltcException ex) {
                Logger.getLogger(PageAjaxWork.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        List<Organization> orgs = getTestOrganizations();
//        for (Organization organization : orgs) {
//            System.out.println("organization = " + organization.getName());
//        }
        System.out.println(org.apache.commons.lang3.StringEscapeUtils.escapeHtml4("bread\" & \"butter"));

    }

    public static Organization createTestBeanForJSP(int i) throws EltcException {
        Organization bean = new Organization();
        String ext = "_" + i;
        bean.setId(i);

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

        bean.setName(i + "" + (i + 1) + "name" + ext);
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

    private String escapeXMLIfNullGetEmptyString(String str) {
        return org.apache.commons.lang3.StringEscapeUtils.escapeXml(str == null ? "-" : str);
    }
}
