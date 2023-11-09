package com.ahmed.personne;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ahmed.personne.entities.Categorie;
import com.ahmed.personne.entities.Personne;
import com.ahmed.personne.repos.PersonneRepository;

@SpringBootTest
class PersonneApplicationTests {

	@Autowired
	private PersonneRepository perRepository;
	
	@Test
	public void testAjouterPersonne() {
	Personne per = new Personne("aaa","Mrabet",23,new Date());
	perRepository.save(per);
	}
	
	@Test
	public void testFindPersonne()
	{
	Personne p = perRepository.findById(20L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdatePersonne()
	{
	Personne p = perRepository.findById(40L).get();
	p.setAgePersonne(24);
	p.setNomPersonne( "NNNNN");
	p.setPrenomPersonne("aAAaa");
	perRepository.save(p);
	}
	@Test
	public void testDeletePersonne()
	{
		perRepository.deleteById(1L);;
		}
		 
		@Test
		public void testListerTousProduits()
		{
		List<Personne> per = perRepository.findAll();
		for (Personne p : per)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void testFindByNomProduit()
		{
		List<Personne> per= perRepository.findBynomPersonne("mohamed");
		for (Personne p : per)
		{
		System.out.println(p);
		}
		}
	
		@Test
		public void testfindBynomage()
		{
		List<Personne> per= perRepository.findBynomage("ahmedddd",24);
		for (Personne p : per)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void testfindByCategorie()
		{
		Categorie cat = new Categorie(); 
		cat.setIdCat(1L); //afficher les produits de catégorie 1
		List<Personne> per = perRepository.findByCategorie(cat);
		for (Personne p : per)
		{
		System.out.println(p);
		}
		}
		
}
