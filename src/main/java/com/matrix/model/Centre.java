package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "centre")
    private List<Stock> stocks;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "first_dose_schedule", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
}
