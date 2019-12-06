package com.comm.comm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.comm.comm.dao.ProductDao;
import com.comm.comm.exceptions.ProduitIntrouvableException;
import com.comm.comm.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Gestion des produits")
@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	
	//Produits
	@GetMapping(value = "Produits")
	public List<Product> listeProduits(){
		return productDao.findAll();
		
	}
	
	//Produits/{id}
	@ApiOperation("Récupere un produit selon son id")
	@GetMapping(value = "Produits/{id}")
	public Product afficherUnProduit(@PathVariable int id) throws ProduitIntrouvableException {

	       Product produit = productDao.findById(id);

	       if(produit==null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. ");

	       return produit;
	
	}	
	
	@PostMapping(value = "/Produits")
	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Product product) {
		
	Product product1=productDao.save(product);
	if(product==null) {
		return ResponseEntity.noContent().build();
	}
	URI location= ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(product1.getId())
			.toUri();
	return ResponseEntity.created(location).build();
	}
	
	
	
	
	
	//Produits/{prixLimit}
	@GetMapping(value = "test/Produits/{prixLimit}")
	public List<Product> testeDeRequetes(@PathVariable int prixLimit) {
	  
	    return productDao.chercherUnProduitCher(prixLimit);
	}	
	
	//Produits/{name}
	@GetMapping(value = "test/Produit/{name}")
	public List<String> cherche(@PathVariable String name) {
	  
	    return productDao.cherch(name);
	}

}

