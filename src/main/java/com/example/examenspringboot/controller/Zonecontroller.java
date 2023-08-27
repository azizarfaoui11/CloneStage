package com.example.examenspringboot.controller;

import com.example.examenspringboot.entities.Zone;
import com.example.examenspringboot.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Zonecontroller {

@Autowired
    Iservice is;

@PostMapping("/addzonetomusee/{id}")
    public Zone addzone(@RequestBody Zone z, @PathVariable("id") Long idm)
{

    return is.ajouterZoneEtAffecterAMusee(z,idm);
}

}
