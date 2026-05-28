<%-- 
    Document   : tot_result
    Created on : 25 May 2026, 18:53:27
    Author     : mokau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ending Outcome Page</h1>
          <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
           String name = (String)session.getAttribute("name");
            Long id = (Long)session.getAttribute("id");
         Integer numTotalBatches= (Integer)session.getAttribute("numTotalBatches");
          Integer numPrestine = (Integer)session.getAttribute("numPrestine");
          Integer numTolerable = (Integer)session.getAttribute("numTolerable");
          Integer numCriticalDiscrepency = (Integer)session.getAttribute("numCriticalDiscrepency");
          String listBatches= (String)session.getAttribute("listBatches"); 
          Integer batchEfficiency =  (Integer)request.getAttribute("batchEfficiency");
            %>
            <h2>Hello <%=name%>, <%=siri%> says these are the overall results</h2>
            <table border="1">
                <th>User Name</th>
                <th>User ID</th>
                <th>Total Batches</th>
                  <th>Total PRISTINE Batches</th>
                <th>Total TOLERABLE Batches</th>
                 <th>Total CRITICAL_DISCREPANCY Batches</th>
                 <th>Efficiency Index</th>
                  <th>List of generated Batches</th>
                
                <tr>
                    <td><%=name%></td>
                     <td><%=id%></td>
                      <td><%=numTotalBatches%></td>
                       <td><%=numPrestine%></td>
                        <td><%=numTolerable%></td>
                         <td><%=numCriticalDiscrepency%></td>
                          <td><%=batchEfficiency%></td>
                           <td><%=listBatches%></td>
                </tr>
            </table>
                <ol>
                    <li><a href="main_menu.html">Main Menu</a></li>
                     <li><a href="LogoutServlet.do">Logout</a></li>
                </ol>
    </body>
</html>
