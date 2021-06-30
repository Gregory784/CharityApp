package pl.coderslab.model.entity;


import lombok.Data;

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

}
