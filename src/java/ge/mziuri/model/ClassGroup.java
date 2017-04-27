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

    public ClassGroup() {
    }

    public ClassGroup(int id, String name, User creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }
}
