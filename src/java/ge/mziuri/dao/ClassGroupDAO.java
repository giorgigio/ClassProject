package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;
import java.util.List;

public interface ClassGroupDAO {
    
    void addClassGroup(ClassGroup classgroup);
    
    List<ClassGroup> getAllClassGroup();
    
    //ClassGroup getGroupById(int groupId);
}