package ge.mziuri.processor;

import ge.mziuri.dao.CommentDAO;
import ge.mziuri.dao.CommentDAOImpl;
import ge.mziuri.dao.PostDAO;
import ge.mziuri.dao.PostDAOImpl;
import ge.mziuri.dao.UserDAO;
import ge.mziuri.dao.UserDAOImpl;
import ge.mziuri.model.Comment;
import ge.mziuri.model.Post;
import java.util.List;

public class PostProcessor {

    private PostDAO postDAO = new PostDAOImpl();

    private CommentDAO commentDAO = new CommentDAOImpl();
    
    private UserDAO userDAO = new UserDAOImpl();

    public List<Post> getAllPostsByGroupId(int groupId) {
        List<Post> posts = postDAO.getAllPostsByGroupId(groupId);
        for (Post post : posts) {
            List<Comment> comments = commentDAO.getAllCommentByExamId(post.getId());
            post.setComments(comments);
            userDAO = new UserDAOImpl();
            post.setAuthor(userDAO.getUserById(post.getAuthor().getId()));
        }
        return posts;
    }
}
