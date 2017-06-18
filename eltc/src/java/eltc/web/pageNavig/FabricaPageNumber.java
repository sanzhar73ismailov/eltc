/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

import domain.Email;
import domain.Organization;
import domain.Student;
import eltc.model.EltcException;
import eltc.model.Model;
import eltc.model.ModelImpl;
import eltc.web.DictionaryInterface;
import eltc.web.ServletUtilMethods;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sanzhar.ismailov
 */
public class FabricaPageNumber {

    private final int numberRecordsPerPage = 30;
    private int startRecord = 1;
    private int sizeRecords;
    Model model = ModelImpl.getInstance();
    private int page;
    private PageNumberPanel pageNumberPanel;
    private List beans;
    HttpServletRequest request;
    EntityEnum entity;
    private static String PAGE_PARAMETER = "page";
    //static java.util.Map testStaticMap = new java.util.HashMap();
    FindAble findWorker;

    

    public FabricaPageNumber(HttpServletRequest requestParam, EntityEnum entity) throws EltcException {
        this.request = requestParam;
        this.entity = entity;
        findWorker = new FindWorker(request, entity.getEntityObject());

        page = getPageNumberFromRequest();
        startRecord = numberRecordsPerPage * (page - 1) + 1;
        createBeans();
        pageNumberPanel = new PageNumberPanel(page, numberRecordsPerPage, sizeRecords);
        pageNumberPanel.setFindUrlString(findWorker.getForFindUrlString());
        request.setAttribute("entity", entity.getSingleForm());
        request.setAttribute("pageNumberPanel", pageNumberPanel);
        // request.setAttribute("page", pageNumberPanel.getCurrentNumber());
        request.setAttribute("beans", beans);
        request.setAttribute("findSize", sizeRecords);
        request.setAttribute("dictionary", entity.getEntityObject() instanceof DictionaryInterface);

    }

    private int getPageNumberFromRequest() throws EltcException {
        int pageNumber = 1;
        String pagePar = request.getParameter(PAGE_PARAMETER);
        if (request.getParameter(PAGE_PARAMETER) != null && !request.getParameter(PAGE_PARAMETER).isEmpty()) {
            try {
                pageNumber = Integer.parseInt(pagePar);
            } catch (NumberFormatException e) {
                throw new EltcException(e.getMessage());
            }
        }
        return pageNumber;
    }

    private void createBeans() throws EltcException {

        if (findWorker.isFindNecessary()) {
            Object findObject = findWorker.getFindObject();
            if (findObject instanceof Student) {
                Student findStudent = (Student) findObject;
                String findEmail = null;
                Set emailSet = findStudent.getEmails();
                beans = model.findObjects(startRecord, numberRecordsPerPage, findStudent);
                sizeRecords = model.getSizeFindObjects(findStudent);
                request.setAttribute("findBean", findStudent);
                request.setAttribute("findEmail", findEmail);
            } else if (findObject instanceof Organization) {
                Organization findOrganization = (Organization) findObject;
                beans = model.findObjects(startRecord, numberRecordsPerPage, findOrganization);
                sizeRecords = model.getSizeFindObjects(findOrganization);
                request.setAttribute("findBean", findOrganization);

            } else {
                throw new EltcException("Неизвестный поисковый объект: " + findObject.getClass());
            }
        } else {
            beans = model.getObjectsSafelyDeletedFromTo(startRecord, numberRecordsPerPage, entity.getEntityObject());
            sizeRecords = model.getObjectsSizeSafelyDeleted(entity.getEntityObject());
        }
    }

    public static void main(String[] args) throws EltcException {
        // FabricaPageNumber fpn = new FabricaPageNumber(null, EntityEnum.VENDOR);
        //System.out.println(FabricaPageNumber.getForFindUrlString());
    }

    private String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FabricaPageNumber.class.getName()).log(Level.SEVERE, null, ex);
            return "Nothing decode, because Exception (Ошибка при декодировании)";
        }

    }

    public int getNumberRecordsPerPage() {
        return numberRecordsPerPage;
    }

    public int getPage() {
        return page;
    }

    public PageNumberPanel getPageNumberPanel() {
        return pageNumberPanel;
    }

    public int getStartRecord() {
        return startRecord;
    }

    public List getBeans() {
        return beans;
    }
}
