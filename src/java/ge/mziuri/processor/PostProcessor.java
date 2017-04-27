package ge.mziuri.processor;

import ge.mziuri.dao.CommentDAO;
import ge.mziuri.dao.CommentDAOImpl;
import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.model.Comment;
import ge.mziuri.model.Post;
import java.util.List;

public class PostProcessor {

    private PostDAO postDAO = new PostDAOImpl();

    private CommentDAO commentDAO = new CommentDAOImpl();

    public List<Post> getAllPostsByGroupId(int groupId) {
        List<Post> posts = postDAO.getAllPostsByGroupId(groupId);
        for (Post post : posts) {
            List<Comment> comments = commentDAO.getAllCommentByExamId(post.getId());
            post.setComments(comments);
        }
        return posts;
    }
}
