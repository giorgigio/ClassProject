package ge.mziuri.dao;

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

public class PostDAOImpl implements PostDAO{
        
    private final Connection conn;
    
    private PreparedStatement pstmt;
    
    public PostDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addPost(Post post, int groupId) {
        try {
            String sql = "INSERT INTO post (author,post_date,post_time,text) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, post.getAuthor().getId());
            pstmt.setDate(2, post.getDate());
            pstmt.setTime(3, post.getTime());
            pstmt.setString(4, post.getText());
            pstmt.setInt(5, groupId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM post");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                String text = rs.getString("text");
                Boolean event = rs.getBoolean("event");
                Post post = new Post();
                post.setId(id);
                post.setDate(date);
                post.setTime(time);
                post.setText(text);
                post.setEvent(event);
                User user = new User();
                user.setUsername(rs.getString("username"));
                post.setAuthor(user);
                posts.add(post);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
}
