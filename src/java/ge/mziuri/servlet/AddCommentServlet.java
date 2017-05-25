package ge.mziuri.servlet;

import ge.mziuri.dao.CommentDAO;
import ge.mziuri.dao.CommentDAOImpl;
import ge.mziuri.model.Comment;
import ge.mziuri.model.Post;
import ge.mziuri.model.User;
import ge.mziuri.util.CookieUtil;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCommentServlet extends HttpServlet {
    
    private CommentDAO commentDAO = new CommentDAOImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("comment");
        Comment comment = new Comment();
        comment.setText(text);
        Date currDate = new Date();
        java.sql.Date date = new java.sql.Date(currDate.getTime());
        Time time = new Time(currDate.getTime());
        comment.setDate(date);
        comment.setTime(time);
        User user = new User();
        user.setId(Integer.parseInt(CookieUtil.getCookieValue("userId", request, true)));
        comment.setUser(user);
        Post post = new Post();
        post.setId(Integer.parseInt(request.getParameter("postId")));
        comment.setPost(post);
        CommentDAO commentDAO = new CommentDAOImpl();
        commentDAO.addComment(comment);
        RequestDispatcher rd = request.getRequestDispatcher("addPost.jsp");
        rd.forward(request, response);
    }
}
