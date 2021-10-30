package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "vaccine_type", nullable = false, unique = true)
    private String vaccineType;

    @Column(name = "second_dose_time", nullable = false, unique = true)
    private Integer secondDoseTimeInDays;
}
