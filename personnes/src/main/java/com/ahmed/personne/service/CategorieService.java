package com.ahmed.personne.service;

import com.ahmed.personne.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie addCategorie(Categorie categorie);

    Categorie updateCategorie(Categorie categorie);

    void deleteCategorie(Categorie categorie);

    void deleteCategorieById(Long id);

    Categorie getCategorieById(Long id);

    List<Categorie> getAllCategories();
}
