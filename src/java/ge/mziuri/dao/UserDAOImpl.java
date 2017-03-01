package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public UserDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO mainuser (firstname,lastname,username,password,email,admin) VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFirstname());
            pstmt.setString(2, user.getLastname());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getEmail());
            pstmt.setBoolean(6, user.isAdmin());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User getUser(String username, String password) {
        try {
            String sql = "SELECT * FROM mainuser WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                Boolean admin = rs.getBoolean("admin");
                User user = new User(firstname, lastname, username, password, email, admin);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}