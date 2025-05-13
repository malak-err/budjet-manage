package com.example.budjetmanager.repositories;

import com.example.budjetmanager.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepositorie extends JpaRepository<Categorie,Long> {


}
