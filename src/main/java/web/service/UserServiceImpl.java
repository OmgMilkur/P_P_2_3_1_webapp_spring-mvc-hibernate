package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {
    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void save(User user) {
        userDaoImpl.save(user);
    }

    public List<User> index() {
        return userDaoImpl.index();
    }

    public User show(int id) {
        return userDaoImpl.show(id);
    }

    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    public void update(int id, User user) {
        userDaoImpl.update(id, user);

    }
}
