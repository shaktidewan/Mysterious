<%-- 
    Document   : index.jsp
    Created on : May 26, 2020, 5:55:29 PM
    Author     : 97798
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Sign-Up Page</h1>
        
        <form action="RegisterServlet" method="POST">
            <label>First Name::</label>
            <input name="fname" id="n1" type="text"/>
            <br><br>
            
            <label>Last Name::</label>
            <input name="lname" id="n2" type="text"/>
            <br><br>
            
            <label>Email ::</label>
            <input name="email" id="n3" type="text"/>
            <br><br>
            
            <label>Password ::</label>
            <input name="pword" id="n4" type="password"/>
            <br><br>
           
            <input name="submit" value="submit" type="submit"/>
                 
        </form>
        <a href="login.jsp">Already have an account</a>
    </body>
</html>
