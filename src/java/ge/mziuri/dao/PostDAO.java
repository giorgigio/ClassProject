package ge.mziuri.dao;

import ge.mziuri.model.Post;
import java.util.List;

public interface PostDAO {
    void addPost(Post post, int groupId);
    
    List<Post> getAllPosts();
}
