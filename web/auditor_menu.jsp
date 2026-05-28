<%-- 
    Document   : auditor_menu
    Created on : 25 May 2026, 18:02:52
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
        <h1>Auditor Menu</h1>
        <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
           String name = (String)session.getAttribute("name");
            %>
            <h2>Hello <%=name%>, <%=siri%> says how can i help you?</h2>
        <ol>
            <li><a href="GenServlet.do">Enter manual tracking barcode</a></li>
            <li><a href="LogoutServlet.do">Logout</a></li>
        </ol>
    </body>
</html>
