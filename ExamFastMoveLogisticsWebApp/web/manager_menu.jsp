<%-- 
    Document   : manager_menu
    Created on : 25 May 2026, 19:06:39
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
        <h1>Manager Menu</h1>
        <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
          
            %>
            <h2><%=siri%> says how can i help you?</h2>
        <ol>
            <li><a href="ViewAllServlet.do">View All Barcodes</a></li>
            <li><a href="LogoutServlet.do">Logout</a></li>
        </ol>
    </body>
</html>
