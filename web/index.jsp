<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>>შესვლის გვერდი</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body>
        <div class="loginForm">
            <form action="LoginServlet" method="post">
                <input type="text" name="username" /> <br>
                <input type="password" name="password" /> <br>
                <a href="register.jsp"> რეგისტრაცია </a>
                <input type="submit" value="შესვლა" />
                <%
                    if (request.getAttribute("logInFailed") != null && request.getAttribute("logInFailed") == Boolean.TRUE) {
                        out.write("<p style=\"color:red;\">სახელი ან პაროლი არასწორია </p>");
                    }    
                    %>
            </form>
        </div>
    </body>
</html>