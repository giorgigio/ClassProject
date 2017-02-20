package ge.mziuri.dao;

import ge.mziuri.model.ClassGroup;

public interface ClassGroupDAO {
    
    void addClassGroup(ClassGroup classgroup);
    
    ClassGroup getClassGroup(String name);
    
}