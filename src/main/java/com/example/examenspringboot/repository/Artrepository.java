package com.example.examenspringboot.repository;

import com.example.examenspringboot.entities.OeuvreArt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Artrepository extends JpaRepository<OeuvreArt,Long> {
}
