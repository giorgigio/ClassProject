package ge.mziuri.servlet;

import ge.mziuri.dao.ClassGroupDAO;
import ge.mziuri.dao.ClassGroupDAOImpl;
import ge.mziuri.model.ClassGroup;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ge.mziuri.util.CookieUtil;

public class ClassCreateServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        ClassGroupDAO classGroupDAO = new ClassGroupDAOImpl();
        ClassGroup classGroup = new ClassGroup();
        classGroup.setName(name);
        User user = new User();
        user.setId(Integer.parseInt(CookieUtil.getCookieValue("userId", request)));
        classGroup.setCreator(user);
        classGroupDAO.addClassGroup(classGroup);
        user.setGroup(classGroup);
        request.setAttribute("className", user.getGroup().getName());
        RequestDispatcher rd = request.getRequestDispatcher("myGroup.jsp");
        rd.forward(request, response);
    }
}
