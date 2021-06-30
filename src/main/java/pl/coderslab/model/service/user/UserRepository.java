package pl.coderslab.model.service.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entity.User;

interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
