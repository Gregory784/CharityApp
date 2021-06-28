package pl.coderslab.model.service.user;

import pl.coderslab.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    void createUser(User user);

    Optional<User> getUserByID(long id);

    void updateUser(User user);

    void deleteUserByID(long id);

    boolean existsByEmail(String email);
}
