package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping
@RestController
public class ProduitController {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(value="/listProduits")
   public List<Produit> getProduits(){
	return produitRepository.findAll();	
}
	
	@GetMapping("/listProduits/{id}")
	public Optional<Produit> getProduitById(@PathVariable Long id){
		return produitRepository.findById(id);
	}

	@PostMapping("/listProduits")
	 public Produit createProduit(@RequestBody Produit produit) {
		 return produitRepository.save(produit);
	 }
	
	@PutMapping("/listProduits/{id}")
	public Produit updateProduit(@PathVariable Long id , @RequestBody Produit produit) {
		produit.setId(id);
		return produitRepository.save(produit);
	}
	@DeleteMapping("/listProduits/{id}")
	public boolean supprimerProduit(@PathVariable Long id) {
		produitRepository.deleteById(id);
		return true ;
	}
	//@GetMapping("/chercher")
	//public List<Produit> getProduitsParDesignation(){
	//	return produitRepository.findByDesignationContains("");
	//}
}