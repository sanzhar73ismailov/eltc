/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanzhar.ismailov
 */
public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printRequest(request, response);
//        request.setAttribute("myBoolean", "ds");
//        request.getRequestDispatcher("/test.jsp").forward(request, response);
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static void printRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf8");
        //response.setCharacterEncoding("utf8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
        
            printParameters(request, out);
            printHeaders(request, out);
            printLocale(request, out);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public static void printParameters(HttpServletRequest request, PrintWriter out) {
        Enumeration<String> parameterNames = request.getParameterNames();
        out.println("<h2>All Parametres:</h2>");
        while (parameterNames.hasMoreElements()) {
            String parName = parameterNames.nextElement();
            String value = request.getParameter(parName);
            out.println("<b>" + parName + "</b>: " + value + "<br/>");
        }
    }

    public static void printHeaders(HttpServletRequest request, PrintWriter out) {
        Enumeration<String> headerNames = request.getHeaderNames();
        out.println("<p><h2>All Headers:</h2>");
        while (headerNames.hasMoreElements()) {
            String parName = headerNames.nextElement();
            String value = request.getParameter(parName);
            out.println("<b>" + parName + "</b>: " + value + "<br/>");
        }
    }
     public static void printLocale(HttpServletRequest request, PrintWriter out) {
         Locale locale = Locale.getDefault();
         out.println("<p>Locale info:<p>");
         out.println("locale.getCountry()" + locale.getCountry() + "<br/>");
         out.println("locale.getLanguage():" + locale.getLanguage()  + "<br/>");
     }
}
