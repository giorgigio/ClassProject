package ge.mziuri.dao;

import ge.mziuri.model.Comment;
import ge.mziuri.model.Exam;
import ge.mziuri.model.Post;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    private final Connection conn;

    private PreparedStatement pstmt;

    public CommentDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addComment(Comment comment) {
        try {
            String sql = "INSERT INTO comment (text,user_id,post_id,exam_id,comment_date,comment_time) VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comment.getText());
            pstmt.setInt(2, comment.getUser().getId());
            if (comment.getPost() == null) {
                pstmt.setInt(3, 0);
            } else {
                pstmt.setInt(3, comment.getPost().getId());
            }
            if (comment.getExam() == null) {
                pstmt.setInt(4, 0);
            } else {
                pstmt.setInt(4, comment.getExam().getId());
            }
            pstmt.setDate(5, comment.getDate());
            pstmt.setTime(6, comment.getTime());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(conn);
        }
    }

    @Override
    public List<Comment> getAllCommentByPostId(int postId) {
        List<Comment> comments = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM comment WHERE post_id = ?");
            pstmt.setInt(1, postId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("comment_date");
                Time time = rs.getTime("comment_time");
                String text = rs.getString("text");
                Comment comment = new Comment();
                comment.setId(id);
                comment.setDate(date);
                comment.setTime(time);
                comment.setText(text);
                User user = new User();
                user.setId(rs.getInt("user_id"));
                comment.setUser(user);
                comment.setPost(new Post(postId));
                comments.add(comment);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(conn);
        }
        return comments;
    }

    @Override
    public List<Comment> getAllCommentByExamId(int examId) {
        List<Comment> comments = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM comment WHERE exam_id = ?");
            pstmt.setInt(1, examId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("comment_date");
                Time time = rs.getTime("comment_time");
                String text = rs.getString("text");
                Comment comment = new Comment();
                comment.setId(id);
                comment.setDate(date);
                comment.setTime(time);
                comment.setText(text);
                User user = new User();
                user.setId(rs.getInt("user_id"));
                comment.setUser(user);
                comment.setExam(new Exam(examId));
                comments.add(comment);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(conn);
        }
        return comments;
    }
}
