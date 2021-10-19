package com.matrix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    @Email
    private String email;

    @Column
    @NotNull
    @Size(min = 8)
    private String password;

    @Column
    @NotNull
    @Size(min = 13, max = 13)
    private String cnp;

    @JoinColumn(name = "id", table = "Vaccine")
    @OneToOne
    private Long vaccineType;

    @Column
    @Nullable
    private Date firstDoseSchedule;

    @Column
    @Nullable
    private Date secondDoseSchedule;

    @Column
    @Nullable
    private Boolean firstDoseCompleted;

    @Column
    @Nullable
    private Boolean secondDoseCompleted;
}
