/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author mokau
 */
public class StartSessionServlet extends HttpServlet {

  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       String name = request.getParameter("name");
       String sID = request.getParameter("staffID");
       Long id = Long.parseLong(sID);
       HttpSession session = request.getSession(true);
       initializeSession(session, name, id);
       RequestDispatcher diss = request.getRequestDispatcher("auditor_menu.jsp");
       diss.forward(request, response);
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

    private void initializeSession(HttpSession session, String name, Long id) {
        Integer numTotalBatches=0, numPrestine=0, numTolerable=0, numCriticalDiscrepency=0;
        String listBatches="";
        String genToken ="";
       session.setAttribute("name", name);
        session.setAttribute("id", id);
         session.setAttribute("numTotalBatches", numTotalBatches);
          session.setAttribute("numPrestine", numPrestine);
           session.setAttribute("numTolerable", numTolerable);
            session.setAttribute("numCriticalDiscrepency", numCriticalDiscrepency);
           session.setAttribute("listBatches", listBatches);
             session.setAttribute("genToken", genToken);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
