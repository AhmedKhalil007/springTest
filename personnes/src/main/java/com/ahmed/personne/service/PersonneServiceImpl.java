package com.ahmed.personne.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.personne.entities.AgeDistributionEntry;
import com.ahmed.personne.entities.Categorie;
import com.ahmed.personne.entities.InscriptionDistribution;
import com.ahmed.personne.entities.Personne;
import com.ahmed.personne.repos.CategorieRepository;
import com.ahmed.personne.repos.PersonneRepository;

@Service
public class PersonneServiceImpl implements PersonneService {

	@Autowired
	PersonneRepository perRepository ;
	CategorieRepository catRepository;
	
	@Autowired
    public PersonneServiceImpl(PersonneRepository perRepository, CategorieRepository catRepository) {
        this.perRepository = perRepository;
        this.catRepository = catRepository; // Initialisation de catRepository
    }
	
	@Override
	//public Personne AjouterPersonne(Personne p) {
	//	return perRepository.save(p);
//	}
	public Personne AjouterPersonne(Personne p) {
	    return perRepository.save(p);
	}

	@Override
	public Personne UpdatePersonne(Personne p) {
		
		return perRepository.save(p);
	}

	@Override
	public void deletePersonne(Personne p) {
		perRepository.delete(p);
		
	}

	@Override
	public void deletePersonneById(Long id) {
		 perRepository.deleteById(id);
		
	}

	@Override
	public Personne getPersonneById(Long id) {
		
		return perRepository.findById(id).get();
	}

	@Override
	public List<Personne> getAllPersonnes() {
		
		return perRepository.findAll();
	}
	
	//public List<AgeDistributionEntry> calculateAgeDistribution() {
      //  List<Personne> personnes = perRepository.findAll();
      //  Map<Integer, Long> ageCounts = personnes.stream()
            //    .collect(Collectors.groupingBy(Personne::getAgePersonne, Collectors.counting()));

       // List<AgeDistributionEntry> ageDistribution = ageCounts.entrySet().stream()
              //  .map(entry -> new AgeDistributionEntry(entry.getKey(), entry.getValue()))
               // .collect(Collectors.toList());

     //   return ageDistribution;
  //  }
	
	@Override
	public List<AgeDistributionEntry> calculateAgeDistribution() {
	    List<Personne> personnes = perRepository.findAll();
	    Map<Integer, Long> ageCounts = personnes.stream()
	            .collect(Collectors.groupingBy(Personne::getAgePersonne, Collectors.counting()));

	    List<AgeDistributionEntry> ageDistribution = ageCounts.entrySet().stream()
	            .map(entry -> new AgeDistributionEntry(entry.getKey(), entry.getValue()))
	            .collect(Collectors.toList());

	    return ageDistribution;
	}
	
	

	@Override
	public List<AgeDistributionEntry> getAgePersonne() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	 @SuppressWarnings("deprecation")
	public List<InscriptionDistribution> calculateInscriptionDistribution() {
	        List<InscriptionDistribution> distributionList = new ArrayList<>();

	        // Récupérer toutes les personnes
	        List<Personne> personnes = perRepository.findAll();

	        // Créer un objet de type InscriptionDistribution pour chaque mois d'inscription et compter le nombre de personnes correspondant
	        for (int month = 1; month <= 12; month++) {
	            int count = 0;
	            for (Personne personne : personnes) {
	                if (personne.getDatePersonne().getMonth() == month) {
	                    count++;
	                }
	            }
	            InscriptionDistribution distribution = new InscriptionDistribution(month, count);
	            distributionList.add(distribution);
	        }

	        return distributionList;
	    }

	
}
