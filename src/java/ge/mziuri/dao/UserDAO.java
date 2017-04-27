package ge.mziuri.dao;

import ge.mziuri.model.User;
import java.util.List;

public interface UserDAO {

    void addUser(User user);

    User getUser(String username, String password);

    List<User> getAllUsersByGroupId(int groupId);

    List<User> getAllUsersByEventId(int eventId);
}
