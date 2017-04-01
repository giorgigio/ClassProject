<%@page import="ge.mziuri.model.ClassGroup"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <link rel="stylesheet" type="text/css" href="public/css/chooseGroup.css"> </head>
    <body>
        <div class="Headline">
            <h1>მოგესალმებით <%=request.getAttribute("firstname")%></h1> 
        </div>
        <p style="font-weight: bold;">თქვენ არ ხართ გაწევრიანებული არცერთ ჯგუფში, იხილეთ ჯგუფების ჩამონათვალი</p>
        <%
            List<ClassGroup> allGroups = (List<ClassGroup>)request.getAttribute("allGroups");
            for (int i = 0; i < allGroups.size(); i++) {
                out.write("<div class=\"box\"> ");
                out.write("<form>");
                out.write("<p>ჯგუფის სახელი : " + allGroups.get(i).getName() + "</p>");
                out.write("<p>ჯგუფის შემქნელის სახელი :" + allGroups.get(i).getCreator().getUsername() + "</p>");
                out.write("<button class=\"join\">გაწევრიანება</button>");
                out.write("<form>");
                out.write("</div>");
            }
            %>
    </body>
</html>