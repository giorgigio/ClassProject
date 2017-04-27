<%@page import="ge.mziuri.model.ClassGroup"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> <link rel="stylesheet" type="text/css" href="public/css/myGroup.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>კლასის სახელი</title>
    </head>
    <body>
        <h1>კლასი - <%=request.getAttribute("className")%></h1>
        <ul style="list-style-type:none">
        <li><a href="#home">მთავარი</a></li>
        <li><a href="#news">პოსტის დამატება</a></li>
        <li><a href="#contact">გამოცდის დამატება</a></li>
         <li><a href="#about">ჯგუფის წევრები</a></li>
        </ul>
        <div>მომხმარებელი - <%=request.getAttribute("name")%></div>
    </body>
</html>