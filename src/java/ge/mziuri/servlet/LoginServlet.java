package ge.mziuri.servlet;

import ge.mziuri.dao.ClassGroupDAO;
import ge.mziuri.dao.ClassGroupDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ge.mziuri.util.CookieUtil;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(username, Integer.toString(password.hashCode()));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (user == null) {
            request.setAttribute("logInFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {
            CookieUtil.addCookie("userId", "" + user.getId(), response);
            request.setAttribute("userId", "" + user.getId());
            CookieUtil.addCookie("firstname", user.getFirstname(), response);
            request.setAttribute("firstname", user.getFirstname());
            CookieUtil.addCookie("lastname", user.getLastname(), response);
            request.setAttribute("lastname", user.getLastname());
            if (user.getGroup() == null) {
                ClassGroupDAO classGroupDAO = new ClassGroupDAOImpl();
                request.setAttribute("allGroups", classGroupDAO.getAllClassGroup());
                RequestDispatcher rd = request.getRequestDispatcher("chooseGroup.jsp");
                rd.forward(request, response);
            } else {
                CookieUtil.addCookie("groupId", "" + user.getGroup().getId(), response);
                request.setAttribute("groupId", "" + user.getGroup().getId());
                RequestDispatcher rd = request.getRequestDispatcher("myGroup.jsp");
                rd.forward(request, response);
            }
        }
    }
}
