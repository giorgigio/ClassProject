package ge.mziuri.servlet;

import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.model.Post;
import ge.mziuri.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ge.mziuri.util.CookieUtil;
import java.sql.Time;
import java.util.Date;

public class AddPostServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        User user = new User();
        user.setId(Integer.parseInt(CookieUtil.getCookieValue("userId", request, true)));
        Date currDate = new Date();
        java.sql.Date date = new java.sql.Date(currDate.getTime());
        Time time = new Time(currDate.getTime());
        Post post = new Post();  
        post.setAuthor(user);
        post.setDate(date);
        post.setTime(time);
        post.setText(description);
        if ("POST".equals(type)) {
            post.setEvent(false);
        } else if ("EVENT".equals(type)) {
            post.setEvent(true);
        }
        PostDAO postDAO = new PostDAOImpl();
        postDAO.addPost(post, Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)));
        request.setAttribute("allPosts", postDAO.getAllPostsByGroupId((Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)))));
        RequestDispatcher rd = request.getRequestDispatcher("addPost.jsp");
        rd.forward(request, response);
    }
}