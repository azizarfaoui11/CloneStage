package com.example.examenspringboot.repository;

import com.example.examenspringboot.entities.Personnel;
import com.example.examenspringboot.entities.TypePersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Personnelrepository extends JpaRepository<Personnel,Long> {

    Personnel findPersonnelByIdPersonnelAndAndTypePersonnel(Long id , TypePersonnel tp);
}
