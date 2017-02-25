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
}
