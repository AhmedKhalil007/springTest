package com.ahmed.personne.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahmed.personne.api.ApiResponse;
import com.ahmed.personne.entities.AgeDistributionEntry;
import com.ahmed.personne.entities.Categorie;
import com.ahmed.personne.entities.InscriptionDistribution;
import com.ahmed.personne.entities.Personne;
import com.ahmed.personne.service.CategorieService;
import com.ahmed.personne.service.PersonneService;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
 // pour dire qu’il s’agit d’un controlleur
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {

	@Autowired
	public PersonneController(PersonneService personneService, CategorieService categorieService) {
        this.personneService = personneService;
        this.categorieService = categorieService;
    }
	PersonneService personneService; // demande à spring de nous //injecter un object qui implémente l’interface produitService
	CategorieService categorieService;
	@RequestMapping("/ajouterPersonnes")// lorsque la demande url est //showCreateje vais retourner la vue CreateProduit.jsp
	public String showAjouter()
	{
	return "ajouterPersonnes"; // le nom de la jsp
	}
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
	}
	
	@RequestMapping("/deletePersonnes")
	public String delete()
	{
		return "deletePersonnes";
	}
	
	@RequestMapping("/updatePersonnes")
	public String update()
	{
		return "updatePersonnes";
	}
	
	//@RequestMapping("/savePersonne") //l’action
	//public String savePersonne(@ModelAttribute("personne") Personne personne, 
	//@RequestParam("date") String date,
	//ModelMap modelMap) throws ParseException
	
	//{
	//conversion de la date 
	//SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	//Date datePersonne = dateformat.parse(String.valueOf(date));
	//personne.setDatePersonne (datePersonne);
	//Personne savePersonne = personneService.AjouterPersonne(personne);
	//enregister le produit dans la base de donnée
	//String msg = "personne enregistré avec Id "+savePersonne.getIdPersonne();
	//modelMap.addAttribute("msg", msg);
	
	//return "ajouterPersonnes";
	//}
	@PostMapping("/savePersonne" )
	public ResponseEntity<ApiResponse> savePersonne(@RequestBody Personne personne) {
	    try {
	        Personne savePersonne = personneService.AjouterPersonne(personne);
	        String msg = "personne enregistrée avec l'ID " + savePersonne.getIdPersonne();
	        ApiResponse response = new ApiResponse(msg);
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        e.printStackTrace(); // Gérer l'exception de manière appropriée
	        ApiResponse response = new ApiResponse("Erreur lors de l'ajout de la personne");
	        return ResponseEntity.status(500).body(response);
	    }
	}
	@GetMapping("/categories")
	@ResponseBody
	public List<Categorie> getAllCategories() {
	    List<Categorie> categories = categorieService.getAllCategories();
	    categories.forEach(categorie -> categorie.setPersonnes(null));
	    return categories;
	}
	
	
	@GetMapping ("/listePersonne")
	public String listePersonnes(ModelMap modelMap )
	{
	List<Personne> per = personneService.getAllPersonnes();
	modelMap.addAttribute("personne", per);
	return "listePersonne";
	}
	
	//@DeleteMapping("/deletePersonne")
	 // public String deletePersonne(@RequestParam(value = "idPersonne") Long idPersonne,ModelMap modelMap) throws ParseException
	//{
		//personneService.deletePersonneById(idPersonne);
		//String msg2 = "produit  avec Id "+ idPersonne + "est supprimé";
		//modelMap.addAttribute("msg2", msg2);
	   // return "ajouterPersonne";

	//}
	
	//@RequestMapping("/deletePersonne/{idPersonne}")
	 //public String deleteById(@PathVariable Long idPersonne) {
		//personneService.deletePersonneById(idPersonne);
		 //return "ajouterPersonne";
	 //}
	@RequestMapping("/deletePersonne")
	 public String deleteByName(@RequestParam(value = "idPersonne") Long idPersonne , ModelMap modelMap) throws ParseException {
	personneService.deletePersonneById(idPersonne);	
	String msg2 = "Personne  avec Id "+ idPersonne  +  "est supprimé";
	modelMap.addAttribute("msg2", msg2);
		return "deletePersonnes";
	  }

	
	
	
	@RequestMapping("/updatePersonne") 
	public String updatePersonne(@ModelAttribute("personne") Personne personne, 
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date datePersonne = dateformat.parse(String.valueOf(date));
		personne.setDatePersonne (datePersonne);
		Personne updatePersonne = personneService.UpdatePersonne(personne);
		String msg3 = "Personne  avec Id "+ updatePersonne.getIdPersonne()  +  "est mis à jour";
		modelMap.addAttribute("msg3", msg3);
		return "updatePersonnes";

	}
	
	
	    
//	@GetMapping("/ageDistribution")
  //  public List<AgeDistributionEntry> getAgeDistribution() {
    //    List<Personne> personnes = personneService.getAllPersonnes();
    //    Map<Integer, Long> ageCounts = personnes.stream()
        //        .collect(Collectors.groupingBy(Personne::getAgePersonne, Collectors.counting()));

     //   List<AgeDistributionEntry> ageDistributions = ageCounts.entrySet().stream()
       //         .map(entry -> new AgeDistributionEntry(entry.getKey(), entry.getValue()))
        //        .collect(Collectors.toList());
//
      //  return ageDistributions;
    //}
	
	
	
	@GetMapping("/ageDistribution")
	public ResponseEntity<List<AgeDistributionEntry>> getAgeDistribution() {
	    List<AgeDistributionEntry> ageDistributions = personneService.calculateAgeDistribution();
	    return ResponseEntity.ok(ageDistributions);
	}
	
	@RequestMapping("/graph")
	public String graph()
	{
		return "ageDistribution";
	}
	
	
	@GetMapping("/inscriptionDistributions")
    public ResponseEntity<List<InscriptionDistribution>> getInscriptionDistribution() {
	    List<InscriptionDistribution> inscriptiondistrub = personneService.calculateInscriptionDistribution();
		return ResponseEntity.ok(inscriptiondistrub);
    }
	
	@RequestMapping("/graphmois")
	public String graphmois()
	{
		return "inscriptionDistribution";
	}
	
	
	
	
	
	
}

