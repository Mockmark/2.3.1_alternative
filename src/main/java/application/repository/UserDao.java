package application.repository;

import application.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> index() {
        TypedQuery<User> HQL = entityManager.createQuery("FROM User", User.class);
        return HQL.getResultList();
    }
}
