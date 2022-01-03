package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CENTRE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long centreId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "vaccine", nullable = false)
    private String vaccine;

    @Column(name = "available", nullable = false)
    private Integer available;
}
