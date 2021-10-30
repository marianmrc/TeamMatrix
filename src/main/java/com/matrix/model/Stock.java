package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long stockId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccine_id", nullable = false, unique = true)
    private Vaccine vaccine;

    @Column(name = "nr_dose", nullable = false)
    private Integer nrDose;

    @ManyToOne
    @JoinColumn(name = "centre_id", nullable = false)
    private Centre centre;
}
