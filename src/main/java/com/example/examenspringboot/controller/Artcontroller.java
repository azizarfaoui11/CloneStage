package com.example.examenspringboot.controller;

import com.example.examenspringboot.entities.Direction;
import com.example.examenspringboot.entities.OeuvreArt;
import com.example.examenspringboot.entities.Personnel;
import com.example.examenspringboot.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
public class Artcontroller {

@Autowired
    Iservice is;

@PostMapping("/addOuevreArt/{id}")
    public OeuvreArt addart(@RequestBody OeuvreArt ar, @PathVariable("id") Long idz)
{

    return is.ajouterOeuvreArtEtAffecterAZone(ar,idz);
}

@GetMapping("shoowlistetableau/{id}/{idd}")
    public List<String> showw(@PathVariable("id") Long idm, @PathVariable("idd") Direction direc)
{
    return is.titreTableauParMuseeEtDirection(idm,direc);
}



}
