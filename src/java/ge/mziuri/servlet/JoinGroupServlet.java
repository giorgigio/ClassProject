package ge.mziuri.servlet;

import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinGroupServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        UserDAO userDAO = new UserDAOImpl();
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        userDAO.joinGroup(groupId, Integer.parseInt(CookieUtil.getCookieValue("userId", request, true)));
        CookieUtil.addCookie("groupId", "" + groupId, response);
        request.setAttribute("groupId", "" + groupId);
        RequestDispatcher rd = request.getRequestDispatcher("myGroup.jsp");
        rd.forward(request, response);
    }
}