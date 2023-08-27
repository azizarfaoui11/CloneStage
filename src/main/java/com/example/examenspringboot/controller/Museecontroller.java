package com.example.examenspringboot.controller;

import com.example.examenspringboot.entities.Musee;
import com.example.examenspringboot.services.Iservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class Museecontroller {

@Autowired
    Iservice is;

@PostMapping("/addmuseee")
    public Musee addm(@RequestBody Musee m)
{
    return is.ajouterMusee(m);
}

}
