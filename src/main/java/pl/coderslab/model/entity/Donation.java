package pl.coderslab.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double id;
    private int quantity;

    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

}
