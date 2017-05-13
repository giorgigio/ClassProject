package ge.mziuri.servlet;

import ge.mziuri.dao.ExamDAO;
import ge.mziuri.dao.ExamDAOImpl;
import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.model.Exam;
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

public class AddExamServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        String description = request.getParameter("description");
        String subject = request.getParameter("subject");
        Date currDate = new Date();
        java.sql.Date date = new java.sql.Date(currDate.getTime());
        Time time = new Time(currDate.getTime());
        Exam exam = new Exam();
        exam.setSubject(subject);
        exam.setDate(date);
        exam.setTime(time);
        exam.setText(description);
        exam.setArchived(false);
        //images
        ExamDAO examDAO = new ExamDAOImpl();
        examDAO.addExam(exam, Integer.parseInt(CookieUtil.getCookieValue("groupId", request, true)));
        RequestDispatcher rd = request.getRequestDispatcher("myGroup.jsp");
        rd.forward(request, response);
    }
}
