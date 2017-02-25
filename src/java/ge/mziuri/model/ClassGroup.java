package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;

public class ClassGroup {
    
    private int id;
    private String name;
    private User creator;
    private List<User> members = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Exam> exams = new ArrayList<>();

}