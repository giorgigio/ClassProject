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
        
    }

    @Override
    public ClassGroup getClassGroup(String name) {
        return null;
    }
}