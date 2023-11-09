package com.ahmed.personne.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Personne {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private int agePersonne;
	private Date datePersonne;
	
	@ManyToOne 
    @JoinColumn(name = "idCat")

	private Categorie categorie ;

	
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nomPersonne, String prenomPersonne, int agePersonne, Date datePersonne) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.agePersonne = agePersonne;
		this.datePersonne = datePersonne;
	
	}

	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public int getAgePersonne() {
		return agePersonne;
	}

	public void setAgePersonne(int agePersonne) {
		this.agePersonne = agePersonne;
	}

	public Date getDatePersonne() {
		return datePersonne;
	}

	public void setDatePersonne(Date datePersonne) {
		this.datePersonne = datePersonne;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne=" + nomPersonne + ", prenomPersonne="
				+ prenomPersonne + ", agePersonne=" + agePersonne + ", datePersonne=" + datePersonne + "]";
	}

	public void setCategorieById(Long idCat) {
		// TODO Auto-generated method stub
		
	}

	public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
	

	



	
}
