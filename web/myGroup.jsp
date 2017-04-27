<%@page import="processor.ClassGroupProcessor"%>
<%@page import="ge.mziuri.model.ClassGroup"%>
<%@page import="ge.mziuri.util.CookieUtil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <link rel="stylesheet" type="text/css" href="public/css/myGroup.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>კლასის სახელი</title>
    </head>
    <body>
        <%
            ClassGroupProcessor classGroupProcessor = new ClassGroupProcessor();
            ClassGroup classGroup = classGroupProcessor.getClassGroupById(Integer.parseInt(CookieUtil.getCookieValue("groupId", request)));
            %>
        <div>მომხმარებელი - <%=CookieUtil.getCookieValue("firstname", request) + CookieUtil.getCookieValue("lastname", request)%></div>
        <h1>კლასი - <%=classGroup.getName()%></h1>
        <ul style="list-style-type:none">
            <li><a href="myGroup.jsp">მთავარი</a></li>
            <li><a href="addPost.jsp">პოსტის დამატება</a></li>
            <li><a href="addExam.jsp">გამოცდის დამატება</a></li>
            <li><a href="members.jsp">ჯგუფის წევრები</a></li>
        </ul>

    </body>
</html>