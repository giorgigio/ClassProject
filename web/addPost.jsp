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
            ClassGroup classGroup = classGroupProcessor.getClassGroupById(Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)));
        %> 
        <div>მომხმარებელი - <%=CookieUtil.getCookieValue("firstname", request, true) + " " + CookieUtil.getCookieValue("lastname", request, true)%></div>
        <h1>კლასი - <%=classGroup.getName()%></h1>
        <ul style="list-style-type:none">
            <li><a href="myGroup.jsp">მთავარი</a></li>
            <li><a href="addPost.jsp">ჩემი პოსტები</a></li>
            <li><a href="addExam.jsp">გამოცდები</a></li>
            <li><a href="members.jsp">ჯგუფის წევრები</a></li>
        </ul>
        <button id="myBtn" style="margin-top: 10px;">პოსტის დამატება</button>
        <div id="myModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="AddPostServlet" method="POST">
                    <select name="type">
                        <option value="POST">პოსტი</option>
                        <option value="EVENT">ღონისძიება</option>
                    </select>
                    <textarea name="description" rows="10" cols="78" style="resize: none;"></textarea>
                    <input type="submit" value="პოსტის დამატება" style="margin-top: 5px;"</button>
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