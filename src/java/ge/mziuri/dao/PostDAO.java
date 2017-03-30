package ge.mziuri.dao;

import ge.mziuri.model.Post;

public interface PostDAO {
    void addPost(Post post, int groupId);
}
