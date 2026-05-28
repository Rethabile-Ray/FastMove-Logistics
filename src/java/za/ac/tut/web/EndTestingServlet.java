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
import java.util.Date;
import za.ac.tut.bl.MetricEntityFacadeLocal;
import za.ac.tut.entity.MetricEntity;

/**
 *
 * @author mokau
 */
public class EndTestingServlet extends HttpServlet {

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
        //processRequest(request, response);
         HttpSession session = request.getSession();
         String name = (String)session.getAttribute("name");
         Long id = (Long)session.getAttribute("id");
         Integer numTotalBatches= (Integer)session.getAttribute("numTotalBatches");
          Integer numPrestine = (Integer)session.getAttribute("numPrestine");
          Integer numTolerable = (Integer)session.getAttribute("numTolerable");
          Integer numCriticalDiscrepency = (Integer)session.getAttribute("numCriticalDiscrepency");
          String listBatches= (String)session.getAttribute("listBatches"); 
         Integer batchEfficiency =  ejb.calcEffeciency(numPrestine, numTolerable, numTotalBatches);
         request.setAttribute("batchEfficiency", batchEfficiency);
         MetricEntity metricObject = createMetric(id, name, numTotalBatches, numPrestine, numTolerable, numCriticalDiscrepency, listBatches, batchEfficiency);
         ejb.create(metricObject);
         RequestDispatcher diss = request.getRequestDispatcher("tot_result.jsp");
         diss.forward(request, response);
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
      //  processRequest(request, response);
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

    private MetricEntity createMetric(Long id, String name, Integer numTotalBatches, Integer numPrestine, Integer numTolerable, Integer numCriticalDiscrepency, String listBatches, Integer batchEfficiency) {
        Date creationDate = new Date();
        MetricEntity metricEn = new MetricEntity();
        
        metricEn.setEmpName(name);
        metricEn.setStaffID(id);
        metricEn.setTotalBatches(numTotalBatches);
        metricEn.setNumPristine(numPrestine);
        metricEn.setNumTolerable(numTolerable);
        
        metricEn.setNumCriticalDiscrepancy(numCriticalDiscrepency);
        metricEn.setListTokens(listBatches);
        metricEn.setEfficiencyIndex(batchEfficiency);
        metricEn.setCreationDate(creationDate);
        return metricEn;
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
