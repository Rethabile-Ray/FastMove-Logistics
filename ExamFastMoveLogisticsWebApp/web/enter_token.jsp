<%-- 
    Document   : enter_token
    Created on : 25 May 2026, 18:08:37
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
        <h1>Enter token Page</h1>
         <%
           String siri = pageContext.getServletContext().getInitParameter("CompName");
           String name = (String)session.getAttribute("name");
           String genToken = (String)session.getAttribute("genToken");
           String maskedStr = genToken.substring(0, 4) + "****";
            %>
            <h2>Okay <%=name%>, <%=siri%> says enter your manual tracking barcode</h2>
            <h3>Here is a part of the code: <%=maskedStr%></h3>
             <form action="TokenManagerServlet.do" method="POST">
        <table>
            <tr>
                <td>Enter barcode(eg.ZA99B7X2)</td>
                <td><input type="text" name="userCode"></td>
            </tr>
              
              <tr>
                <td>Submit</td>
                <td><input type="submit" name="butt"></td>
            </tr>
        </table>
                </form>
    </body>
</html>
