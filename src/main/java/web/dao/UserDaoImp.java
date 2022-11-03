package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        User userById = entityManager.find(User.class, id);
        return userById;
    }

    @Override
    public void update(Long id, User userUpd) {
        User userSaveUpd = getById(id);
        userSaveUpd = entityManager.merge(userUpd);
    }

    @Override
    public void delete(Long id) {
        User userDel = entityManager.find(User.class, id);
        entityManager.remove(userDel);
    }
}
