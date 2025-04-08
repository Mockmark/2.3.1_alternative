package application.service;

import application.model.User;

import java.util.List;

public interface ServiceProv {
    void addUser(User user);
    List<User> index();
    User getUserById(int id);
    void updateUser(User user);
    void deleteUser(int id);
}
