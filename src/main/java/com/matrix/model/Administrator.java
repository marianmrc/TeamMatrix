package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "ADMINISTRATOR")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long administratorId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "administrator")
    private List<Vaccination> vaccinations;
}
