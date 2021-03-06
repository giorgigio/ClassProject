package ge.mziuri.dao;

import ge.mziuri.model.Exam;
import ge.mziuri.model.Post;
import ge.mziuri.model.User;
import ge.mziuri.util.StringUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl implements ExamDAO {

    private final Connection conn;

    private PreparedStatement pstmt;

    public ExamDAOImpl() {
        conn = DatabaseUtil.getConnection();
    }

    @Override
    public void addExam(Exam exam, int groupId) {
        try {
            String sql = "INSERT INTO exam (subject,exam_date,exam_time,description,archived,images,group_id) VALUES (?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, exam.getSubject());
            pstmt.setDate(2, exam.getDate());
            pstmt.setTime(3, exam.getTime());
            pstmt.setString(4, exam.getText());
            pstmt.setBoolean(5, exam.isArchived());
            pstmt.setString(6, StringUtil.getStringFromList(exam.getImages()));
            pstmt.setInt(7, groupId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(conn);
        }
    }

    @Override
    public List<Exam> getAllExamByGroupId(int groupId) {
        List<Exam> exams = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement("SELECT * FROM exam WHERE group_id = ?");
            pstmt.setInt(1, groupId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String subject = rs.getString("subject");
                String text = rs.getString("description");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                Boolean archived = rs.getBoolean("archived");
                List<String> images = StringUtil.getStringListFromString(rs.getString("images"));
                Exam exam = new Exam();
                exam.setId(id);
                exam.setDate(date);
                exam.setTime(time);
                exam.setText(text);
                exam.setArchived(archived);
                exam.setImages(images);
                exams.add(exam);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DatabaseUtil.closeConnection(conn);
        }
        return exams;
    }
}
