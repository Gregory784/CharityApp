package pl.coderslab.model.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @Min(1)
    private int quantity;

    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pickUpDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalTime pickUpTime;
    private String pickUpComment;
    private int phoneNumber;

    // dodać numer telefonu?

}
