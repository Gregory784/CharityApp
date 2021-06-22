package pl.coderslab.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "institutions")
@Data
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private String name;
    private String description;
}
