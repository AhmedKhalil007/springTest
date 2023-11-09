package com.ahmed.personne.service;

import java.util.List;

import com.ahmed.personne.entities.AgeDistributionEntry;
import com.ahmed.personne.entities.InscriptionDistribution;
import com.ahmed.personne.entities.Personne;

public interface PersonneService {

	Personne UpdatePersonne(Personne p);
	void deletePersonne(Personne p);
	void deletePersonneById(Long id);
	Personne getPersonneById(Long id);
	List<Personne> getAllPersonnes();
	List<AgeDistributionEntry> getAgePersonne();
	List<AgeDistributionEntry> calculateAgeDistribution();
	List<InscriptionDistribution> calculateInscriptionDistribution();
	Personne AjouterPersonne(Personne p, Long idCat);
}
