package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getById(Long id);

    void update(Long id, User userUpd);

    void delete(Long id);
}
