package ge.mziuri.dao;

import ge.mziuri.model.Exam;
import java.util.List;

public interface ExamDAO {
    
    void addExam(Exam exam, int groupId);
    
    List<Exam> getAllExamByGroupId(int groupId);
    
}
