package com.ahmed.personne.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data


@AllArgsConstructor
@Entity
	public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;

	
	@OneToMany(mappedBy = "categorie")
	private List<Personne> Personnes;
	
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public List<Personne> getPersonnes() {
		return Personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		Personnes = personnes;
	}
	
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}
	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + ", Personnes=" + Personnes + "]";
	}
	
	
	}

