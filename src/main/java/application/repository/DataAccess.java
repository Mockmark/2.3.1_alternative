package application.repository;

import application.model.User;

import java.util.List;

public interface DataAccess {
    void addUser(User user);
    List<User> index();
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
