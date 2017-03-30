package ge.mziuri.dao;

import ge.mziuri.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDAOImpl implements PostDAO{
        
    private final Connection conn;
    
    private PreparedStatement pstmt;
    
    public PostDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addPost(Post post, int groupId) {
        try {
            String sql = "INSERT INTO system_user (author,date,time,text) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post.getAuthor().getId());
            pstmt.setString(2, post.getText());
            pstmt.setDate(3, post.getDate());
            pstmt.setTime(4, post.getTime());
            pstmt.setInt(5, groupId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
