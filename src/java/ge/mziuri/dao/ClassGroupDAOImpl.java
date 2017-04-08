package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;
import ge.mziuri.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassGroupDAOImpl implements ClassGroupDAO {
    
    private Connection conn;
    
    private PreparedStatement pstmt;
    
    public ClassGroupDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addClassGroup(ClassGroup classgroup) {
        try {
            String sql = "INSERT INTO class_group (name) VALUES (?) RETURNING id";
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
    public List<ClassGroup> getAllClassGroup() {
        List<ClassGroup> groups = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT class_group.id, class_group.name, system_user.username FROM class_group INNER JOIN system_user ON system_user.created_group_id = class_group.id;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                ClassGroup classgroup = new ClassGroup();
                classgroup.setId(id);
                classgroup.setName(name);
                User user = new User();
                user.setUsername(rs.getString("username"));
                classgroup.setCreator(user);
                groups.add(classgroup);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return groups;
    }
}