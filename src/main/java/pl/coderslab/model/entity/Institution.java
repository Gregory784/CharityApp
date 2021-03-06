package pl.coderslab.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "institutions")
@Data
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "cannot be empty")
    private String name;
    @NotBlank(message = "cannot be empty")
    private String description;
}
