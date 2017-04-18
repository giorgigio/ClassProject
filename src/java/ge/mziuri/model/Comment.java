
package ge.mziuri.model;

import java.sql.Date;
import java.sql.Time;

public class Comment {
    
    private int id;
    private String text;
    private User user;
    private Date date;
    private Time time;
    private Post post;

    public Comment() {
    }

    public Comment(int id, String text, User user, Date date, Time time, Post post) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.date = date;
        this.time = time;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}