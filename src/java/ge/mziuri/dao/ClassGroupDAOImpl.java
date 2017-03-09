package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassGroupDAOImpl implements ClassGroupDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public ClassGroupDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addClassGroup(ClassGroup classgroup) {
        try {
            String sql = "INSERT INTO system_user (name) VALUES (?) RETURNING id";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classgroup.getName());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int groupId = rs.getInt("id");
            String userSql = "UPDATE system_user SET created_group_id = ?, joined_group_id = ? WHERE id = ?";
            pstmt = conn.prepareCall(userSql);
            pstmt.setInt(1, groupId);
            pstmt.setInt(2, groupId);
            pstmt.setInt(3, classgroup.getCreator().getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ClassGroup getClassGroup(String name) {
        return null;
    }
}