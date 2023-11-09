package com.ahmed.personne.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.personne.entities.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    // Add any custom query methods if needed
}
