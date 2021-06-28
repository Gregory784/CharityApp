package pl.coderslab.model.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entity.User;

import java.util.List;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;


@Repository
@AllArgsConstructor
class UserImplRepository implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(final User user) {
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByID(final long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void updateUser(final User user) {
        if (userRepository.findById(user.getId()).isPresent()){
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUserByID(final long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
