package pl.coderslab.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        roles.add(role);
    }

}
