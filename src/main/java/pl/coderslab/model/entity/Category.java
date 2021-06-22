package pl.coderslab.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private String name;

}
