package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }


    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User readUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) throws NullPointerException {
        User user = readUser(id);
        if (user == null) {
            return;
        }
        entityManager.remove(user);
        entityManager.flush();
    }
}
