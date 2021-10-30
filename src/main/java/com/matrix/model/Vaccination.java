package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccine_type", nullable = false, unique = true)
    private Vaccine vaccine;

    @Column(name = "first_dose_schedule", nullable = false)
    private Date firstDoseSchedule;

    @Column(name = "second_dose_schedule", nullable = false)
    private Date secondDoseSchedule;

    @Column(name = "first_dose_completed", nullable = false)
    private Boolean firstDoseCompleted;

    @Column(name = "second_dose_completed", nullable = false)
    private Boolean secondDoseCompleted;
}
