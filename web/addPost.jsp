<%-- 
    Document   : addPost
    Created on : Apr 27, 2017, 5:57:33 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> <link rel="stylesheet" type="text/css" href="public/css/addPost.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>კლასის სახელი</title>
    </head>
    <body>
        <div>მომხმარებელი - <%=request.getAttribute("name")%></div>
        <h1>კლასი - <%=request.getAttribute("className")%></h1>
        <ul style="list-style-type:none">
        <li><a href="myGroup.jsp">მთავარი</a></li>
        <li><a href="addPost.jsp">პოსტის დამატება</a></li>
        <li><a href="addExam.jsp">გამოცდის დამატება</a></li>
         <li><a href="members.jsp">ჯგუფის წევრები</a></li>
        </ul>
        <p> იფფ</p>
    </body>
</html>