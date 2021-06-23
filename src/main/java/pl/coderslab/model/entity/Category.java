package pl.coderslab.model.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    @NotBlank
    private String name;

}
