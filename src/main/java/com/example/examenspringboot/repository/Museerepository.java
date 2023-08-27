package com.example.examenspringboot.repository;

import com.example.examenspringboot.entities.Musee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Museerepository extends JpaRepository<Musee,Long> {
}
