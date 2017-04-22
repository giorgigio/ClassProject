package processor;

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
    
    private PostDAO postDAO = new PostDAOImpl();
    
    private ClassGroupDAO classGroupDAO = new ClassGroupDAOImpl();
    
    private ExamDAO examDAO = new ExamDAOImpl();
    
    public ClassGroup getClassGroupById(int id){
        
    }
    
}
