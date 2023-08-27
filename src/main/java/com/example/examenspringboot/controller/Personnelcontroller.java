package com.example.examenspringboot.controller;

import com.example.examenspringboot.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Personnelcontroller {

    @Autowired
    Iservice is;

    @PostMapping("/affecterpersonneltozone/{id}/{idd}/{iddd}")
    public void affecter(@PathVariable("id") Long idz, @PathVariable("idd") Long idg, @PathVariable("iddd") Long iddire)
    {
         is.affecterPersonnelsAZone(idz,idg,iddire);
    }
}
