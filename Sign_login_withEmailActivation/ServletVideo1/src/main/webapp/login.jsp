<%-- 
    Document   : login
    Created on : May 26, 2020, 7:39:57 PM
    Author     : 97798
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome</h1>
        <form action="Login" method="POST">
            <label>Email ::</label>
            <input name="email" id="n1" type="text"/>
            <br><br>
            <label>Password ::</label>
            <input name="pword" id="n2" type="password"/>
            <br><br>
            <input name="submit" type="submit" value="Submit"/>
        </form>
        <a href="index.jsp">Sign Up</a>

    </body>
</html>
