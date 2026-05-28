/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import za.ac.tut.bl.MetricEntityFacadeLocal;

/**
 *
 * @author mokau
 */
public class TokenManagerServlet extends HttpServlet {
@EJB MetricEntityFacadeLocal ejb;
   

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
       // processRequest(request, response);
      
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
         String token = request.getParameter("userCode");
       String generatedCode = (String)session.getAttribute("genToken");
       String resultState = ejb.evaluateInputAndBatch(token, generatedCode);
       
       updateSession(session, generatedCode, resultState);
       request.setAttribute("token", token);
       request.setAttribute("generatedCode", generatedCode);
       request.setAttribute("resultState", resultState);
       RequestDispatcher diss = request.getRequestDispatcher("result_outcome_page.jsp");
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

    private void updateSession( HttpSession session, String generatedCode, String resultState) {
        Integer numTotalBatches= (Integer)session.getAttribute("numTotalBatches");
        numTotalBatches++;
         session.setAttribute("numTotalBatches", numTotalBatches);
        if(resultState.equalsIgnoreCase("PRISTINE"))
        {
           Integer numPrestine = (Integer)session.getAttribute("numPrestine");
            numPrestine++;
            session.setAttribute("numPrestine", numPrestine);
        }
        else if(resultState.equalsIgnoreCase("TOLERABLE"))
        {
            Integer numTolerable = (Integer)session.getAttribute("numTolerable");
            numTolerable++;
             session.setAttribute("numTolerable", numTolerable);
        }
         else if(resultState.equalsIgnoreCase("CRITICAL_DISCREPANCY"))
        {
            Integer numCriticalDiscrepency = (Integer)session.getAttribute("numCriticalDiscrepency");
            numCriticalDiscrepency++;
             session.setAttribute("numCriticalDiscrepency", numCriticalDiscrepency);
        }
        String listBatches= (String)session.getAttribute("listBatches");
        listBatches += "" + generatedCode + "<br>";
        session.setAttribute("listBatches", listBatches);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
