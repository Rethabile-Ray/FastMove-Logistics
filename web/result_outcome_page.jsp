<%-- 
    Document   : result_outcome_page
    Created on : 25 May 2026, 18:27:05
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
        <h1>Result Outcome Page</h1>
         
        <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
           String name = (String)session.getAttribute("name");
           String userToken = (String)request.getAttribute("token");
           String genToken = (String)request.getAttribute("generatedCode");
           String resultState = (String)request.getAttribute("resultState");
            %>
            <h2>Hello <%=name%>, <%=siri%> says these are the results</h2>
            <table border="1">
                <th>User String</th>
                <th>Generated String</th>
                <th>Status</th>
                <tr>
                    <td><%=userToken%></td>
                     <td><%=genToken%></td>
                      <td><%=resultState%></td>
                </tr>
            </table>
                <ol>
                    <li><a href="GenServlet.do">Test Another code</a></li>
                    <li><a href="EndTestingServlet.do">End Testing</a></li>
                     <li><a href="LogoutServlet.do">Logout</a></li>
                </ol>
    </body>
</html>
