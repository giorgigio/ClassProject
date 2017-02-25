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
    private List<String> images = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private boolean archived;
}
