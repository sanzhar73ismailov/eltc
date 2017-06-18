package eltc.web.pageNavig;

import domain.Email;
import domainComparators.EmailComparator;
import eltc.model.EltcException;
import eltc.web.ServletUtilMethods;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class PageEmailListCreate extends AbstractPageNavigator {

    enum EmailFilter {

        NO_FILTER, ACTUAL_AND_SUSCRIBE, UNKNOWN_FILTER
    };
    EmailFilter emailFilter;

    public PageEmailListCreate(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);

    }

    @Override
    void doSomething() throws EltcException {
        toBeForwarded = false;
        pageTo = "";
        String fileName = null;

        if (request.getParameter("filter") == null) {
            emailFilter = EmailFilter.NO_FILTER;
        } else if (request.getParameter("filter").trim().equalsIgnoreCase("actualAndSubscribe")) {
            emailFilter = EmailFilter.ACTUAL_AND_SUSCRIBE;
        } else {
            emailFilter = EmailFilter.UNKNOWN_FILTER;
        }
        fileName = makeFileName();
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "filename=" + fileName);
        try {
            printTableAsExcelFile();
        } catch (IOException ex) {
            Logger.getLogger(PageEmailListCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm_ss");
        String fileName = sdf.format(date) + ".xls";
        System.out.println("fileName = " + fileName);

    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }

    String makeFileName() {
        String fileName;
        switch (emailFilter) {
            case NO_FILTER:
                fileName = "emailsAll";
                break;
            case ACTUAL_AND_SUSCRIBE:
                fileName = "emailsActualAndSubscribe";
                break;
            case UNKNOWN_FILTER:
            default:
                fileName = "emailsError";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm_ss");
        fileName += sdf.format(date) + ".xls";
        return fileName;
    }

    @Deprecated
    private void printTableAsHtml() throws EltcException, IOException {
        List<Email> emailsAll = model.getObjectsSafelyDeleted(new Email());
        List<Email> emailsNeed = new ArrayList<Email>();
        PrintWriter out = response.getWriter();
        switch (emailFilter) {
            case NO_FILTER:
                emailsNeed = emailsAll;
                break;
            case ACTUAL_AND_SUSCRIBE:
                for (Email email : emailsAll) {
                    if (email.isIsActual() && email.isSubscribe()) {
                        emailsNeed.add(email);
                    }
                }
                break;
            case UNKNOWN_FILTER:
            default:

        }
        Collections.sort(emailsNeed, new EmailComparator());
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Email List</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border=1>");
        //  out.println("<tr>");
        // out.println("<td>email</td>");
        //  out.println("<td>isActual</td>");
        //  out.println("<td>isSubscribe</td>");
        //  out.println("</tr>");
        for (Email email : emailsNeed) {
            out.println("<tr>");
            out.println(String.format("<td>%s</td>", email.getEmail()));
            //  out.println(String.format("<td>%s</td>", email.isIsActual()));
            //  out.println(String.format("<td>%s</td>", email.isSubscribe()));
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    private void printTableAsExcelFile() throws EltcException, IOException {
        List<Email> emailsAll = model.getObjectsSafelyDeleted(new Email());
        List<Email> emailsNeed = new ArrayList<Email>();

        switch (emailFilter) {
            case NO_FILTER:
                emailsNeed = emailsAll;
                break;
            case ACTUAL_AND_SUSCRIBE:
                for (Email email : emailsAll) {
                    if (email.isIsActual() && email.isSubscribe()) {
                        emailsNeed.add(email);
                    }
                }
                break;
            case UNKNOWN_FILTER:
            default:

        }

        Collections.sort(emailsNeed, new EmailComparator());

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("email");
        for (int i = 0; i < emailsNeed.size(); i++) {
            Email email = emailsNeed.get(i);
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(email.getEmail());
        }

        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
    }
}
