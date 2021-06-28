package pl.coderslab.model.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table (name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "cannot be empty")
    @Size(min = 2, message = "min 2 characters")
    private String name;

    @NotBlank(message = "cannot be empty")
    @Size(min = 2, message = "min 2 characters")
    private String lastName;

    @NotBlank(message = "cannot be empty")
    @Column(nullable = false, unique = true, length = 70)
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password must have minimum eight characters, at least one letter and one number")
    @Column(nullable = false)
    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    @Transient
    @NotBlank(message = "cannot be empty")
    private String password2;
}
