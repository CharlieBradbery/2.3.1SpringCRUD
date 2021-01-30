package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public UserDaoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();

    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
//        User us = entityManager.find(User.class, user.getId());
//        entityManager.refresh(us);
        entityManager.merge(user);
//        entityManager.detach(us);
//        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(int id) {
        TypedQuery<User> qu = entityManager.createQuery("select u from User u where u.id=:id", User.class);
        qu.setParameter("id", id);
        return qu.getResultList().stream().findAny().orElse(null);

    }
}
