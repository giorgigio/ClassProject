package ge.mziuri.dao;

import ge.mziuri.model.Comment;
import java.util.List;

public interface CommentDAO {
    
    void addComment(Comment comment);
    
    List<Comment> getAllComments();
    
}