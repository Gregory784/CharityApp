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
    private long id;
    @Min(1)
    private int quantity;

    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Institution institution;

    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "H:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;
    private int phoneNumber;

    // dodać numer telefonu?

}
