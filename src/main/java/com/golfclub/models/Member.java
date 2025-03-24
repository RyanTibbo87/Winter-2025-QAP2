package com.golfclub.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;

    private LocalDate startDate;
    private int duration; // duration in months or years

    @ManyToMany(mappedBy = "participants")
    private Set<Tournament> tournaments;
}
