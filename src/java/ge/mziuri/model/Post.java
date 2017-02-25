package ge.mziuri.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Post {
    
    private int id;
    private User author;
    private Date date;
    private Time time;
    private String text;
    private List<Comment> comments = new ArrayList<>();
    private boolean event;
    private List<User> joinedList = new ArrayList<>();

    public Post() {
    }

    public Post(int id, User author, Date date, Time time, String text, boolean event) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.time = time;
        this.text = text;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public List<User> getJoinedList() {
        return joinedList;
    }

    public void setJoinedList(List<User> joinedList) {
        this.joinedList = joinedList;
    }
}