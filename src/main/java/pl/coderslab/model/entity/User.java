package pl.coderslab.model.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table (name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "cannot be empty")
    private String name;
    @NotBlank(message = "cannot be empty")
    @Column(nullable = false, unique = true, length = 70)
    private String email;

    @NotBlank(message = "cannot be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    @NotBlank(message = "cannot be empty")
    private String password2;
}
