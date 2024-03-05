package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User readUser(Long id) {
        return userRepository.readUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
