package com.example.examenspringboot.services;

import com.example.examenspringboot.entities.Direction;
import com.example.examenspringboot.entities.Musee;
import com.example.examenspringboot.entities.OeuvreArt;
import com.example.examenspringboot.entities.Zone;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface Iservice {

    Musee ajouterMusee(Musee musee);
    public Zone ajouterZoneEtAffecterAMusee (Zone zone, Long idMusee);
    OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long idZone);
    void affecterPersonnelsAZone(Long idZone, Long idGardien, Long idDirecteur);
    List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) ;
}
