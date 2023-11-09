package com.ahmed.personne.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.personne.entities.Categorie;
import com.ahmed.personne.repos.CategorieRepository;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping("/getAll")
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getCategoryById(@PathVariable Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Categorie createCategory(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @PutMapping("/{id}")
    public Categorie updateCategory(@PathVariable Long id, @RequestBody Categorie updatedCategorie) {
        return categorieRepository.findById(id)
                .map(categorie -> {
                    categorie.setNomCat(updatedCategorie.getNomCat());
                    // Set other properties if needed
                    return categorieRepository.save(categorie);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }
}
