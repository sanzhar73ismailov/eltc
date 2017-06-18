/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eltc.model.Database;
import eltc.model.EltcException;
import eltc.model.StudentOld;
import eltc.logger.ErroLogging;
import eltc.web.pageNavig.AbstractPageNavigator;
import eltc.web.pageNavig.FabricaForPageNavigator;

/**
 *
 * @author user
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, EltcException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String userPath = request.getServletPath();
            // pageNavigator = FabricaForPageNavigator.createPageNavigator(userPath, request);
            AbstractPageNavigator navigator = FabricaForPageNavigator.createPageNavigator(userPath, request, response);
            RequestDispatcher rd = request.getRequestDispatcher(navigator.getPageTo());
            navigator.forward(rd, request, response);
        } catch (Exception e) {
            throw new EltcException("в контроллере", e);
            
        } finally {
        }
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
        try {
            processRequest(request, response);
        } catch (EltcException ex) {
            ErroLogging.prinStackMessage(ex);
        }
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
        try {
            processRequest(request, response);
        } catch (EltcException ex) {
            ErroLogging.prinStackMessage(ex);
        }
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
}
