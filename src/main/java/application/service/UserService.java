package application.service;

import application.model.User;
import application.repository.DataAccess;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements ServiceProv {
    private final DataAccess userDao;

    public UserService(DataAccess userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
