package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User readUser(Long id);

    void updateUser(User user);

    void deleteUser(Long parseUnsignedInt);

    void createUser(User user);
}
