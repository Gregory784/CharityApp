package pl.coderslab.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Component
@Data
public class UserDto {
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

    @NotBlank(message = "cannot be empty")
    @Column(nullable = false)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message ="Password must have minimum eight characters, at least one letter and one number" )
    private String password;
    @NotBlank(message = "cannot be empty")
    private String password2;

}
