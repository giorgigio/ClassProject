 <%@page import="ge.mziuri.model.User"%>
<%@page import="ge.mziuri.processor.ClassGroupProcessor"%>
<%@page import="ge.mziuri.model.ClassGroup"%>
<%@page import="ge.mziuri.util.CookieUtil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <link rel="stylesheet" type="text/css" href="public/css/members.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>კლასის სახელი</title>
    </head>
    <body>
        <%
            ClassGroupProcessor classGroupProcessor = new ClassGroupProcessor();
            ClassGroup classGroup = classGroupProcessor.getClassGroupById(Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)),
                    Integer.parseInt(CookieUtil.getCookieValue("userId", request, true)), false);
        %> 
        <div>მომხმარებელი - <%=CookieUtil.getCookieValue("firstname", request, true) + " " + CookieUtil.getCookieValue("lastname", request, true)%></div>
        <a class="logout" href="index.jsp"> გასვლა </a>
        <h1>კლასი - <%=classGroup.getName()%></h1>
        <ul style="list-style-type:none">
            <li><a href="myGroup.jsp">მთავარი</a></li>
            <li><a href="addPost.jsp">ჩემი პოსტები</a></li>
            <li><a href="addExam.jsp">გამოცდები</a></li>
            <li><a href="members.jsp">ჯგუფის წევრები</a></li>
        </ul>
        <%
            List<User> allUsers = classGroup.getMembers();
            for(int i = 0; i<allUsers.size(); i++) {
                out.write("<p>" + allUsers.get(i).getFirstname()+ " " + allUsers.get(i).getLastname() +"</p>");
            }
            %>
    </body>
</html>