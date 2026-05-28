<%-- 
    Document   : enter_auditor
    Created on : 25 May 2026, 17:41:58
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
        <h1>Auditor Info</h1>
        <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
            %>
            <h2>Hello, this is <%=siri%>, enter your details</h2>
            <form action="StartSessionServlet.do" method="POST">
        <table>
            <tr>
                <td>Employee Name</td>
                <td><input type="text" name="name"></td>
            </tr>
              <tr>
                <td>Unique Staff Number</td>
                <td><input type="number" name="staffID"></td>
            </tr>
              <tr>
                <td>Submit</td>
                <td><input type="submit" name="butt"></td>
            </tr>
        </table>
                </form>
    </body>
</html>
