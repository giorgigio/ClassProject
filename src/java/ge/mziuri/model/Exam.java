package ge.mziuri.model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Exam {

    private int id;
    private String subject;
    private Date date;
    private Time time;
    private String text;
    private List<String> images = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private boolean archived;

    public Exam() {
    }

    public Exam(int id, String subject, Date date, Time time, String text, boolean archived) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.text = text;
        this.archived = archived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
