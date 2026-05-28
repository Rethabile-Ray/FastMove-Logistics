<%-- 
    Document   : view_all
    Created on : 25 May 2026, 19:10:38
    Author     : mokau
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.MetricEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>View All Page</h1>
          <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
          
            %>
            <h2><%=siri%> says these are the overall results</h2>
            <table border="1">
                <th>User Name</th>
                <th>User ID</th>
                <th>Total Batches</th>
                <th>Total PRISTINE Batches</th>
                <th>Total TOLERABLE Batches</th>
                <th>Total CRITICAL_DISCREPANCY Batches</th>
                <th>Efficiency Index</th>
                 <th>List of generated Batches</th>
                 <th>Timestamp</th>
                 <%
                     List<MetricEntity> metricsAll = (List<MetricEntity>)request.getAttribute("metricsAll");
                     for(int x=0; x<metricsAll.size(); x++)
                     {
                         MetricEntity metricEn = metricsAll.get(x);
                          String name = metricEn.getEmpName();
                          Long id = metricEn.getStaffID();
                          Integer numTotalBatches= metricEn.getTotalBatches();
                          Integer numPrestine = metricEn.getNumPristine();
                          Integer numTolerable = metricEn.getNumTolerable();
                          Integer numCriticalDiscrepency = metricEn.getNumCriticalDiscrepancy();
                          String listBatches= metricEn.getListTokens();
                          Integer batchEfficiency =  metricEn.getEfficiencyIndex();
                          Date creationDate = metricEn.getCreationDate();
                     %>
                  <tr>
                    <td><%=name%></td>
                     <td><%=id%></td>
                      <td><%=numTotalBatches%></td>
                       <td><%=numPrestine%></td>
                        <td><%=numTolerable%></td>
                         <td><%=numCriticalDiscrepency%></td>
                          <td><%=batchEfficiency%></td>
                           <td><%=listBatches%></td>
                            <td><%=creationDate%></td>
                </tr>
                 <%
                 }
                     %>
               
            </table>
                <ol>
                    <li><a href="manager_menu.jsp">Manager Menu</a></li>
                    <li><a href="main_menu.html">Main Menu</a></li>
                     <li><a href="LogoutServlet.do">Logout</a></li>
                </ol>
    </body>
</html>
