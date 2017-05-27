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

    public ClassGroup getClassGroupById(int id, int userId, boolean allPost) {
        ClassGroup classGroup = classGroupDAO.getGroupById(id);
        classGroup.setCreator(userDAO.getCreator(id));
        classGroup.setExams(examProcessor.getAllExamByGroupId(id));
        if (allPost) {
            classGroup.setPosts(postProcessor.getAllPostsByGroupId(id));
        } else {
            classGroup.setPosts(postProcessor.getAllPostsByUserId(userId));
        }
        userDAO = new UserDAOImpl();
        classGroup.setMembers(userDAO.getAllUsersByGroupId(id));
        return classGroup;
    }
}
