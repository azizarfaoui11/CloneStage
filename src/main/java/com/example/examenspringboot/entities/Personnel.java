package com.example.examenspringboot.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereAffectaion;
    @Enumerated(EnumType.STRING)
    private TypePersonnel typePersonnel;

    @OneToOne(mappedBy = "perso")
    Zone zone;

    @ManyToOne
    Zone person;




}
