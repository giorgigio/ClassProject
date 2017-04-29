package ge.mziuri.processor;

import ge.mziuri.dao.ClassGroupDAO;
import ge.mziuri.dao.ClassGroupDAOImpl;
import ge.mziuri.dao.ExamDAO;
import ge.mziuri.dao.ExamDAOImpl;
import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.ClassGroup;

public class ClassGroupProcessor {

    private UserDAO userDAO = new UserDAOImpl();

    private ClassGroupDAO classGroupDAO = new ClassGroupDAOImpl();
    
    private ExamProcessor examProcessor = new ExamProcessor();
    
    private PostProcessor postProcessor = new PostProcessor();

    public ClassGroup getClassGroupById(int id) {
        ClassGroup classGroup = classGroupDAO.getGroupById(id);
        classGroup.setCreator(userDAO.getCreator(id));
        classGroup.setExams(examProcessor.getAllExamByGroupId(id));
        classGroup.setPosts(postProcessor.getAllPostsByGroupId(id));
        classGroup.setMembers(userDAO.getAllUsersByGroupId(id));
        return classGroup;
    }
}
