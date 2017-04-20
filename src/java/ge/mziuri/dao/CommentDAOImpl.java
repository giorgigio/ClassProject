package ge.mziuri.dao;

import ge.mziuri.model.Comment;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{
        
    private final Connection conn;
    
    private PreparedStatement pstmt;
    
    public CommentDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addComment(Comment comment) {
        try {
            String sql = "INSERT INTO comment (text,user_id,post_id,comment_date,comment_time) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comment.getText());
            pstmt.setInt(2, comment.getUser().getId());
            pstmt.setInt(3, comment.getPost().getId());
            pstmt.setDate(4, comment.getDate());
            pstmt.setTime(5, comment.getTime());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM comment");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                String text = rs.getString("text");
                Comment comment = new Comment();
                comment.setId(id);
                comment.setDate(date);
                comment.setTime(time);
                comment.setText(text);
                User user = new User();
                user.setUsername(rs.getString("username"));
                comment.setUser(user);
                comments.add(comment);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comments;
    }
}
