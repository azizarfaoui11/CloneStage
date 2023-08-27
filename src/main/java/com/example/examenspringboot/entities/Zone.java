package com.example.examenspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZone;
    private String code;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    private boolean actif  ;
    @JsonIgnore
    @ManyToOne
    Musee musee;
    @JsonIgnore
    @OneToMany(mappedBy = "zonee")
    private List<OeuvreArt> oeuvreArts;
    @OneToOne
    Personnel perso;

    @OneToMany(mappedBy = "person")
    private List<Personnel> personnelList;



}
