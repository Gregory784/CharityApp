package pl.coderslab.model.service.user;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entity.User;
import pl.coderslab.model.service.role.RoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Repository
@AllArgsConstructor
class UserImplRepository implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(final User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
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

    @Override
    public User findByEmail(final String email) {

        return userRepository.findByEmail(email);
    }

    public String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
