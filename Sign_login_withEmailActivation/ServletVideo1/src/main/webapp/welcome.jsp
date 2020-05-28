<%-- 
    Document   : welcome
    Created on : May 10, 2020, 5:31:23 PM
    Author     : 97798
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.0
            
            response.setHeader("Pragma", "no-cache");//Http 1.0
            response.setHeader("Expires", "0");//Proxies
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("Login.jsp");
            }    
        
        %>

          
          <p> <h1>Welcome ${username}!</h1></p>
        
       
       
        
        <form action="Logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
