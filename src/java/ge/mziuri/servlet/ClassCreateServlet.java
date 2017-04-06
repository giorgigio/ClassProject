package ge.mziuri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassCreateServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
         
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // request პარამეტრად ექნება ჯგუფი სახელი
        // Cookie-ში იქნება მომხმარებლის Id და ამ id-თ უნდა შექმნა მომხმარებელი
        // ამ ორი ინფორმაციით უნდა შექმნა ჯგუფი და გაიტანო ბაზაში
    }
}