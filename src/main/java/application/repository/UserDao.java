package application.repository;

import application.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements DataAccess{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> index() {
        TypedQuery<User> HQL = entityManager.createQuery("FROM User", User.class);
        return HQL.getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
