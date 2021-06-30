package pl.coderslab.model.service.role;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
