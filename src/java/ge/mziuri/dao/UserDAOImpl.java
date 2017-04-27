package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    
    private final Connection conn;
    
    private PreparedStatement pstmt;
    
    public UserDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO system_user (firstname,lastname,username,password,email,admin) VALUES (?,?,?,?,?,?)";
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
            String sql = "SELECT * FROM system_user WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                int group_id = rs.getInt("joined_group_id");
                int id = rs.getInt("id");
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setAdmin(admin);
                user.setId(id);
                if (group_id != 0) {
                    ClassGroup classGroup = new ClassGroup();
                    classGroup.setId(group_id);
                    user.setGroup(classGroup);
                }
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    @Override
    public List<User> getAllUsersByGroupId(int groupId){
        List<User> users = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM system_user WHERE joined_group_id = ?");
            pstmt.setInt(1, groupId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                int group_id = rs.getInt("joined_group_id");
                int id = rs.getInt("id");
                User user = new User();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setAdmin(admin);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
    @Override
    public List<User> getAllUsersByEventId(int eventId){
        List<User> users = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM system_user ");
            pstmt.setInt(1, eventId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                int group_id = rs.getInt("joined_group_id");
                int id = rs.getInt("id");
                User user = new User();
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setEmail(email);
                user.setAdmin(admin);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
}