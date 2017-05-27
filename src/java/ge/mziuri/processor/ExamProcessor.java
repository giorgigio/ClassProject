package ge.mziuri.processor;

import ge.mziuri.dao.CommentDAO;
import ge.mziuri.dao.CommentDAOImpl;
import ge.mziuri.dao.ExamDAO;
import ge.mziuri.dao.ExamDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Comment;
import ge.mziuri.model.Exam;
import java.util.List;

public class ExamProcessor {

    private ExamDAO examDAO = new ExamDAOImpl();

    private CommentDAO commentDAO = new CommentDAOImpl();
    
    private UserDAO userDAO = new UserDAOImpl();

    public List<Exam> getAllExamByGroupId(int groupId) {
        List<Exam> exams = examDAO.getAllExamByGroupId(groupId);
        for (Exam exam : exams) {
            List<Comment> comments = commentDAO.getAllCommentByExamId(exam.getId());
            for (Comment comment : comments) {
                comment.setUser(userDAO.getUserById(comment.getUser().getId()));
            }
            exam.setComments(comments);
        }
        return exams;
    }
}
