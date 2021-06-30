package pl.coderslab.model.entity;


import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table (name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String lastName;
    private String email;
    private String password;

    public User setPassword1(final String password) {
        hashPassword(password);
        this.password = password;
        return this;
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
