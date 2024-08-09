package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    public void update(int id, User user) {
        User updateUser = entityManager.find(User.class, id);

        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhoneNumber(user.getPhoneNumber());

        entityManager.merge(updateUser);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
