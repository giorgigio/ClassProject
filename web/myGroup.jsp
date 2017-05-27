<%@page import="java.sql.Date"%>
<%@page import="ge.mziuri.model.Comment"%>
<%@page import="ge.mziuri.model.Post"%>
<%@page import="ge.mziuri.processor.ClassGroupProcessor"%>
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
            ClassGroup classGroup = classGroupProcessor.getClassGroupById(Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)),
                    Integer.parseInt(CookieUtil.getCookieValue("userId", request, true)), true);
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
            for (Post post : classGroup.getPosts()) {
                out.write("<div class=\"postBox\">");
                out.write("<p2>" + post.getAuthor().getUsername() + "</p2>");
                out.write("<p1>" + new Date(post.getDate().getTime() + post.getTime().getTime()) + "</p1>");
                out.write("<p3>" + post.getText() + "</p3>");
                for (Comment comment : post.getComments()) {
                    out.write("<p4>" + comment.getUser().getUsername() + " : " + comment.getText() + "</p4>");
                }
                out.write("<form action=\"AddCommentServlet\" method=\"POST\" style=\"float:left\">");
                out.write("<input type=\"text\" name=\"comment\" size=\"80\"/>");
                out.write("<input type=\"hidden\" name=\"postId\" value=\"" + post.getId() + "\"/>");
                out.write("<input type=\"submit\" value=\"დამატება\"/>");
                out.write("</form>");
                out.write("</div>");
            }
            %>
    </body>
</html>