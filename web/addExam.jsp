<%@page import="ge.mziuri.processor.ClassGroupProcessor"%>
<%@page import="ge.mziuri.model.ClassGroup"%>
<%@page import="ge.mziuri.util.CookieUtil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <link rel="stylesheet" type="text/css" href="public/css/addExam.css">
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
        <button id="myBtn" style="margin-top: 10px;">გამოცდის დამატება</button>
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="AddExamServlet" method="POST" enctype="multipart/form-data">
                    <select name="subject">
                        <option value="MATH">მათემატიკა</option>
                        <option value="PHYSICS">ფიზიკა</option>
                        <option value="BIOLOGY">ბიოლოგია</option>
                        <option value="CHEMISTRY">ქიმია</option>
                        <option value="GEOGRAPHY">გეოგრაფია</option>
                        <option value="HISTORY">ისტორია</option>
                        <option value="GEORGIAN">ქართული</option>
                        <option value="ENGLISH">ინგლისური</option>
                        <option value="RUSSIAN">რუსული</option>
                    </select>
                    <textarea name="description" rows="10" cols="78" style="resize: none;"></textarea>
                    <input name="file" type="file" value="სურათის დამატება" style="margin-top: 5px;" multiple>
                    <input type="submit" value="გამოცდის დამატება" style="margin-top: 5px;">
                </form>
            </div>
        </div>
        <script>
            var modal = document.getElementById('myModal');

            var btn = document.getElementById("myBtn");

            var span = document.getElementsByClassName("close")[0];

            btn.onclick = function () {
                modal.style.display = "block";
            }

            span.onclick = function () {
                modal.style.display = "none";
            }

            window.onclick = function (event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </body>
</html>