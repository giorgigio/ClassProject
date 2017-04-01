<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>რეგისტრაცია</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
    </head>
    <body>
        <div class="registerForm">
            <form action="RegisterServlet" name="registerForm" method="post">
                სახელი:     <input type="text" name="firstname"/> <br>
                გვარი:      <input type="text" name="lastname" /> <br>
                მომ. სახ. : <input type="text" name="username" /> <br>
                პაროლი :   <input type="password" name="password" /> <br>
                ელ-ფოსტა: <input type="text" name="email" /> <br>
                <input type="submit" value="á áááá¡á¢á ááªáá" />
            </form>
        </div>
    </body>
</html>