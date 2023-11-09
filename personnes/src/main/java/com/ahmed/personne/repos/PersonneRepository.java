package com.ahmed.personne.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.personne.entities.Categorie;
import com.ahmed.personne.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne,Long>  {

	List<Personne> findBynomPersonne(String nom);
	
	@Query
	("select p from Personne p where p.nomPersonne like %?1 and p.agePersonne > ?2")
	List<Personne> findBynomage (String nom, int age);
	
	@Query
	("select p from Personne p where p.categorie = ?1")
	List<Personne> findByCategorie (Categorie categorie);
	
	
}

